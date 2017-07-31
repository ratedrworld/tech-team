(ns ^:figwheel-no-load r-tic-tac-toe.dev
  (:require
    [r-tic-tac-toe.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
