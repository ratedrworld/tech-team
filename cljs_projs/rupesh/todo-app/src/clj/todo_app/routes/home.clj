(ns todo-app.routes.home
  (:require [todo-app.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [todo-app.db.core :as db]
            [todo-app.view :as view]))

(defn home-page []
  (layout/render "home.html"))


(defn validate-user [user pwd]
  (layout/render-json (view/validate-user user pwd)))



(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/todo-task" [task]
       (view/add-task task))
  (GET "/user" [user pwd]
       (validate-user user pwd)))
