(ns reframe-todo.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[reframe-todo started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[reframe-todo has shut down successfully]=-"))
   :middleware identity})
