(ns to-do-list.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [to-do-list.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[to-do-list started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[to-do-list has shut down successfully]=-"))
   :middleware wrap-dev})
