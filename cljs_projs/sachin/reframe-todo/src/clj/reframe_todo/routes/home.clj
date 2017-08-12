(ns reframe-todo.routes.home
  (:require [reframe-todo.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [reframe-todo.view :as view]))


(defn home-page []
  (layout/render "home.html"))

(defn get-todos
  [user]
  (layout/render-json (view/get-result user)))

(defn add-todo
  [user task]
  (layout/render-json (view/add-task user task)))

(defn verify?
  [user pass]
  (layout/render-json (view/authenticate-user user pass)))

(defn change-status
  [user task]
  (layout/render-json (view/mark-done user task)))

(defn update-task
  [user task new-task]
  (layout/render-json (view/update-task user task new-task)))

(defroutes home-routes
  (GET "/" []
       (home-page))

  (GET "/auth" [user pass]
       (verify? user pass))

  (GET "/todo" [user task]
       (add-todo user task))

  (GET "/user-todo"
       [user]
       (get-todos user))

  (GET "/mark-done"
       [user task]
       (change-status user task))

  (GET "/update-todo"
       [user task new-task]
       (update-task user task new-task)))
