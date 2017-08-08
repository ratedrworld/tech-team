(ns to-do-list.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [monger.result :refer [acknowledged?]]
              [to-do-list.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn update-user [id first-name last-name email]
  (mc/update db "users" {:_id id}
             {$set {:first_name first-name
                    :last_name last-name
                    :email email}}))

(defn get-user [id]
  (mc/find-one-as-map db "users" {:_id id}))

;;;;;;;;;;;;; sam16's ToDo List :)1

;; Inserts a New to Do
(defn add-todo [user title content]
  (let [userx "yash"]
    (mc/insert db "todos" {:user user :title title :content content :status "pending"})))

;; Displays all todos from Db
(defn display-todos [user]
  (mc/find-maps db "todos" {:user user}))

;; Update an Exisiting Todo
(defn update-todo [title content]
  (mc/update db "todos" {:title title} {$set {:content content}}))

;; Mark todo as Complete
(defn done-todo [user title]
  (mc/update db "todos" {:user user :title title} {$set {:status "done"}}))

;;;;;;;;;;;;;;;; Login Page

;; Validate user login
(defn create-user [user pass]
  (mc/insert db "users" {:user user :password pass}))

(defn user-login? [user pass]
  (mc/any? db "users" {:user user :password pass}))
