(ns ^:figwheel-no-load whos-first?.dev
  (:require
    [whos-first?.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
