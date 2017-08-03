(ns to-do-list-sachin.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [to-do-list-sachin.config :refer [env]]))

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

(defn get-user [name]
  (mc/find-one-as-map db "users" {:id name}))

;;;;;;;;TO-DO-CODE


(defn get-input
  "Reads input from user"
  []
  (read-line))

(defn get-new-task
  "Reads the input and splits into title, date and description"
  []
  (clojure.string/split (read-line) #"[\s]"))


(defn add-task
  "Add's a new to-do"
  [title date desc]
  (mc/insert db "to-dos"  {:title title
                           :date date
                           :description desc
                           :done? false}))


(defn update-task
  "Adds the task to collection to-do"
  [task-name task-des]
  (mc/update db "to-dos" {:title task-name}
             {$set {:description task-des
                    :done? false }}))

(defn change-status-task
  "Sets the to-do as completed"
  [title]
  (mc/update db "to-dos" {:title title}
             {$set {:done? true}}))

(defn display-tasks
  "Displays all the tasks"
  []
  (mapv (fn [x]
         (let [[title d desc status]
               (drop 1 (map val x))]
         (println "-----------------------------------------------")
         (println "Task-Name : "  title)
         (println "Date : " d)
         (println "Description : " desc)
         (println "Completed? : " status)))
       (mc/find-maps db "to-dos")))




(defn start-to-do
  "STARTS THE TO DO INTERFACE"
  []
  (println "==============================================")
  (println "TO-DO LIST MANAGER")
  (println "Select an option: \n 1. Add Task \n 2. Update Task \n 3. Completed Task \n 4. Display All Tasks \n 5. Exit")
  (let [op (Integer/parseInt (get-input))]
    (condp = op
      1 (do (println "Enter Title, Date and Description of the TO-DO:")
            (let [title (get-input)
                  date (get-input)
                  desc (get-input)]
              (add-task title date desc)
              (println title "Added successfully")
              (start-to-do)))

      2 (do (println "Enter the title and Updated description:")
            (let [title (get-input)
                  task ()]
              (update-task title task)
              (println title "Updated Successfully")
              (start-to-do)))
      3 (do (println "Enter the title that has been completed:")
            (change-status-task (get-input))
            (println  "Status updated")
            (start-to-do))

      4 (do (println "TASK LIST")
             (display-tasks)
             (start-to-do))

      5 (println "Thank you"))))
