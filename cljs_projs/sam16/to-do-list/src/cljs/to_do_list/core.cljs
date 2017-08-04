(ns to-do-list.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]]))

(def server "http://localhost:3000")

(defn get-by-id [id] (.-value (.getElementById js/document id)))

(defn log [& msgs]
  (.log js/console (apply str msgs)))

(defn show-todos [response]
  [])

(defn error-handler [params]
  (log "ERRORS >>>>>" params))

(defn home-page []
  [:div.container
   [:h2 "First AJAX - PROJECT"]
   [:form {:action "#" :method "post"
           :on-submit (fn [e]
                        (let [s (get-by-id "new-todo-string")]
                          (log s)
                          (POST (str server "add-todo")
                               {:params {:todo s}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler show-todos
                                :error-handler error-handler})))}
    [:div [:input {:type "text" :id "new-todo-string"}]]
    [:div [:input {:type "submit" :value "Submit"}]]]
   [:div [:input {:disabled true :type "text" :id "todo-out"}]]])

(defn mount-components []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
