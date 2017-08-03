(ns whos-first-game.prod
  (:require [whos-first-game.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
