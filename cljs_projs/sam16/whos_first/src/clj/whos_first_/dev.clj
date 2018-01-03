(ns whos-first?.dev)

(def game-board
  (atom {:dir :right
         :current [0 0]
         :count 0
         :board []
         :paths {:a-path []
                 :b-path []}
         :multiplier? false
         :table []}))

(defn init [n]
  (let [new-board (vec (for [i (range n)]
                (vec (for [j (range n)]
                       [i j]))))]
    (swap! game-board assoc
           :dir :right
           :current [0 0]
           :count n
           :board new-board
           :table new-board)))

(init 6)

(defn make-move [color]
  (let [[x y] (get-in @game-board [:current])
        n (get-in @game-board [:count])
        dir (get-in @game-board [:dir])]
    (condp = dir
      :right (do
               (let [arr (for [i (range y (+ y n))]
                           (do (swap! game-board assoc-in [:table x i]
                                      {:val "" :color color})
                               (get-in @game-board [:board x i])))]
                 (swap! game-board assoc
                        :current [(inc x) (+ y (dec n))]
                        :dir :down
                        :count (- n 2))
                 arr))
      :down (do
              (let [arr (for [i (range x (+ x n))]
                          (do (swap! game-board assoc-in [:table i y]
                                     {:val "" :color color})
                              (get-in @game-board [:board i y])))]
                (swap! game-board assoc
                       :current [(+ x (dec n)) (dec y)]
                       :dir :left)
                arr))
      :left (do
              #_(reverse (drop (- (inc y) n) (take (inc y) (get-in @game-board [:board x]))))
              (let [arr (for [i (range n)]
                          (do (swap! game-board assoc-in [:table x (- y i)]
                                     {:val "" :color color})
                              (get-in @game-board [:board x (- y i)])))]
                (swap! game-board assoc
                       :current [(dec x) (- y (dec n))]
                       :dir :up
                       :count (- n 2))
                arr))
      :up (do
            (let [arr (for [i (reverse (range (- (inc x)  n) (inc x)))]
                        (do (swap! game-board assoc-in [:table i y]
                                   {:val "" :color color})
                            (get-in @game-board [:board i y])))]
              (swap! game-board assoc
                     :current [(- x (dec n)) (inc y)]
                     :dir :right)
              arr)))))

(defn traverse []
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :a-path] into (make-move "yellow")))
  (swap! game-board assoc
         :dir :left
         :current [5 5]
         :count 6)
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :b-path] into (make-move "green")))
  (get @game-board :paths))


(defn change-pos [player moves path]
  (let [curr-path (get-in @game-board [:paths path])]
    (if (< moves (count curr-path))
      (let [[i j] (first curr-path)
            new-path (drop moves curr-path)
            [x y] (first new-path)]
        (swap! game-board assoc-in [:table i j :val] "")
        (swap! game-board assoc-in [:table x y :val] player)
        (swap! game-board assoc-in [:paths path] new-path)
        (println "Put" player "from" [i j] "to" [x y]))
      (println "Cant move" moves)
      )))

(defn play [player]
  (let [moves (rand-nth [1 2 3 4 5 6])]
    #_(when (:multiplier))
    (println moves)
    (cond (= 1 player) (change-pos "A" moves :a-path)
          (= 2 player) (change-pos "B" moves :b-path))
    ))
