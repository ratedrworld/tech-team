(ns whos-first?.core
    (:require [reagent.core :as r]))

(defn log [& args]
  (.log js/console (apply str args)))

(def game-board
  (r/atom {:dir :right
           :current [0 0]
           :count 0
           :board []
           :paths {:a-path []
                   :b-path []}
           :multiplier? false
           :table []}))

(defn init [n]
  (doall (let [new-board (vec (for [i (range n)]
                                (vec (for [j (range n)]
                                       [i j]))))]
           (swap! game-board assoc
                  :dir :right
                  :current [0 0]
                  :count n
                  :board new-board
                  :table new-board))))

(defn make-move [color]
  (let [[x y] (get-in @game-board [:current])
        n (get-in @game-board [:count])
        dir (get-in @game-board [:dir])]
    (condp = dir
      :right (do
               (let [arr (doall (for [i (range y (+ y n))]
                                  (do (swap! game-board assoc-in [:table x i]
                                             {:val "" :color color})
                                      (get-in @game-board [:board x i]))))]
                 (swap! game-board assoc
                        :current [(inc x) (+ y (dec n))]
                        :dir :down
                        :count (- n 2))
                 arr))
      :down (do
              (let [arr (doall (for [i (range x (+ x n))]
                                 (do (swap! game-board assoc-in [:table i y]
                                            {:val "" :color color})
                                     (get-in @game-board [:board i y]))))]
                (swap! game-board assoc
                       :current [(+ x (dec n)) (dec y)]
                       :dir :left)
                arr))
      :left (do
              #_(reverse (drop (- (inc y) n) (take (inc y) (get-in @game-board [:board x]))))
              (let [arr (doall (for [i (range n)]
                                 (do (swap! game-board assoc-in [:table x (- y i)]
                                            {:val "" :color color})
                                     (get-in @game-board [:board x (- y i)]))))]
                (swap! game-board assoc
                       :current [(dec x) (- y (dec n))]
                       :dir :up
                       :count (- n 2))
                arr))
      :up (do
            (let [arr (doall (for [i (reverse (range (- (inc x)  n) (inc x)))]
                               (do (swap! game-board assoc-in [:table i y]
                                          {:val "" :color color})
                                   (get-in @game-board [:board i y]))))]
              (swap! game-board assoc
                     :current [(- x (dec n)) (inc y)]
                     :dir :right)
              arr)))))

(defn traverse []
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :a-path] into (make-move "yellow")))
  (swap! game-board assoc
         :dir :left
         :current [9 9]
         :count 10)
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :b-path] into (make-move "lime")))
  (get @game-board :paths))


;; -------------------------
;; Views

(defn init-board [size]
  [:table
   (doall
    (map (fn [i]
           ^{:key i} [:tr (doall
                           (map (fn [j]
                                  ^{:key j} [:td {:style {:background-color
                                                          (get-in @game-board [:table i j :color])}}
                                             (get-in @game-board [:table i j :val])])
                                (range size)))])
         (range size)))])

(defn change-pos [player moves path]
  (let [[i j] (first (get-in @game-board [:paths path]))
        new-path (doall (drop moves (get-in @game-board [:paths path])))
        [x y] (first new-path)]
    (swap! game-board assoc-in [:table i j :val] "")
    (swap! game-board assoc-in [:table x y :val] player)
    (swap! game-board assoc-in [:paths path] new-path)
    (log "CHanged POSition")
    (log (:table @game-board))
    ))

(defn play [player]
  (let [moves (rand-nth [1 2 3 4 5 6])]
    #_(when (:multiplier))
    (log moves)
    (cond (= 1 player) (change-pos "A" moves :a-path)
          (= 2 player) (change-pos "B" moves :b-path))
    ))

(init 10)
(traverse)

(defn home-page []
  (log ">>>>>>>>>>>>> TRAVERSED")
  [:div
   [:button {:on-click #(play 1)} "CLICK A"]
   [:button {:on-click #(play 2)} "CLICK B"]
   [init-board 10]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
