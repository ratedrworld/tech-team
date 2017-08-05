(ns ajax-to-do.routes.home
  (:require [ajax-to-do.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [ajax-to-do.view :as view]))

(defn home-page []
  (layout/render "home.html"))

(defn get-todos
  [user]
  (view/get-result user))

(defn add-todo
  [task user]
  (view/add-todo task user))

(defn verify?
  [user pass]
  (view/authenticate-user user pass))

(defn change-status
  [user task]
  (view/mark-done user task))



(defroutes home-routes
  (GET "/" []
       (home-page))

  (GET "/auth" [user pass]
       (verify? user pass))
  (GET "/todo" [task user]
       (add-todo task user))

  (GET "/user-todo"
       [user]
       (get-todos user))

  (GET "/mark-done"
       [user task]
       (change-status user task)))
