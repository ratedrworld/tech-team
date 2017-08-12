(ns test-reframe.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[test-reframe started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[test-reframe has shut down successfully]=-"))
   :middleware identity})
