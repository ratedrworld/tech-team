(ns ^:figwheel-no-load ajax-hello-world.app
  (:require [ajax-hello-world.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
