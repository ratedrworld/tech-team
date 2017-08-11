(ns user
  (:require [mount.core :as mount]
            [myapp-reframe.figwheel :refer [start-fw stop-fw cljs]]
            myapp-reframe.core))

(defn start []
  (mount/start-without #'myapp-reframe.core/repl-server))

(defn stop []
  (mount/stop-except #'myapp-reframe.core/repl-server))

(defn restart []
  (stop)
  (start))


