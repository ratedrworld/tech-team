(ns ajax-to-do.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [ajax-to-do.config :refer [env]]
              [monger.result :refer [acknowledged?]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn create-user [user]
  (mc/insert db "users" user))

(defn update-user [id first-name last-name email]
  (mc/update db "users" {:_id id}
             {$set {:first_name first-name
                    :last_name last-name
                    :email email}}))

(defn get-user [id]
  (mc/find-one-as-map db "users" {:_id id}))


(defn add-task
  [task]
  (let [operation (mc/insert db "todos" {:task task :completed? true} )]
    (acknowledged? operation)))

(defn display-all-tasks
  []
  (mc/find-maps db "todos"))
