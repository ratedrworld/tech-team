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

(defn create-user [user pass]
  (mc/insert db "users" {:user-name user :password pass}))

#_(defn update-user [id first-name last-name email]
  (mc/update db "users" {:id id}
             {$set {:first_name first-name
                    :last_name last-name
                    :email email}}))

#_(defn get-user [id]
    (mc/find-one-as-map db "users" {:_id id}))

(defn authenticate?
  [user pass]
  (not (empty? (mc/find-maps db "users" {:user-name user :password pass}))))
(defn add-task
  [task user]
  (let [operation (mc/insert db "todos" {:user user :task task :completed? false} )]
    (acknowledged? operation)))

(defn display-all-tasks
  [user]
  (mc/find-maps db "todos" {:user user}))
