(ns myapp.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]])
  (:import goog.History))


(defn get-by-id
  [id]
  (.-value (.getElementById js/document id)))

(def server "http://localhost:3000/")

(defn set-by-id
  [id value]
  (set! (.-value (.getElementById js/document id))
        value))

(defn show-output [response]
  (let [cap (:cap response)
        upp (:upp response)
        low (:low response)]
    (js/alert (str cap upp low))
    (set-by-id "str-1" cap)
    (set-by-id "str-2" upp)
    (set-by-id "str-3" low)))

(defn show-error [params]
  (js/alert params))

(defn home-page []
  [:div
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [input (get-by-id "input")]
                          (GET (str server "manipulate-string")
                               :params {:s input}
                               :format :json
                               :response-format :json
                               :keywords? true
                               :handler show-output
                               :error-handler show-error)))}
    [:div [:input {:type "text"
                   :id "input"}]
     [:input {:type "submit"
              :value "submit"}]]
    [:div [:input {:type "text" :disabled true :id "str-1"}]]
    [:div [:input {:type "text" :disabled true :id "str-2"}]]
    [:div [:input {:type "text" :disabled true :id "str-3"}]]]])





;; -------------------------
;; Routes




(defn mount-components []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
 (mount-components))
