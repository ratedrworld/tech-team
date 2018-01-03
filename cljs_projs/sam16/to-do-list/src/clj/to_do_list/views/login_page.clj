(ns to-do-list.views.login-page
  (:require [to-do-list.db.core :as db]
            [monger.result :refer [acknowledged?]]))

(defn user-login? [user pass]
  (let [result (db/user-login? user pass)]
    (if result
      (do (let [rslt (db/display-todos user)]
            {:login true :user user
             :content (mapv #(select-keys % [:title :content :status]) rslt)}))
      {:login false})))

(defn done-todo [user title]
  (let []))
