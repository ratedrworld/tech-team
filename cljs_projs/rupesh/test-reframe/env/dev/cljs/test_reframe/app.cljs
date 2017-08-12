(ns ^:figwheel-no-load test-reframe.app
  (:require [test-reframe.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
