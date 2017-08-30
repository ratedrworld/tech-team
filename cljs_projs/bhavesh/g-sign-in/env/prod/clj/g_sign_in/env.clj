(ns g-sign-in.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[g-sign-in started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[g-sign-in has shut down successfully]=-"))
   :middleware identity})
