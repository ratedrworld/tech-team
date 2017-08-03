(ns to-do-list-sachin.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [to-do-list-sachin.layout :refer [error-page]]
            [to-do-list-sachin.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [to-do-list-sachin.env :refer [defaults]]
            [mount.core :as mount]
            [to-do-list-sachin.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
