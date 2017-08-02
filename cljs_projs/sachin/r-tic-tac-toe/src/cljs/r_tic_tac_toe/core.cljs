(ns r-tic-tac-toe.core
    (:require [reagent.core :as reagent :refer [atom]]))

(defn hmap
  [size]
  (apply vector (cons 0 (for [i (range size)]
                           {:pos i :value ""}))))


(def board (reagent/atom (hmap 9)))

(defn get-val
  [index]
  (get-in @board [index :value]))

(defn check-elements
  [i j k]
  (let [a (get-val i)
        b (get-val j)
        c (get-val k)
        dis (distinct (vector a b c))]
    (and (not= dis '("")) (= 1 (count dis)))))

(defn check-row
  []
  (or (check-elements 1 2 3)
      (check-elements 4 5 6)
      (check-elements 7 8 9)))

(defn check-column
  []
  (or (check-elements 1 4 7)
      (check-elements 2 5 8)
      (check-elements 3 6 9)))

(defn check-diagonal
  []
  (or (check-elements 1 5 9)
      (check-elements 7 5 3)))

(defn check-win
  []
  (or (check-row)
      (check-column)
      (check-diagonal)))

(defn set-x-o
  [index val]
  (swap! board assoc-in [index :value] val))

(defn get-x-o
  []
  (let [c (first @board)]
    (if (= 0 (mod c 2))
      "O"
      "X")))

(defn get-index
  [i j]
  (inc (+ (* 3 i) j)))

(defn update-board
  [index]
  (let [c (first @board)]
    (if (zero? (mod c 2))
      (set-x-o index "X")
      (set-x-o index "O"))
    (swap! board update-in [0] inc)
    (when (check-win)
      (js/alert (str  "GAME OVER!!! Player " (get-x-o) " Wins....")))))

(defn home-page []
  [:div
   [:h2 "TIC TAC TOE "]
   (doall (for [i (range 3)]
            [:div
             (doall (for [j (range 3)]
                      [:input {:type "button" :value (get-in @board [(get-index i j) :value])
                               :on-click #(update-board (get-index i j))}]))]))])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
