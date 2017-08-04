(ns user
  (:require [mount.core :as mount]
            [ajax-hello-world.figwheel :refer [start-fw stop-fw cljs]]
            ajax-hello-world.core))

(defn start []
  (mount/start-without #'ajax-hello-world.core/repl-server))

(defn stop []
  (mount/stop-except #'ajax-hello-world.core/repl-server))

(defn restart []
  (stop)
  (start))


