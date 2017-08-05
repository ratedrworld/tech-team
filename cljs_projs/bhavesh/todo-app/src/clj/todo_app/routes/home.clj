(ns todo-app.routes.home
  (:require [todo-app.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [todo-app.db.core :as db]
            [todo-app.view :as view]))

(defn home-page []
  (layout/render "home.html"))


(defn all-tasks
  [user]
  (layout/render-json (view/return-all-tasks user)))

(defn mark-complete
  [user task]
  (layout/render-json (view/mark-done user task)))


(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/todo" [task user]
       (view/add-todo task user))
  (GET "/user" [user password]
       (view/check-user user password))
  (GET "/tasks" [user]
       (all-tasks user))
  (GET "/done" [user task]
       (mark-complete user task)))
