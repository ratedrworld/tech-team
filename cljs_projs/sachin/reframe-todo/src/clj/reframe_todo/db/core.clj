(ns reframe-todo.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [monger.result :refer [acknowledged?]]
              [reframe-todo.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn create-user [user pass]
  (mc/insert db "users" {:user-name user
                         :password pass}))


(defn authenticate?
  [user pass]
  (not (empty? (mc/find-maps db "users" {:user-name user :password pass}))))

(defn add-task
  [user task]
  (let [op (mc/insert db "todos" {:user user
                                  :task task
                                  :completed? false})]
    (acknowledged? op)))

(defn display-all-tasks
  [user]
  (mc/find-maps db "todos" {:user user :completed? false}))


(defn mark-complete
  [user task]
  (let [op (mc/update db "todos" {:user user :task task :completed? false}
                      {$set {:completed? true}})]
    (acknowledged? op)))

(defn update-task
  [user task new-task]
  (let [op (mc/update db "todos" {:user user :task task}
                      {$set {:task new-task}})]
    (acknowledged? op)))
