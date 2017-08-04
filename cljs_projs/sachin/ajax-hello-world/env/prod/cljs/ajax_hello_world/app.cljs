(ns ajax-hello-world.app
  (:require [ajax-hello-world.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
