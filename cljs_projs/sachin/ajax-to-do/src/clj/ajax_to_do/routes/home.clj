(ns ajax-to-do.routes.home
  (:require [ajax-to-do.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [ajax-to-do.view :as view]))

(defn home-page []
  (layout/render "home.html"))

(defn add-todo
  [task]
  (view/add-todo task))




(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/todo" [task]
       (add-todo task)))
