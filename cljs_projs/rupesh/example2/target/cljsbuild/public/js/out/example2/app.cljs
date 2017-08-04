(ns ^:figwheel-no-load example2.app
  (:require [example2.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
