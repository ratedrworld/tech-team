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
            [myapp-reframe.subscriptions]
            [clojure.string :as str])
  (:import goog.History))



(def server "http://localhost:3000/")

(defn get-by-id [id] (.-value (.getElementById js/document id)))

(defn log [& params] (.log js/console (apply str params)))


(defn error-handler [] (log "error!"))

(defn set-by-id [id value] (set! (.-value (.getElementById js/document id))
                                 value))

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
     [:input.btn.btn-primary {:type "button" :value "Inc"
                              :on-click #(rf/dispatch [:inc-count])}]]]])

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

(defn delete-task
  [task]
  (GET (str server "delete")
       {:params {:user @(rf/subscribe [:user])
                 :task task}
        :format :json
        :response-format :json
        :keywords? true
        :handler #(rf/dispatch [:update-task %])
        :error-handler error-handler}))

(defn update-task
  [task]
  (let [new-task (js/prompt (str "Task : " task "\n" "Update with? "))]
    (if new-task
      (GET (str server "update")
           {:params {:user @(rf/subscribe [:user])
                     :task task
                     :new-task new-task}
            :format :json
            :response-format :json
            :keywords? true
            :handler #(rf/dispatch [:update-task %])
            :error-handler error-handler}))))


(defn show-tasks
  "shows the task, the status, and a button to mark the task complete if it is incomplete"
  [map-task]
  (log map-task)
  (let [{:keys [task status]} map-task]
    (log task status)
    [:li
     (if-not (= "Complete" status)
        [:div.task task
         [:div [:input.markdone {:type "button" :value "Mark done" :on-click #(mark-done task)}]
          [:input.markdone {:type "button" :value "Update task" :on-click #(update-task task)}]]]
        [:div.taskdone [:strike task]
         [:div [:input.markdone {:type "button" :value "Delete" :on-click #(delete-task task)}]]])]))

(defn c-show-output
  []
  [:ul
   (doall (map show-tasks @(rf/subscribe [:task])))])

(defn h-login
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
   [:h6 (str "Welcome " @(rf/subscribe [:user]) "!")]
   [:h2.quote-head "Todo-list"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [t (get-by-id "todo-input")]
                          (when-not (empty? t)
                             (set-by-id "todo-input" "")
                             (GET (str server "todo")
                                    {:params {:task t
                                              :user @(rf/subscribe [:user])}
                                     :format :json
                                     :response-format :json
                                     :keywords? true
                                     :handler #(rf/dispatch [:update-task %])
                                     :error-handler error-handler}))))}
    [:div [:input {:type "text"
                   :id "todo-input" :placeholder "Enter a task"}]
     [:input {:type "submit" :value "Add-task"}]
     [:input {:type "button" :value "Logout" :on-click #(secretary/dispatch! "/")}]]
    [:div.quote-head [:h2 "All tasks:"]]
    [c-show-output]]])


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
                                :handler h-login
                                :error-handler error-handler})))}
    [:div.form-group  [:input.form-control.inputclass {:type "text" :id "user" :placeholder "Enter Username"}]]
    [:div.form-group  [:input.form-control.inputclass {:type "text" :id "pass" :placeholder "Enter Password"}]]
    [:div.form-group [:input.form-control.buttonclass {:type "submit" :value "Login"}]]]
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
    (events/listen
      HistoryEventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize app


(defn mount-components []
  (rf/clear-subscription-cache!)
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (rf/dispatch-sync [:initialize-db])
  (load-interceptors!)

  (hook-browser-navigation!)
  (mount-components))
