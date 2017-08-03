(ns to-do-list.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[to-do-list started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[to-do-list has shut down successfully]=-"))
   :middleware identity})
