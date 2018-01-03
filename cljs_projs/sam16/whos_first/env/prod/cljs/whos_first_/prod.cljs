(ns whos-first?.prod
  (:require [whos-first?.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
