(ns g-sign-in.app
  (:require [g-sign-in.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
