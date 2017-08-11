(ns myapp-reframe.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [ajax.core :refer [GET POST]]
            [myapp-reframe.ajax :refer [load-interceptors!]]
            [myapp-reframe.handlers]
            [myapp-reframe.subscriptions])
  (:import goog.History))

(defn get-by-id [id] (.-value (.getElementById js/document id)))

(defn log [& params] (.log js/console (apply str params)))

(def server "http://localhost:3000/")

(defn error-handler [] (log "error!"))



(defn nav-link [uri title page collapsed?]
  (let [selected-page (rf/subscribe [:page])]
    (when (= @selected-page :counter)
      (rf/dispatch [:reset-count]))
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
      [:a.navbar-brand {:href "#/"} "Todo App!"]
      [:ul.nav.navbar-nav
       [nav-link "#/" "Home" :home collapsed?]
       [nav-link "#/about" "About" :about collapsed?]
       [nav-link "#/counter" "Counter" :counter collapsed?]]]]))

(defn counter-page []
  [:div.container
   [:div.row
    [:div.col-md-12
     [:h2 (str "Value of count : " @(rf/subscribe [:count]))]
     [:input {:type "button" :value "Inc" :on-click #(rf/dispatch [:inc-count])}]]]])

(defn about-page []
  [:div.container
   [:div.row
    [:div.col-md-12
     [:img {:src (str js/context "/img/warning_clojure.png")}]]]])


(defn mark-done
  "changes the status of a task to complete"
  [task]
  (GET (str server "done")
       {:params {:user @(rf/subscribe [:user])
                 :task task}
        :format :json
        :response-format :json
        :keywords? true
        :handler #(rf/dispatch [:update-task %])
        :error-handler error-handler}))


(defn show-tasks
  "shows the task, the status, and a button to mark the task complete if it is incomplete"
  [map-task]
  (log map-task)
  (let [task (:task map-task)
        status (:status map-task)]
    (log task status)
    [:div
     (if-not (= "Complete" status)
       (do [:li.task task
            [:input.markdone {:type "button" :value "Mark done" :on-click #(mark-done task)}]])
       [:li.taskdone  [:strike task]])]))



(defn c-show-output
  []
  [:ul
   (doall (map show-tasks @(rf/subscribe [:task])))])




(defn login-handler
  [flag]
  (if flag
    (do (secretary/dispatch! "/todo")
        (GET (str server "tasks")
             {:params {:user @(rf/subscribe [:user])}
              :format :json
              :response-format :json
              :keywords? true
              :handler #(rf/dispatch [:update-task %])
              :error-handler error-handler})
        (log "@@@@@ logged in: "@(rf/subscribe [:task])))
    (js/alert "Incorrect Username or Password")))


(defn todo-page []
  [:div
   [:h2 "Todo-list"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [t (get-by-id "todo-input")]
                          (if-not (empty? t)
                            (GET (str server "todo")
                                 {:params {:task t
                                           :user @(rf/subscribe [:user])}
                                  :format :json
                                  :response-format :json
                                  :keywords? true
                                  :handler #(rf/dispatch [:update-task %])
                                  :error-handler error-handler}))))}
    [:div [:input {:type "text"
                   :id "todo-input"}]
     [:input {:type "submit" :value "Add-task"}]
     [:input {:type "button" :value "Logout" :on-click #(secretary/dispatch! "/")}]]
    [:div [:h2 "all tasks"]
     [c-show-output]]]])


(defn home-page []
  [:div
   [:h6 "Author : Bhavesh Yadav"]
   [:h2 "Login Page"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [user (get-by-id "user")
                              pass (get-by-id "pass")]
                          (rf/dispatch [:set-user user])
                          (GET (str server "user")
                               {:params {:user user
                                         :password pass}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler login-handler
                                :error-handler error-handler})))}
    [:div.row [:h4.col-md-2 "Username"] [:input.col-md-3 {:type "text" :id "user"}]]
    [:div.row [:h4.col-md-2 "Password"] [:input.col-md-3 {:type "text" :id "pass"}]]
    [:div [:input.buttonclass {:type "submit" :value "Login"}]]]
   [:h2.quote-head "Quote of the day!"]
   [:p.quote "Successful people always have two things on their lips, 1. Silence 2. Smile"]])

(def pages
  {:home #'home-page
   :about #'about-page
   :counter #'counter-page
   :todo #'todo-page})

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

(secretary/defroute "/todo" []
  (rf/dispatch [:set-active-page :todo]))

(secretary/defroute "/counter" []
  (rf/dispatch [:set-active-page :counter]))
;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listenpp
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
