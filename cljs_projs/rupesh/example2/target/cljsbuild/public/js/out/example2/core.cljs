(ns example2.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]])
  (:import goog.History))

(def server "http://localhost:3000/")

(defn get-by-id [id]
  (.getElementById js/document id))

(defn log [& params]
  (.log js/console (apply str params)))

(defn show-output [response]
  (let [cap (:cap response)
        low (:low response)
        upp (:upp response)]
    (set! (.-value (.getElementById js/document "str-1")) cap)
    (set! (.-value (.getElementById js/document "str-2")) low)
    (set! (.-value (.getElementById js/document "str-3")) upp)))

(defn error-handler [params]
  (log "@@@" params))



(defn home-page []
  [:div.container
   [:h2 "hello world"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [s1 (.-value (get-by-id "input-str"))
                              s2 "some value"]
                          (log s)
                          (GET (str server "manipulate-string")
                               {:params {:s1 s1
                                         :s2 s2}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler show-output                                :error-handler error-handler})))}
    [:div [:input {:type "text"
                   :id "input-str"}]
     [:input {:type "submit" :value "Submit"}]]
    [:div [:input {:disabled true :type "text" :id "str-1"}]]
    [:div [:input {:disabled true :type "text" :id "str-2"}]]
    [:div [:input {:disabled true :type "text" :id "str-3"}]]]])






(defn mount-components []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
