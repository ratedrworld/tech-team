(ns reframe-todo.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [ajax.core :refer [GET POST]]
            [reframe-todo.ajax :refer [load-interceptors!]]
            [reframe-todo.handlers]
            [reframe-todo.subscriptions])
  (:import goog.History))



(defn log
  [& msgs]
  (.log js/console (apply str msgs)))



(def server "http://localhost:3000/")


(defn get-input
  [id]
  (.-value (.getElementById js/document id)))


(defn error-handler
  [response]
  (log "@@@@@@@@@@@@" response))

(defn add-todo
  [[response]]
  (let [body (:content response)
        tasks (mapv #(:task %) body)]
    (log "!!!!!!!!" @(rf/subscribe [:current-user]))
    (rf/dispatch  [:set-tasks tasks])))


(defn do-nothing
  [[response]]
  (log "######" response))

(defn update-todos
  [[response]]
  (GET (str server "user-todo")
       {:params {:user @(rf/subscribe [:current-user])}
        :format :json
        :response-format :json
        :keywords? true
        :handler add-todo
        :error-handler error-handler}))


(defn user-valid
  [[response]]
  (let [auth (:auth response)
        user (:user response)]
    (if auth
      (do (rf/dispatch [:set-current-user user])
          (rf/dispatch [:set-active-page :todos])
          (GET (str server "user-todo")
               {:params {:user user}
                :format :json
                :response-format :json
                :keywords? true
                :handler add-todo
                :error-handler error-handler}))
      (js/alert "Invalid username / password. Please try again "))))

(defn update-status-done
  [id]
  (log "Status Change")
  (set! (.-disabled (.getElementById js/document id))
        true)
  (GET (str server "mark-done")
       {:params {:user @(rf/subscribe [:current-user])
                 :task (get-input id)}
        :format :json
        :response-format :json
        :keywords? true
        :handler update-todos
        :error-handler error-handler}))

(defn c-todo
  []
  [:div
   [:h3 "TASK-LIST"]
   (doall  (for [i (range (count @(rf/subscribe [:tasks])))]
           ^{:key i}   [:input {:type "button"
                         :id i
                         :value (get @(rf/subscribe [:tasks]) i)
                         :on-click #(update-status-done i)}]))])


(defn todo-page []
  [:div.container
   [:h1 "TO-DO LIST"]
   [:div.row
    [:div.col-md-6
     [:form {:action "#"
                :on-submit (fn [e]
                             (let [t (get-input "task")]
                               (GET (str server "todo")
                                    {:params {:task t
                                              :user @(rf/subscribe [:current-user])}
                                     :format :json
                                     :response-format :json
                                     :keywords? true
                                     :handler add-todo
                                     :error-handler error-handler})))}
      [:div.row
       [:h2 "Add Task"]
       [:input.row.xs-4 {:type "text" :id "task" :placeholder "Enter Task"}]]
      [:div.col [:input {:type "submit" :value "Add"}]
       [:input {:type "button" :value "Log Out" :on-click #(secretary/dispatch! "/")}]]]]
    [:div.col-md-6
     [:h2 "Update Task"]
     [:form {:action "#"
             :on-submit (fn [e]
                          (let [orig (get-input "original-task")
                                upd (get-input "updated-task")]
                            (GET (str server "update-todo")
                                 {:params {:user @(rf/subscribe [:current-user])
                                           :task orig
                                           :new-task upd}
                                  :format :json
                                  :response-format :json
                                  :keywords? true
                                  :handler do-nothing
                                  :error-handler error-handler})))}
      [:input {:type "text" :id "original-task" :placeholder "Enter Original Task"}]
      [:input {:type "text" :id "updated-task" :placeholder "Enter Updated Task"}]
      [:input {:type "submit" :value "Update" }]]]]
   [:div.row
    [c-todo]]])

(defn nav-link [uri title page collapsed?]
  (let [selected-page (rf/subscribe [:page])]
    [:li.nav-item
     {:class (when (= page @selected-page) "active")}
     [:a.nav-link
      {:href uri
       :on-click #(reset! collapsed? true)} title]]))

(defn navbar []
  (r/with-let [collapsed? (r/atom true)]
    [:nav.navbar.navbar-dark.bg-primary
     [:button.navbar-toggler.hidden-sm-up
      {:on-click #(swap! collapsed? not)} "☰"]
     [:div.collapse.navbar-toggleable-xs
      (when-not @collapsed? {:class "in"})
      [:a.navbar-brand {:href "#/"} "reframe-todo"]
      [:ul.nav.navbar-nav
       [nav-link "#/" "Home" :home collapsed?]
       [nav-link "#/about" "About" :about collapsed?]]]]))

(defn about-page []
  [:div.container
   [:div.row
    [:div.col-md-12
     [:img {:src (str js/context "/img/warning_clojure.png")}]]]])

(defn home-page []
  [:div.container
   [:form.form-signin  {:action "#"
                        :on-submit (fn [e]
                                     (let [u (get-input "username")
                                           p (get-input "password")]
                                       (GET (str server "auth")
                                            {:params {:user u
                                                      :pass p}
                                             :format :json
                                             :response-format :json
                                             :keywords? true
                                             :handler user-valid
                                             :error-handler error-handler})))}
    [:h2.form-signin-heading "Please sign in"]
    [:input {:type "text" :id "username" :placeholder "Enter Username" :class "form-control"}]
    [:input {:type "password" :id "password" :placeholder "Enter Password" :class "form-control"}]
    [:input {:type "submit" :value "Submit" :class "btn btn-lg btn-primary btn-block"}]]])

(def pages
  {:home #'home-page
   :about #'about-page
   :todos #'todo-page})

(defn page []
  [:div
   [navbar]
   [(pages @(rf/subscribe [:page]))]])

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (rf/dispatch [:set-active-page :home]))

(secretary/defroute "/about" []
  (rf/dispatch [:set-active-page :about]))

(secretary/defroute "/todos" []
  (rf/dispatch [:set-active-page :todos]))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
      HistoryEventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize app
(defn fetch-docs! []
  (GET "/docs" {:handler #(rf/dispatch [:set-docs %])}))

(defn mount-components []
  (rf/clear-subscription-cache!)
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (rf/dispatch-sync [:initialize-db])
  (load-interceptors!)
  (fetch-docs!)
  (hook-browser-navigation!)
  (mount-components))
