(ns to-do-list.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [to-do-list.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

;;;;;;;;;;;;; sam16's ToDo List :)

;; Atom for Autoincrement of ids
(def id (atom 0))

;; Inserts a New to Do
(defn add-todo []
  (swap! id inc)
  (println "\n\tEnter the Title")
  (let [title (read-line)]
    (println "\tEnter the Content")
    (mc/insert db "to-dos" {:id @id :title title :content (read-line) :status "pending"})))

;; Displays all todos from Db
(defn display-todos []
  (clojure.pprint/pprint (map #(select-keys % [:id :title :content :status])
                              (mc/find-maps db "to-dos"))))

;; Update an Exisiting Todo
(defn update-todo []
  (display-todos)
  (println "\n\tEnter Id of Todo u want to Update")
  (let [id (read-string (read-line))
        x (println "\tEnter New Title")
        title (read-line)]
    (println "\tEnter New Content")
    (mc/update db "to-dos" {:id id} {$set {:title title :content (read-line)}})))

;; Mark todo as Complete
(defn done-todo []
  (display-todos)
  (println "\n\tEnter Id of Todo which is Done")
  (mc/update db "to-dos" {:id (read-string (read-line))} {$set {:status "done"}}))

;; Print the Options
(defn show-options []
  (println "\n\tWelcome to Your To Do List
\tSelect from the Following Options :
\t1. Add a New To Do.
\t2. Display all Your To Dos
\t3. Update a To Do.
\t4. Mark a To Do as Done.
\t5. Exit"))

;; Main function of program
(defn todo-main []
  (show-options)
  (let [ip (read-string (read-line))]
    (condp = ip
      1 (add-todo)
      2 (display-todos)
      3 (update-todo)
      4 (done-todo)
      5 ip)
    (if (= 5 ip)
      (println "\n\tBye. Baadmein fir Aana")
      (recur))))
