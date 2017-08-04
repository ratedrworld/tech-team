(ns ^:figwheel-no-load todo-app.app
  (:require [todo-app.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
