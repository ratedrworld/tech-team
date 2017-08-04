(ns ajax-hello-world.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [ajax-hello-world.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[ajax-hello-world started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[ajax-hello-world has shut down successfully]=-"))
   :middleware wrap-dev})
