(ns todo-app.view
  (:require [todo-app.layout :as layout]
            [ring.util.http-response :as responce]
            [todo-app.db.core :as db]))






(defn return-all-task
  []
  {:status true
   :content (db/get-all-task)})


(defn return-error
  []
  {:status false})


(defn add-task
  [task]
  (layout/render-json (if (db/ack-of-insert task)
                        (return-all-task)
                        (return-error))))



(defn validate-user
  [user pass]
  (if (db/auth? user pass)
    {:auth false
     :user user}
    {:auth true
     :user user}))
