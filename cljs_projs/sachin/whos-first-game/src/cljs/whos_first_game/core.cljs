(ns whos-first-game.core
    (:require [reagent.core :as reagent :refer [atom]]))

(defn log
  [& msgs]
  (.log js/console (apply str msgs)))




(def board (reagent/atom {:size 8
                  :chance 0
                  :a {:current-pos [0 0]
                      :dir :right
                      :color "red"
                      :path []}

                  :b {:current-pos [7 7]
                      :dir :left
                      :color "yellow"
                      :path []}
                  :board []}))



(defn make-board
  []
  (let [size (:size @board)]
    (swap! board assoc :board  (vec (doall (for [x (range size)
                                                          y (range size)]
                                                      {:pos-x x :pos-y y :value ""}))))))


(defn get-element
  [i j]
  (first (filter (fn [x]
                   (let [values (map val x)]
                     (and
                      (= i (first values))
                      (= j (second values)))))
                 (:board @board))))



(defn get-color
  [i j]
  (let [pos (:value (get-element i j))
        path (:path (:a @board))
        path1 (:path (:b @board))]
    (if (some #(= pos %) path)
      (:color (:a @board))
      (if  (some #(= pos %) path1)
        (:color (:b @board))
        "lime"))))


(defn fill-board
  []
  (let [size (:size @board)]
    (doall (map #(swap! board assoc-in [:board % :value] %)
                (range (* size size))))))






(defn get-position
  [value]
  (let [map1  (filter (fn [x]
                        (= value (:value x)))
                      (:board @board))
        val-map (flatten (map vals map1))]
    [(first val-map) (second val-map)]))


(defn update-current-position
  [x y element]
  (swap! board assoc-in [element :current-pos] [x y]))


(defn move-player
  [steps direction element]
  (let [[x-pos y-pos] (:current-pos (element @board))]
    (condp = direction
      :right (let [ans  (doall (mapv (fn [y]
                                       (:value (get-element x-pos y)))
                                     (range y-pos (+ y-pos steps))))
                   [x y] (get-position (last ans))]
               (update-current-position (inc x) y element)
               ans)

      :down (let [ans (doall (mapv (fn [x]
                                     (:value (get-element x y-pos)))
                                   (range x-pos (+ x-pos steps))))
                  [x y] (get-position (last ans))]
              (update-current-position x (dec  y) element)
              ans)

      :left (let [ans (doall (mapv (fn [y]
                                     (:value (get-element x-pos y)))
                                   (reverse  (range (- (inc  y-pos) steps) (inc y-pos)))))
                  [x y] (get-position (last ans))]
              (update-current-position (dec x) y element)
              ans)

      :up (let [ans (doall (mapv (fn [x]
                                   (:value (get-element x y-pos)))
                                 (reverse (range (- (inc  x-pos) steps) (inc x-pos)))))
                [x y] (get-position (last ans))]
            (update-current-position x (inc y) element)
            ans))))



(defn change-direction
  [dir element]
  (swap! board assoc-in [element :dir] dir))




(defn get-path-dir
  [size]
  (reverse (drop 1
                 (drop-last (mapcat
                             (fn [x y] [x y])
                             (range 2 (+ 2 size) 2) (range 2 (+ 2 size) 2))))))



(defn execute-spiral
 [element]
  (mapcat (fn [x]
            (let [ele (element @board)
                  dir (:dir ele)
                  cur-pos (:current-pos ele)]
              #_(println ele dir cur-pos)
              (condp = dir
                :right (do
                         (change-direction :down element)
                         (move-player x :right element))

                :down  (do
                         (change-direction :left element)
                         (move-player x :down element))

                :left (do
                        (change-direction :up element)
                        (move-player x :left element))

                :up (do
                      (change-direction :right element)
                      (move-player x :up element)))))
          (get-path-dir (:size @board))))

(defn set-paths
  []
  (let [a-path (apply vector (execute-spiral :a))
        b-path (apply vector (execute-spiral :b))]
    (swap! board update-in [:a :path] into  a-path)
    (swap! board update-in [:b :path] into  b-path)))

(make-board)
(fill-board)
(set-paths)

(defn game-over?
  []
  (let [a-count (count (:path (:a @board)))
        b-count (count (:path (:b @board)))]
    (when (zero? a-count)
      (js/alert "A wins")
      true)
    (when (zero? b-count)
      (js/alert "B wins")
      true)))

(defn play-move
  [player moves]
  (let [path (:path (player @board))
        pos (last (take moves path))
        rem-path (vec (drop moves path))]
    #_(set! (.-value (.getElementById js/document 0))
          "A")
    (swap! board update-in [player] assoc-in [:path] rem-path)))

(defn play-game
  [player]
  (let [dcount (rand-int 7)
        path (:path (player @board))
        movrem (count path)]
    (log "!@#" (game-over?))
    (swap! board assoc :chance dcount)
    (if (> dcount movrem)
      (js/alert "Invalid Move! Next player plays")
      (play-move player dcount))))

;; -------------------------
;; Views

(defn home-page []
  #_(log "^^^^^" @board)
  [:div [:h2 "Welcome to whos-first-game"]
   [:input {:type "button" :value "PLAYER A" :style {:height "40px"
                                                     :width "200px"}
            :on-click #(play-game :a)}]
   [:input {:type "button" :value "PLAYER B" :style {:height "40px"
                                                     :width "200px"}
            :on-click #(play-game :b)}]
   [:input {:type "button" :disabled true
            :style {:height "40px"
                    :width "200px"}
            :value (str "Dice count:" (:chance @board))}]
   (doall (for [i (range 8)]
            ^{:key i} [:div (doall (for [j (range 8)]
                               ^{:key j} [:input {:type "button"
                                                  :style {:background-color (do #_(log "i" i "j" j (get-color i j))
                                                                                #_(log (:value (get-element i j)))
                                                                                (get-color i j))
                                                          :height "50px"
                                                          :width "50px"}
                                                  :id (+ (* i 8) j)
                                                  }]))]))])


;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []

  (mount-root))
