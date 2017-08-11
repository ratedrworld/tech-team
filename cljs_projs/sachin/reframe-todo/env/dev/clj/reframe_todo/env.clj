(ns reframe-todo.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [reframe-todo.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[reframe-todo started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[reframe-todo has shut down successfully]=-"))
   :middleware wrap-dev})
