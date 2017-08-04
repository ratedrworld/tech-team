(ns myapp.routes.home
  (:require [myapp.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(defn home-page []
  (layout/render "home.html"))

(defn manipulate-string
  [s]
  (layout/render-json
   {:cap  (string/join " " (map string/capitalize (string/split s #" ")))
    :upp  (string/join " " (map string/upper-case (string/split s #" ")))
    :low  (string/join " " (map string/lower-case (string/split s #" ")))}))

(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/manipulate-string" [s] (manipulate-string s)))
