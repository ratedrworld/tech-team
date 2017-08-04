(ns spiral.core
    (:require [reagent.core :as r :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))






(def status-a (r/atom {:direction :right
                   :cur-pos {:x -1
                             :y 0}
                   :count 0}))

(def status-b (r/atom {:direction :left
                     :cur-pos {:x 10
                               :y 9}
                     :count 0}))


(defn arr-maker-2
  "Returns count on which direction needs to be changed
  for two player spiral game.
  Almost similar to arr-maker excpet that it decrements the
  size by 2 instead of 1"
  ([size] (arr-maker-2 (- size 2) [size] 1))
  ([size arr toggle]
   (if (zero? size)
     arr
     (if (zero? toggle)
       (recur (- size 2) (conj arr (+ (last arr) size)) 1)
       (recur size (conj arr (+ (last arr) size)) 0)))))

(def change-on (atom (arr-maker-2 10)))

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



(defn test-func
  "takes an atom and a number 'rep', calls upd-pos 'rep' times. and updates the atom
   also returns the complete path (cur-pos co-ordinates) as a vector of vector (board)"
  ([at-status rep]
   (test-func at-status [] rep))
  ([at-status  board rep]
   (if-not (zero? rep)
     (do
       (upd-pos at-status)
       (recur at-status (conj board (vector (get-in @at-status [:cur-pos :x])
                                            (get-in @at-status [:cur-pos :y])))
              (dec rep)))
     board)))


;;;
;; these are used to color the path of a and b

;; co-ordinates of path of a
(def path-a (test-func status-a [] 50))
;; co-ordinates of path of b
(def path-b (test-func status-b [] 50))


;; status-a and status-b were used to generate path-a and path-b
;; they are also used during the game to get current position and hence are rest.

(reset! status-a {:direction :right
                  :cur-pos {:x -1
                            :y 0}
                  :count 0})
(reset! status-b {:direction :left
                  :cur-pos {:x 10
                            :y 9}
                  :count 0})


(defn current-pos
  "Returns true if x and y are current position of A or B"
  [x y]
  (or (and (= x
              (get-in @status-a [:cur-pos :x]))
           (= y
              (get-in @status-a [:cur-pos :y])))
      (and (= x
              (get-in @status-b [:cur-pos :x]))
           (= y
              (get-in @status-b [:cur-pos :y])))))


(defn get-color
  "returns the color depending upon the position of the element
  if the element is the current position , it is white
  else it is red or blue depending on the path"
  [x y]
  (if (current-pos x y)
    "white"
    (if (some (fn [arr] (= [x y] arr))
              path-b)
      "red"
      "blue")))


(defn toggle-buttons
  "toggles the buttons (enables one and disables other)"
  [id1 id2]
  (set! (.-disabled (.getElementById js/document id1))
        true)
  (set! (.-disabled (.getElementById js/document id2))
        false))


(defn change-cur-pos
  "updates the current postion in atom a or b"
  [id1 id2]
  (toggle-buttons id1 id2)
  (if (= id1 "a")
     (test-func status-a (rand-nth (range 7)))
     (test-func status-b (rand-nth (range 7)))))


(defn home-page []
  [:div  [:td
          (doall (for [x (range 10)]
                   [:tr
                    (doall (for [y (range 10)]
                             [:input {:type "button"
                                      :style {:background-color (get-color y x)
                                              :height "50"
                                              :width  "50"}}]))]))]
   [:input {:id "a"
            :type "button"
            :style {:height "50"
                    :width "100"}
            :value "Player A"
            :on-click #(change-cur-pos "a" "b")}]
   [:input {:id "b"
            :type "button"
            :style {:height "50"
                    :width "100"}
            :value "Player B"
            :on-click #(change-cur-pos "b" "a")}]])




(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
