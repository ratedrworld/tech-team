(ns ^:figwheel-no-load ajax-to-do.app
  (:require [ajax-to-do.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
