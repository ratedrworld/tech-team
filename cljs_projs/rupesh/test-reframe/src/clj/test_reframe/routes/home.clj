(ns test-reframe.routes.home
  (:require [test-reframe.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [test-reframe.view :as view]))

(defn home-page []
  (layout/render "home.html"))


(defn all-tasks
  [user]
  (layout/render-json (view/return-all-tasks user)))

(defn mark-complete
  [user task]
  (layout/render-json (view/mark-done user task)))

(defn update-task
  [user task new-task]
  (layout/render-json (view/upd-task user task new-task)))

(defroutes home-routes
  (GET "/" []
       (home-page))

  (GET "/user" [user password]
       (view/check-user user password))

  (GET "/todo" [task user]
       (view/add-todo task user))

  (GET "/tasks" [user]
       (all-tasks user))

  (GET "/done" [user task]
       (mark-complete user task))

  (GET "/update" [user task new-task]
       (update-task user task new-task)))
