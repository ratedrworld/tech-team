(ns ajax-hello-world.core
  (:require [reagent.core :as r]
            [ajax-hello-world.ajax :refer [load-interceptors!]]
            [ajax.core :refer [GET POST]]))

(def server "http://localhost:3000/")


(defn get-value
  [id]
  (.-value (.getElementById js/document id)))

(defn set-value
  [id value]
  (set! (.-value (.getElementById js/document id))
        value))

(defn log
  [& msgs]
  (.log js/console (apply str msgs)))



(defn show-output
  [response]
  (log "####################" response)
  (let [cap (:cap response)
        low (:low response)
        up (:up response)]
    (set-value "str-1" cap)
    (set-value "str-2" low)
    (set-value "str-3" up)))

(defn get-error-msg
  [response]
  (log "ERROR"))



(defn home-page []
  [:div
   [:h2 "MANIPULATE STRING"]
   [:form {:action "#"
           :method "get"
           :on-submit (fn [e]
                        (let [s (get-value "inp-str")]
                          (log "@@@@@@" s)
                          (GET (str server "modify-string")
                               {:params {:s s}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler show-output
                                :error-handler get-error-msg})))}

    [:div
     [:input {:type "text" :id "inp-str"}]
     [:input {:type "submit" :value "Submit"}]]
    [:div [:input {:type "text" :id "str-1" :disabled true}]]
    [:div [:input {:type "text" :id "str-2" :disabled true}]]
    [:div [:input {:type "text" :id "str-3" :disabled true}]]]])


(defn mount-components []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
