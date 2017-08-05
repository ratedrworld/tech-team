(ns ajax-to-do.view
  (:require [ajax-to-do.db.core :as db]
            [ajax-to-do.layout :as layout]))

(defn get-result
  [user]
  (layout/render-json
   {:status true
    :content (map (fn [x] (dissoc
                           x
                           :_id))
                  (db/display-all-tasks user))}))

(defn get-error-result
  []
  (layout/render-json {:status false
                       :content nil}))




(defn authenticate-user
  "If user is valid, return user-name else return false"
  [user pass]
  (if (db/authenticate? user pass)
    (layout/render-json {:auth true
                         :user user})
    (layout/render-json {:auth false})))


(defn add-todo
  [task user]
  (if (db/add-task task user)
    (get-result user)
    (get-error-result)))

(defn mark-done
  [user task]
  (layout/render-json
   (db/mark-complete user task)))
