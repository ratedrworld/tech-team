(ns todo-app.routes.home
  (:require [todo-app.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [todo-app.db.core :as db]))

(defn home-page []
  (layout/render "home.html"))




(defroutes home-routes
  (GET "/" []
       (home-page))
  (POST "/add-todo" string
       (add-todo string)))
