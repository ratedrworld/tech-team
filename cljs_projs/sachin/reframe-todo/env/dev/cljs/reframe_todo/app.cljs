(ns ^:figwheel-no-load reframe-todo.app
  (:require [reframe-todo.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
