(ns to-do-list.routes.home
  (:require [to-do-list.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [to-do-list.views.to-do-home :as todohome]))

(defn home-page []
  (layout/render "home.html"))

(defn add-todo [s]
  #_(layout/render-json (todohome/add-todo s)))

(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/add-todo" [s]
       (add-todo s)))
