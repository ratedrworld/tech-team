(ns user
  (:require [mount.core :as mount]
            [ajax-to-do.figwheel :refer [start-fw stop-fw cljs]]
            ajax-to-do.core))

(defn start []
  (mount/start-without #'ajax-to-do.core/repl-server))

(defn stop []
  (mount/stop-except #'ajax-to-do.core/repl-server))

(defn restart []
  (stop)
  (start))


