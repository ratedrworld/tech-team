(ns myapp-reframe.routes.home
  (:require [myapp-reframe.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [myapp-reframe.db.core :as db]
            [myapp-reframe.view :as view]))

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
