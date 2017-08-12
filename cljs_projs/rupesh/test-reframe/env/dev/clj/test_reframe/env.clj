(ns test-reframe.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [test-reframe.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[test-reframe started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[test-reframe has shut down successfully]=-"))
   :middleware wrap-dev})
