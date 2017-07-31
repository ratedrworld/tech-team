(ns tictactoe.core
    (:require [reagent.core :as reagent :refer [atom]]))

;; --------------------



(def board (reagent/atom {0 {0 {:value ""
                                :disabled false}
                             1 {:value ""
                                :disabled false}
                             2 {:value ""
                                :disabled false}}
                          1 {0 {:value ""
                                :disabled false}
                             1 {:value ""
                                :disabled false}
                             2 {:value ""
                                :disabled false}}
                          2 {0 {:value ""
                                :disabled false}
                             1 {:value ""
                                :disabled false}
                             2 {:value ""
                                :disabled false}}
                          :next-mov 0}))



(defn get-values
  []
  (vec (for [x (range 3)
             y (range 3)

             :let [val  (get-in @board [x y :value])]]
         val)))



(defn rev-interleave
  "reverse interleaves a sequence into number of sequences
  This is used to get columns from the board"
  [arr n]
  (let [part (partition n arr)]
    (apply map list part)))







(defn  equal-array?
  "checks if all the elements in the array are equal
  gives false when all are empty"
  [array]
  (if-not (empty? (first array))
    (apply = array)))

(defn disable
  [flag]
  (when flag
    (doall (for [x (range 3)
                 y (range 3)]
             (swap! board assoc-in [x y :disabled] true)))
    (js/alert (str "Game-over ! Player " (if (zero? (mod (get-in @board [:next-mov])
                                                         2))

                                           "O "
                                           "X ") " Won"))))


(defn game-over
  "divides the board into rows, columns and two diagnols and calls equal-array on each of them"
  []
  (let [values   (get-values)
        [r1 r2 r3] (partition 3 values)
        [c1 c2 c3] (rev-interleave values 3)
        d1 (map #(nth values %) [0 4 8])
        d2 (map #(nth values %) [2 4 6])]
    (disable (some equal-array? [r1 r2 r3 c1 c2 c3 d1 d2]))))







(defn upd-board!
  "Disables the clicked button and sets the value to next move"
  [x y]
  (swap! board assoc-in [x y :disabled] true)
  (if (zero? (mod (get-in @board [:next-mov])
                  2))
    (swap! board assoc-in [x y :value] "X")
    (swap! board assoc-in [x y :value] "O"))
  (swap! board update-in [:next-mov] inc)
  (game-over))

(defn home-page []
  [:div
   (doall
    (for [x (range 3) ]
      [:div
       (doall
        (for [y (range 3)]
          [:input {:type "button"
                   :style {:width "150"
                           :height "150"
                           :font-size "100"}
                   :value (get-in @board [x y :value])
                   :on-click #(upd-board! x y)
                   :disabled (get-in @board [x y :disabled])}]))]))])





;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
