(ns whos-first-game.core
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to whos-first-game"]
   [:input {:type "button" :value "PLAYER A" :style {:height "40"
                                                     :width "200"}}]
   [:input {:type "button" :value "PLAYER B" :style {:height "40"
                                                     :width "200"}}]
   (for [i (range 10)]
     [:div (for [j (range 10)]
             [:input {:type "button" :style {:background-color "red"
                                             :height "50"
                                             :width "50"}}])])])


;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))


(def board (atom {:size 10
                  :chance 0
                  :a {:current-pos [0 0]
                      :dir :right
                      :color "red"
                      :path []}

                  :b {:current-pos [0 0]
                      :dir :right
                      :color "red"
                      :path []}
                  :board []}))

(defn make-board
  []
  (let [size (:size @board)])
  (apply vector (for [x (range size)
                      y (range size)]
                  {:pos-x x :pos-y y :value ""})))

(defn fill-board
  []
  (let [size (:size @board)]
    (map #(swap! board assoc-in [:board % :value] %) (range (* size size)))))
