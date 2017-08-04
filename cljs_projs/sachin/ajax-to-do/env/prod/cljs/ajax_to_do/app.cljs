(ns ajax-to-do.app
  (:require [ajax-to-do.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
