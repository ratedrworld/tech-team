(ns user
  (:require [mount.core :as mount]
            [to-do-list.figwheel :refer [start-fw stop-fw cljs]]
            to-do-list.core))

(defn start []
  (mount/start-without #'to-do-list.core/repl-server))

(defn stop []
  (mount/stop-except #'to-do-list.core/repl-server))

(defn restart []
  (stop)
  (start))


