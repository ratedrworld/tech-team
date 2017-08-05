(ns user
  (:require [mount.core :as mount]
            [todo-app.figwheel :refer [start-fw stop-fw cljs]]
            todo-app.core))

(defn start []
  (mount/start-without #'todo-app.core/repl-server))

(defn stop []
  (mount/stop-except #'todo-app.core/repl-server))

(defn restart []
  (stop)
  (start))


