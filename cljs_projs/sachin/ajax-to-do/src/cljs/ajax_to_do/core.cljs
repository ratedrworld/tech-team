(ns ajax-to-do.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [ajax.core :refer [GET POST]]
            [accountant.core :as accountant]
            [secretary.core :as secretary :refer-macros [defroute]]))


(accountant/configure-navigation! {:nav-handler (fn [path]
                                                  (secretary/dispatch! path))
                                   :path-exists? (fn [path]
                                                   (secretary/locate-route path))})

(defn log
  [& msgs]
  (.log js/console (apply str msgs)))


#_(def task-atom (r/atom {:current-user ""

                        :tasks []}))

  (def server "http://localhost:3000/")


(defn get-input
  [id]
  (.-value (.getElementById js/document id)))

(defn do-nothing
  [[response]]
  (log "%%%%" response))

(defn error-handler
  [response]
  (log "@@@@@@@@@@@@" response))

(defn add-todo
  [[response]]
  (let [body (:content response)
        tasks (mapv #(:task %) body)]
    #_(swap! task-atom assoc-in [:tasks] tasks)
    (session/put! :tasks tasks)))

(defn user-valid
  [[response]]
  (let [auth (:auth response)
        user (:user response)]
    #_(log "USERVALID")
    (if auth
      (do #_(swap! task-atom assoc-in [:current-user] user)
          #_(js/alert "Changing route")
          (session/put! :current-user user)
          (secretary/dispatch! "/todos")
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
  (set! (.-disabled (.getElementById js/document id))
        true)
  (GET (str server "mark-done")
       {:params {:user (session/get :current-user)
                 :task (get-input id)}
        :format :json
        :response-format :json
        :keywords? true
        :handler do-nothing
        :error-handler error-handler}))



(defn c-todo
  []
  [:div
   [:h3 "TASK-LIST"]
   (doall  (for [i (range (count (session/get :tasks)))]
             [:input {:type "button"
                      :id i
                      :value (get (session/get :tasks) i)
                      :on-click #(update-status-done i)}]))])

(defn login-page []
  [:div.container
   [:div.row
    [:form {:action "#"
            :on-submit (fn [e]
                         (let [u (get-input "user-name")
                               p (get-input "password")]
                           (GET (str server "auth")
                                {:params {:user u
                                          :pass p}
                                 :format :json
                                 :response-format :json
                                 :keywords? true
                                 :handler user-valid
                                 :error-handler error-handler})))}
     [:h1 "Login"]
     [:div.row-xs-4  [:input {:type "text" :id "user-name" :placeholder "Enter Username" :class "form-control"}]]
     [:div.row-xs-4 [:input {:type "password" :id "password" :placeholder "Enter Password" :class "form-control"}]]
     [:div [:input {:type "submit" :value "Submit"}]]]]])

#_(defn to-do-page []
  [:div.container
   [:h1 "TO-DO LIST"]
   [:table
     [:tbody
      [:tr
       [:td
        [:h2 "Add Task"]
        [:form {:action "#"
                :on-submit (fn [e]
                             (let [t (get-input "task")]
                               (GET (str server "todo")
                                    {:params {:task t
                                              :user (session/get :current-user)}
                                     :format :json
                                     :response-format :json
                                     :keywords? true
                                     :handler add-todo
                                     :error-handler error-handler})))}
         [:input {:type "text" :id "task" :placeholder "Enter Task"}]
         [:input {:type "submit" :value "Add"}]
         [:input {:type "button" :value "Log Out" :on-click #(secretary/dispatch! "/")}]]]
       [:td
        [:h2 "Update Task"]
        [:form {:action "#"
                :on-submit (fn [e]
                             (let [orig (get-input "original-task")
                                   upd (get-input "updated-task")]
                               (GET (str server "update-todo")
                                    {:params {:user (session/get :current-user)
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
      [:tr
       [c-todo]]]]])

(defn to-do-page []
  [:div.container
   [:h1 "TO-DO LIST"]
   [:div.row
    [:div.col-md-6
     [:form {:action "#"
                :on-submit (fn [e]
                             (let [t (get-input "task")]
                               (GET (str server "todo")
                                    {:params {:task t
                                              :user (session/get :current-user)}
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
                                 {:params {:user (session/get :current-user)
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


(secretary/set-config! :prefix "#")



(defn page []
  [(session/get :current-page)])

(defroute "/" []
  (session/put! :current-page login-page))

(defroute "/todos" []
  (session/put! :current-page to-do-page))

#_(session/put! :current-page login-page)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




;; -------------------------
;; Initialize app



(defn mount-components []
  (session/put! :current-page login-page)
  (session/put! :current-user "")
  (session/put! :tasks [])
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
