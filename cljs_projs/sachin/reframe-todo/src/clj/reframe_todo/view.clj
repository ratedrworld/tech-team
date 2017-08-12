(ns reframe-todo.view
  (:require [reframe-todo.db.core :as db]))

(defn get-result
  [user]
  {:status true
   :content (map (fn [x] (dissoc x :_id))
                 (db/display-all-tasks user))})

(defn get-error-result
  []
  {:status false
   :content nil})


(defn authenticate-user
  "If user is valid, return user-name else return false"
  [user pass]
  (if (db/authenticate? user pass)
    {:auth true
     :user user}
    {:auth false}))

(defn do-operation
  [user operation]
  (if operation
    (get-result user)
    (get-error-result)))

(defn add-task
  [user task]
  (do-operation user (db/add-task user task)))
(defn mark-done
  [user task]
  (do-operation user (db/mark-complete user task)))

(defn update-task
  [user task new-task]
  (do-operation user (db/update-task user task new-task)))
