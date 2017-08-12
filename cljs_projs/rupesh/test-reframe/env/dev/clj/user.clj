(ns user
  (:require [mount.core :as mount]
            [test-reframe.figwheel :refer [start-fw stop-fw cljs]]
            test-reframe.core))

(defn start []
  (mount/start-without #'test-reframe.core/repl-server))

(defn stop []
  (mount/stop-except #'test-reframe.core/repl-server))

(defn restart []
  (stop)
  (start))


