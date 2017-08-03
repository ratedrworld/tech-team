(ns ^:figwheel-no-load whos-first-game.dev
  (:require
    [whos-first-game.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
