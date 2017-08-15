(ns user
  (:require [mount.core :as mount]
            [g-sign-in.figwheel :refer [start-fw stop-fw cljs]]
            g-sign-in.core))

(defn start []
  (mount/start-without #'g-sign-in.core/repl-server))

(defn stop []
  (mount/stop-except #'g-sign-in.core/repl-server))

(defn restart []
  (stop)
  (start))


