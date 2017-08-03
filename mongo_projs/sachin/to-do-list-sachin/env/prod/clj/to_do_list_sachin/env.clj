(ns to-do-list-sachin.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[to-do-list-sachin started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[to-do-list-sachin has shut down successfully]=-"))
   :middleware identity})
