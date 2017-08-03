(ns user
  (:require [mount.core :as mount]
            to-do-list-sachin.core))

(defn start []
  (mount/start-without #'to-do-list-sachin.core/repl-server))

(defn stop []
  (mount/stop-except #'to-do-list-sachin.core/repl-server))

(defn restart []
  (stop)
  (start))


