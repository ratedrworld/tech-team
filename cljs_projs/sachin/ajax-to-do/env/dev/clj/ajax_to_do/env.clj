(ns ajax-to-do.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [ajax-to-do.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[ajax-to-do started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[ajax-to-do has shut down successfully]=-"))
   :middleware wrap-dev})
