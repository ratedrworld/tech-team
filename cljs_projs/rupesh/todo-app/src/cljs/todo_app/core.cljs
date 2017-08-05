(ns todo-app.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]])
  (:import goog.History))




(def server "http://localhost:3000/")


(def status (r/atom {}))

(def select-page (r/atom {:current-user " "
                          :current-page "login-page"}))

(defn h-atom
  [response]
  (if (:status response)
    (reset! status (:content response))
    (js/alert "insertion failed")))

(defn get-by-id
  [id]
  (.getElementById js/document id))


(defn log [& params]
  (.log js/console (apply str params)))


(defn print-tasks
  [task]
  [:div [:input {:type "text" :value (:task task)}]])

(defn show-output
  []
  [:div [:ul
         (map print-tasks @status)]])




(defn user-handler
  [output]
  (let [auth (:auth output)
        user (:user output)]
    (if auth
      (swap! select-page {:current-user user
                          :current-page "home-page"}))))

(defn login-page
  []
  [:div
   [:h2 "Login Page"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [user (.-value (get-by-id "username"))
                              pass (.-value (get-by-id "password"))]
                          (GET (str server "user")
                               {:params {:user user
                                         :pass pass}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler user-handler})))}

    [:div
     [:input {:type "text"
              :placeholder "enter name"
              :id "username"}]
     [:input {:type "text"
              :placeholder "enter password"
              :id "password"}]
     [:input {:type "submit" :value "Submit"}]]]])


(defn home-page []
  [:div
   [:h2 "Enter task=>"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [t1 (.-value (get-by-id "input"))]
                          (GET (str server "todo-task")
                               {:params {:task t1}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler h-atom})))}

    [:div
     [:input {:type "text"
              :placeholder "insert task"
              :id "input"}]
     [:input {:type "submit" :value "Submit"}]]
    [:h2 "all tasks"]
    [show-output]]])





(defn show-page
  []
  (condp = (get-in @select-page [:current-page])
      "login-page" [login-page]
      "home-page" [home-page]
    (r/render [home-page] (.getElementById js/document "app"))))


(defn mount-components []
  (r/render [show-page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
