(ns ^:figwheel-no-load to-do-list.app
  (:require [to-do-list.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
