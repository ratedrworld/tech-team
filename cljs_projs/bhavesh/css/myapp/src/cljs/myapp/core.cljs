(ns myapp.core
  (:require [reagent.core :as r]))



(defn counter [id]
  (let [count (r/atom 0)]
    (fn [id]
      [:div [:h4 "value of counter id =" id " is " @count]
       [:input {:type "button" :value (str "Click-me-" id)
                :on-click (fn [e]
                            (swap! count inc))}]])))

(defn home-page []
  [:div.row
   [:div.col-md-8.col-xs-12
    [:h2 "col1"]]
   [:div.col-md-4.col-xs-6
    [:h2 "col2"]]
   [:div.col-md-12.col.xs-6
    [:h2 "col3"]]
   [:img {:border-radius "8px"
          :width "50%"
          :src (str js/context "/img/img_lights.jpg" )}]])





;; -------------------------
;; Routes

;; -------------------------
;; History
;; must be called after routes have been defined


;; -------------------------
;; Initialize app


(defn mount-components []

  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
   (mount-components))
