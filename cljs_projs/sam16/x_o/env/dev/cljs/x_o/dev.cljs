(ns ^:figwheel-no-load x-o.dev
  (:require
    [x-o.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
