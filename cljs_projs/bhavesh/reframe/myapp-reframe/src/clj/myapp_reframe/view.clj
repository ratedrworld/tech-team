(ns myapp-reframe.view
  (:require [myapp-reframe.layout :as layout]
            [ring.util.http-response :as response]
            [myapp-reframe.db.core :as db]))



(defn get-multipart-param [request name]
  (get-in request [:multipart-params name]))

(defn return-all-tasks
  "Returns a json response with status and a map of all tasks"
  [user]
  {:status true
   :content (db/get-all-tasks user)})

(defn return-error
  "Returns a json respons with status key set to false"
  []
  {:status false})

(defn add-todo
  "Calls the db function to add task in the database
  Returns all the tasks if adding was succesful else
  returns error message"
  [task user]
  (if (db/insert-task-ack task user)
      (return-all-tasks user)
      (return-error)))

(defn check-user
  "returns true is username and password match"
  [user password]
  (if-let [user-map (db/get-user user)]
                         (= (:pass user-map) password)))
(defn mark-done
  "chages the status of a task to complete, and returns all the tasks"
  [user task]
  (db/mark-task-done user task)
  (return-all-tasks user))

(defn delete-task
  "Deletes a given task from the task list of given user"
  [user task]
  (db/delete-task user task)
  (return-all-tasks user))

(defn update-task
  [user task new-task]
  (db/update-task user task new-task)
  (return-all-tasks user))
