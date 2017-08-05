(ns todo-app.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [todo-app.config :refer [env]]
              [monger.result :refer [acknowledged?]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn create-user
  [user pass]
  (mc/insert db "users" {:user user
                         :pass pass}))


(defn insert-to-do
  [task]
  (mc/insert db "to-do-task-list" {:task task
                              :status "incomplete"}))

(defn update-user [id first-name last-name email]
  (mc/update db "users" {:_id id}
             {$set {:first_name first-name
                    :last_name last-name
                    :email email}}))

(defn ack-of-insert
  [task]
  (acknowledged? (mc/insert db "todo" {:task task})))


(defn auth?
  [user pass]
  (not (empty? (mc/find-maps db "users"
                             {:username user :password pass}))))




(defn get-all-task
  []
  (map #(select-keys % [:task :status])
       (mc/find-maps db "todo")))

(defn get-user [username]
  (mc/find-one-as-map db "users" {:user username}))
