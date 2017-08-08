(ns to-do-list.views.to-do-home
  (:require [to-do-list.db.core :as db]
            [monger.result :refer [acknowledged?]]))

(defn display-todos [user]
  (let [result (db/display-todos user)]
    (mapv #(select-keys % [:title :content :status]) result)))

(defn add-todo [user title content]
  (let [result (db/add-todo user title content)]
    (if (acknowledged? result)
      (do {:status true
           :content (display-todos user)})
      {:status false})))
