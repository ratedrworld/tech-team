(ns to-do-list-sachin.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [to-do-list-sachin.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[to-do-list-sachin started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[to-do-list-sachin has shut down successfully]=-"))
   :middleware wrap-dev})
