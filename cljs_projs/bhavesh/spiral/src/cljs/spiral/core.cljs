(ns spiral.core
    (:require [reagent.core :as r :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))






(def status-a (r/atom {:direction :right
                     :cur-pos {:x -1
                               :y 0}
                     :count 0}))

(def status-b (r/atom {:direction :left
                     :cur-pos {:x 6
                               :y 5}
                     :count 0}))




(defn arr-maker
  "Returns count on which direction needs to be changed
  for two player spiral game.
  Almost similar to arr-maker excpet that it decrements the
  size by 2 instead of 1"
  ([size] (arr-maker (- size 2) [size] 1))
  ([size arr toggle]
   (if (zero? size)
     arr
     (if (zero? toggle)
       (recur (- size 2) (conj arr (+ (last arr) size)) 1)
       (recur size (conj arr (+ (last arr) size)) 0)))))

(def change-on (arr-maker 10))

(defn change-direction
  "changes the direction to next-dir"
  [status next-dir]
  (swap! status assoc :direction next-dir))



(defn upd-gen
  "updates the postion i.e. x or y co-ordinate depending upon current direction"
  [status count pos next-dir f]
  (swap! status update-in [:cur-pos pos] f)
  (swap! status update :count inc)
  (if (some #(= % (get @status :count)) @change-on)
    (change-direction status next-dir)))


(defn upd-pos
  "Main function which will be called when button is clicked
  will update the current position in the status atom"
  [status]
  (let [direction (get @status :direction)
        count (get @status :count)]
    (cond
      (= direction :right) (upd-gen status count :x :down inc)
      (= direction :down)  (upd-gen status count :y :left inc)
      (= direction :left)  (upd-gen status count :x :up dec)
      (= direction :up)    (upd-gen status count :y :right dec))))



(defn path
  "Test function to test for a board of size 6
  calls upd-pos untill all postions are done."
  [status board]
  (if-not (= 50 (:count @status))
    (do
      (upd-pos status)
      (print board)
      (path status (conj board (vector (get-in @status [:cur-pos :x])
                           (get-in @status [:cur-pos :y])))))
    board))

(def path-a (r/atom (path status-a [])))

(def path-b (r/atom (path status-b [])))

(defn get-color
  [x y]
  (if (some (fn [arr] (= [x y] arr))
            path-a)
    "red"
    "blue"))



(defn home-page []
  [:td
   (doall (for [x (range 10)]
            [:tr
             (doall (for [y (range 10)]
                      [:input {:type "button"
                               :style {:background-color (get-color x y)
                                       :height "50"
                                       :width "50"}}]))]))])




(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
