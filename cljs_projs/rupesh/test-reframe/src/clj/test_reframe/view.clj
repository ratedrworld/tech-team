(ns test-reframe.view
  (:require [test-reframe.layout :as layout]
            [ring.util.http-response :as response]
            [test-reframe.db.core :as db]))

(defn return-all-tasks
  [user]
  {:status true
   :content (db/get-all-tasks user)})

(defn return-error
  []
  {:status false})

(defn add-todo
  [task user]
  (layout/render-json (if (db/insert-task-ack task user)
                        (return-all-tasks user)
                        (return-error))))

(defn check-user
  [user password]
  (layout/render-json (if-let [user-map (db/get-user user)]
                        (= (:password user-map) password))))
(defn mark-done
  [user task]
  (db/mark-task-done user task)
  (return-all-tasks user))

(defn upd-task
  [user task new-task]
  (db/update-task-user user task new-task)
  (return-all-tasks user))
