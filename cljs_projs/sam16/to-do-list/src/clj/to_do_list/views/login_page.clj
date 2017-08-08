(ns to-do-list.views.login-page
  (:require [to-do-list.db.core :as db]
            [monger.result :refer [acknowledged?]]))

(defn user-login? [user pass]
  (let [result (db/user-login? user pass)]
    (if result
      (do {:login true
           :user user})
      {:login false})))
