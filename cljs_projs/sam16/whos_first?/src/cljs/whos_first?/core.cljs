(ns whos-first?.core
    (:require [reagent.core :as r]))

(defn log [& args]
  (.log js/console (apply str args)))

(def game-board
  (r/atom {:dir :right
           :current [0 0]
           :count 0
           :dices {:a "PLAY" :b "PLAY"}
           :board []
           :paths {:a-path [] :b-path []}
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
  (swap! game-board assoc-in [:table 4 5 :color] "#FF4136")
  (swap! game-board assoc-in [:table 5 4 :color] "#FF4136")
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
  (let [curr-path (doall (get-in @game-board [:paths path]))]
    (if (< moves (count curr-path))
      (let [[i j] (first curr-path)
            new-path (doall (drop moves curr-path))
            [x y] (first new-path)]
        (swap! game-board assoc-in [:table i j :val] "")
        (swap! game-board assoc-in [:table x y :val] player)
        (swap! game-board assoc-in [:paths path] new-path)
        #_(println "Put" player "from" [i j] "to" [x y])
        (log "Changed Position")
        new-path)
      (js/alert (str "Cant Move : " moves " Try in Next Turn"))
      )))

(defn setup []
  (init 10)
  (traverse))

(setup)

(defn multiplier? [moves]
  (if (:multiplier @game-board)
    (do (swap! game-board assoc-in [:multiplier] false)
      (* moves 2))
    moves))

(defn play [player]
  (let [moves (rand-nth [0 1 2 3 4 5 6 "X2"])]
    (swap! game-board assoc-in [:dices player] moves)
    (log moves)
    (if (= "X2" moves)
      (swap! game-board assoc-in [:multiplier] true)
      (let [path (condp = player
                   :a (do (set! (.-disabled (.getElementById js/document "a-btn")) true)
                          (set! (.-disabled (.getElementById js/document "b-btn")) false)
                          (change-pos "A" (multiplier? moves) :a-path))
                   :b (do (set! (.-disabled (.getElementById js/document "a-btn")) false)
                          (set! (.-disabled (.getElementById js/document "b-btn")) true)
                          (change-pos "B" (multiplier? moves) :b-path)))]
        (when (= 1 (count path))
          (js/alert "YOU WON!! GAMEOVER..!!")
          (.reload js/location true))))))

(defn home-page []
  (log ">>>>>> board" (:table @game-board))
  [:div
   [:h3 "A " [:button {:id "a-btn" :on-click #(play :a)} (get-in @game-board [:dices :a])]
    " WHO'S FIRST? "
    [:button {:id "b-btn" :on-click #(play :b)} (get-in @game-board [:dices :b])] " B "]
   [init-board 10]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
