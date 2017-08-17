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
            [reframe-todo.subscriptions]
            [soda-ash.core :as sa])
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
  (log "ERROR @@@" response))

(defn add-todo
  [response]
  (log response)
  (let [body (:content response)
        tasks (mapv #(:task %) body)]
    (rf/dispatch  [:set-tasks tasks])))



(defn user-valid
  [response]
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
  #_(log "Status Change" id)
  #_(log "TExt:" (.-innerText (.getElementById js/document id)))
  #_(set! (.-disabled (.getElementById js/document id))
        true)
  (GET (str server "mark-done")
       {:params {:user @(rf/subscribe [:current-user])
                 :task (.-innerText (.getElementById js/document id))}
        :format :json
        :response-format :json
        :keywords? true
        :handler add-todo
        :error-handler error-handler}))

(defn updated-todo
  [id]
  (let [orig (.-innerText (.getElementById js/document id))]
    (set! (.-value (.getElementById js/document "original-task"))
          orig)))

(defn c-todo
  []
  [:div.flex-container
   (doall  (for [i (range (count @(rf/subscribe [:tasks])))]
             ^{:key i} [sa/Card
                        [sa/CardContent
                         [sa/CardDescription [:p {:id i} (get @(rf/subscribe [:tasks]) i)]]]
                        [:div.ui.buttons
                         [sa/Button {:on-click #(update-status-done i)} "Completed?" ]
                         [:div.or]
                         [sa/Button {:on-click #(updated-todo i)} "Update?"]]]))])

(defn todo-page []
 [:div.container
   [:div.row
    [:div.col-md-6
     [:form {:action "#" :method "get"
             :on-submit (fn [e]
                          (let [t (get-input "task")]
                            #_(log "tttttt" t)
                            (GET (str server "todo")
                                 {:params {:user @(rf/subscribe [:current-user])
                                           :task t}
                                  :format :json
                                  :response-format :json
                                  :keywords? true
                                  :handler add-todo
                                  :error-handler error-handler})))}
      [:h2.text-center "Add Task"]
      [:div.form-group [:input.form-control {:type "text" :id "task" :placeholder "Enter Task"}]]
      [:div.form-group [:input.form-control.btn.btn-block.btn-success {:type "submit" :value "Add"}]]
      [:div.form-group [:input.form-control.btn.btn-block.btn-warning {:value "Log Out" :on-click #(secretary/dispatch! "/")}]]]]
    [:div.col-md-6
     [:h2.text-center "Update Task"]
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
                                  :handler add-todo
                                  :error-handler error-handler})))}
      [:div.form-group [:input.form-control {:type "text" :id "original-task" :placeholder "Enter Original Task"}]]
      [:div.form-group [:input.form-control {:type "text" :id "updated-task" :placeholder "Enter Updated Task"}]]
      [:div.form-group [:input.form-control.btn.btm-block.btn-success {:type "submit" :value "Update" }]]]]]
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
      [:a.navbar-brand {:href "#/"} "TO-DO App"]
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
    [:div.form-group [:input.form-control {:type "text" :id "username" :placeholder "Enter Username" }]]
    [:div.form-group [:input.form-control {:type "password" :id "password" :placeholder "Enter Password"}]]
    [:div.form-group [:input.form-control.btn.btn-primary {:type "submit" :value "Submit"}]]]])

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
