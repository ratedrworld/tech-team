(ns r-tic-tac-toe.prod
  (:require [r-tic-tac-toe.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
