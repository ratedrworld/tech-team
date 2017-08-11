(ns ^:figwheel-no-load myapp-reframe.app
  (:require [myapp-reframe.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
