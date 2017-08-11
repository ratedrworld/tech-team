(ns myapp-reframe.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[myapp-reframe started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[myapp-reframe has shut down successfully]=-"))
   :middleware identity})
