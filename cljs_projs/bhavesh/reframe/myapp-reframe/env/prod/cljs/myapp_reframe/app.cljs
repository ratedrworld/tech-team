(ns myapp-reframe.app
  (:require [myapp-reframe.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
