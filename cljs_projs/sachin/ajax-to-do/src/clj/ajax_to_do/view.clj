(ns ajax-to-do.view
  (:require [ajax-to-do.db.core :as db]
            [ajax-to-do.layout :as layout]))

(defn get-result
  []
  (layout/render-json
   {:status true
    :content (map (fn [x] (dissoc
                           x
                           :_id))
                  (db/display-all-tasks))}))

(defn get-error-result
  []
  {:status false
   :content nil})
(defn add-todo
  [task]
  (if (db/add-task task)
    (get-result)
    (get-error-result)))
