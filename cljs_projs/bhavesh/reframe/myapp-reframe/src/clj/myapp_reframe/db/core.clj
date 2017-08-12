(ns myapp-reframe.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [myapp-reframe.config :refer [env]]
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

(defn get-user [user]
  (mc/find-one-as-map db "users" {:user user}))

(defn insert-task-ack
  [task user]
  (acknowledged? (mc/insert db user {:task task :status "Incomplete"})))

(defn get-all-tasks
  [user]
  (map #(select-keys % [:task :status]) (mc/find-maps db user )))


(defn mark-task-done
  [user task]
  (mc/update db user {:task task}
             {$set {:status "Complete"}}))


(defn delete-task
  [user task]
  (mc/remove db user {:task task}))


(defn update-task
  [user task new-task]
  (mc/update db user {:task task}
             {$set {:task new-task}}))
