(ns user
  (:require [mount.core :as mount]
            [reframe-todo.figwheel :refer [start-fw stop-fw cljs]]
            reframe-todo.core))

(defn start []
  (mount/start-without #'reframe-todo.core/repl-server))

(defn stop []
  (mount/stop-except #'reframe-todo.core/repl-server))

(defn restart []
  (stop)
  (start))


