(ns to-do-list.app
  (:require [to-do-list.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
