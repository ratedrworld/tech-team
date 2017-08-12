(ns myapp-reframe.routes.home
  (:require [myapp-reframe.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [myapp-reframe.db.core :as db]
            [myapp-reframe.view :as view]))

(defn home-page []
  (layout/render "home.html"))





(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/todo" [task user]
       (layout/render-json (view/add-todo task user)))
  (GET "/user" [user password]
       (layout/render-json (view/check-user user password)))
  (GET "/tasks" [user]
       (layout/render-json (view/return-all-tasks user)))
  (GET "/done" [user task]
       (layout/render-json (view/mark-done user task)))
  (GET "/delete" [user task]
       (layout/render-json (view/delete-task user task)))
  (GET "/update" [user task new-task]
       (layout/render-json (view/update-task user task new-task))))
