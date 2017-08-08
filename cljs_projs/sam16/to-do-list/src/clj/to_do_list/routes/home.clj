(ns to-do-list.routes.home
  (:require [to-do-list.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [to-do-list.views.to-do-home :as todohome]
            [to-do-list.views.login-page :as login]))

(defn home-page []
  (layout/render "home.html"))

(defn add-todo [user title content]
  (layout/render-json (todohome/add-todo user title content)))

(defn user-login? [user pass]
  (layout/render-json (login/user-login? user pass)))

(defroutes home-routes
  (GET "/" [](home-page))
  (GET "/todo" [user title content] (add-todo user content title))
  (GET "/user" [user pass] (user-login? user pass)))
