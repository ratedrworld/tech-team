(ns ^:figwheel-no-load g-sign-in.app
  (:require [g-sign-in.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
