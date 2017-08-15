(ns g-sign-in.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [g-sign-in.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[g-sign-in started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[g-sign-in has shut down successfully]=-"))
   :middleware wrap-dev})
