(ns test-reframe.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [ajax.core :refer [GET POST]]
            [test-reframe.ajax :refer [load-interceptors!]]
            [test-reframe.handlers]
            [test-reframe.subscriptions])
  (:import goog.History))



(defn get-by-id
  [id]
  (.-value (.getElementById js/document id)))

(defn login-error
  []
  (js/alert "error"))

(def server "http://localhost:3000/")

(defn log [& params]
  (.log js/console (apply str params)))


(defn error-handler []
  ([:div.alert1
    [:span.close]]))

(defn nav-link [uri title page collapsed?]
  (let [selected-page (rf/subscribe [:page])]
    (if (= @selected-page :counter)
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
      [:a.navbar-brand {:href "#/"} "TO DO"]
      [:ul.nav.navbar-nav
       [nav-link "#/" "Home" :home collapsed?]
       #_[nav-link "#/about" "About" :about collapsed?]
       #_[nav-link "#/count" "Count-page" :counter collapsed?]
       [nav-link "#/todo" "todo-page" :counter collapsed?]
       #_[nav-link "#/update" "update-page" :update collapsed?]]]]))


(defn h-atom!
  [response]
  (log (rf/dispatch [:insert-task response])))


(defn login-handler
  [flag]
  #_(log "@@@@ 1" flag)
  (if flag
    (secretary/dispatch! "/todo" )
      (GET (str server "tasks")
              {:params {:user @(rf/subscribe [:user])}
               :format :json
               :response-format :json
               :keywords? true
               :handler #(rf/dispatch :task %)
               :error-handler error-handler})))




(defn mark-done
  [task]
  (js/alert "Task removed")
  (GET (str server "done")
       {:params {:user @(rf/subscribe [:user])
                 :task task}
        :format :json
        :response-format :json
        :keywords? true
        :handler #(rf/dispatch [:update-task %])
        :error-handler error-handler}))


(defn update-task
  [task]
  (let [new-task (js/prompt (str "Old Task : " task "\n Enter new task :"))]
    (if new-task (GET (str server "update")
                      {:params {:task task
                                :new-task new-task
                                :user @(rf/subscribe [:user])}
                       :format :json
                       :response-format :json
                       :keywords? true
                       :handler #(rf/dispatch [:update-task %])
                       :error-handler error-handler}))))

(defn show-tasks
  [map-task]
  (let [task (:task map-task)
        status (:status map-task)]
    (if-not (= "Complete" status)
      (do
        [:div.container
         [:div.form-group [:input.form-control {:type "text" :value task}]]
         [:div.form-group [:input.form-control {:type "text" :value status}]]
         [:div.form-group [:input.btn.btn-primary {:type "button" :value "done?" :on-click #(mark-done task)}]
          [:input.btn.btn-warning {:type "button"
                                   :value "Update?"
                                   :on-click #(update-task task)}]]]))))




(defn show-output
  []
  [:ul
   (doall (map show-tasks @(rf/subscribe [:task])))])




(defn home-page []
  [:div.container
   [:h2 "Login Page"]

   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [user (get-by-id "user")
                              pass (get-by-id "pass")]
                          (rf/dispatch [:cur-user user])
                          (js/alert "Login successfully")
                          (GET (str server "user")
                               {:params {:user user
                                         :password pass}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler login-handler
                                :error-handler login-error})))}
    [:div.form-group[:input.form-control {:type "text" :id "user"}]]
    [:div.form-group [:input.form-control {:type "text" :id "pass"} ]]
    [:div [:input.btn.btn-primary.form-control {:type "submit" :value "Login"}]]]])

(defn todo-page []
  [:div.container
   [:div.col-md-6
    [:h2 "Todo-list"]
    [:form {:action "#" :method "get"
            :on-submit (fn [e]
                         (let [t (get-by-id "todo-input") ]
                           (GET (str server "todo")
                                {:params {:task t
                                          :user @(rf/subscribe [:user])}
                                 :format :json

                                 :response-format :json
                                 :keywords? true
                                 :handler #(rf/dispatch [:update-task %])
                                 :error-handler error-handler})))}
     [:div.form-group [:input.form-control {:type "text"
                                            :id "todo-input"}]]
     [:div.form-group [:input.form-control {:type "submit" :value "Add-task"}]]
     [:div.form-group [:input.btn.btn-primary.form-control {:type "button"  :value "Logout" :on-click #(secretary/dispatch! "/")}]]]]
   [:div.col-md-6
    [:h2 "Your tasks"]
    [show-output]]])

#_(defn update-page
  []
  [:div.container
   [:h2 "Todo-list"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [old-t (get-by-id "old-task")
                              new-t (get-by-id "new-task")]

                          (secretary/dispatch! "/")))}
    #_[show-tasks-update]
    [:div.form-group [:input.form-control {:type "text"
                                           :id "old-task"
                                           :placeholder "Enter old task"}]]
    [:div.form-group [:input.form-control {:type "text"
                                           :id "new-task"
                                           :placeholder "Enter new task"}]]
    [:div.form-group [:input.btn.btn-primary.form-control {:type "submit"  :value "Update Task" }]]]])



(def pages
  {:home #'home-page
   :todo #'todo-page
 })

(defn page []
  [:div
   [navbar]
   [(pages @(rf/subscribe [:page]))]])




(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (rf/dispatch [:set-active-page :home]))

#_(secretary/defroute "/about" []
  (rf/dispatch [:set-active-page :about]))

(secretary/defroute "/todo" []
  (rf/dispatch [:set-active-page :todo]))

#_(secretary/defroute "/count" []
    (rf/dispatch [:set-active-page :counter]))

#_(secretary/defroute "/update" []
  (rf/dispatch [:set-active-page :update]))


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



(defn mount-components []
  (rf/clear-subscription-cache!)
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (rf/dispatch-sync [:initialize-db])
  (load-interceptors!)
  (hook-browser-navigation!)
  (mount-components))
