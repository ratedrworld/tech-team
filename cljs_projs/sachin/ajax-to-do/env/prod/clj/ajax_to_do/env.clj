(ns ajax-to-do.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[ajax-to-do started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[ajax-to-do has shut down successfully]=-"))
   :middleware identity})
