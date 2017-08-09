(ns ajax-to-do.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [ajax.core :refer [GET POST]]
            [secretary.core :as secretary :refer-macros [defroute]]))

(defn log
  [& msgs]
  (.log js/console (apply str msgs)))


(def task-atom (r/atom {:current-user ""

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
    (swap! task-atom assoc-in [:tasks] tasks)))

(defn user-valid
  [[response]]
  (let [auth (:auth response)
        user (:user response)]
    #_(log "USERVALID")
    (if auth
      (do (swap! task-atom assoc-in [:current-user] user)
          #_(js/alert "Changing route")
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
       {:params {:user (:current-user @task-atom)
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
   (doall  (for [i (range (count (:tasks @task-atom)))]
             [:input {:type "button"
                      :id i
                      :value (get (:tasks @task-atom) i)
                      :on-click #(update-status-done i)}]))])




(defn login-page []
  [:div
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
    [:h2 "Login"]
    [:div [:input {:type "text" :id "user-name"}]]
    [:div [:input {:type "text" :id "password"}]]
    [:div [:input {:type "submit" :value "Submit"}]]]])

(defn to-do-page []
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
                                              :user (:current-user @task-atom)}
                                     :format :json
                                     :response-format :json
                                     :keywords? true
                                     :handler add-todo
                                     :error-handler error-handler})))}
         [:input {:type "text" :id "task"}]
         [:input {:type "submit" :value "Add"}]
         [:input {:type "button" :value "Log Out" :on-click #(secretary/dispatch! "/")}]]]
       [:td
        [:h2 "Update Task"]
        [:form {:action "#"
                :on-submit (fn [e]
                             (let [orig (get-input "original-task")
                                   upd (get-input "updated-task")]
                               (GET (str server "update-todo")
                                    {:params {:user (:current-user @task-atom)
                                              :task orig
                                              :new-task upd}
                                     :format :json
                                     :response-format :json
                                     :keywords? true
                                     :handler do-nothing
                                     :error-handler error-handler})))}
         [:input {:type "text" :id "original-task"}]
         [:input {:type "text" :id "updated-task"}]
         [:input {:type "submit" :value "Update" }]]]]
      [:tr
       [c-todo]]]]])


#_(defn home-page []
  [:div  (condp = (:current-page @task-atom)
           :login-page [login-page]
           :to-do-page [to-do-page])])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
