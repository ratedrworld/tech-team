(ns whos-first?.dev)

(def game-board
  (atom {:dir :right
         :current [0 0]
         :count 0
         :board []
         :paths {:a-path []
                 :b-path []}
         :a-pos [0 0]
         :b-pos [0 0]
         :table []}))

(defn init [n]
  (let [new-board (vec (for [i (range n)]
                (vec (for [j (range n)]
                    (read-string (str i j))))))]
    (swap! game-board assoc
           :dir :right
           :current [0 0]
           :count n
           :board new-board)))

(init 6)

(defn make-move []
  (let [[x y] (get-in @game-board [:current])
        n (get-in @game-board [:count])
        dir (get-in @game-board [:dir])]
    (condp = dir
      :right (do
               (let [arr  (for [i (range y (+ y n))] (get-in @game-board [:board x i]))]
                 (swap! game-board assoc
                        :current [(inc x) (+ y (dec n))]
                        :dir :down
                        :count (- n 2))
                 arr)
               #_(println "traversed right, Now at " [(inc x) (+ y (dec n))] " count " (get-in @game-board [:count])))
      :down (do
              (let [arr  (for [i (range x (+ x n))] (get-in @game-board [:board i y]))]
                (swap! game-board assoc
                       :current [(+ x (dec n)) (dec y)]
                       :dir :left)
                arr)
              #_(println "traversed down, Now at" [(+ x (dec n)) (dec y)] " count " (get-in @game-board [:count])))
      :left (do
              #_(println (for [i (reverse (range (- y (dec n)) n))]
                           (get-in @game-board [:board x i])))
              (let [arr  (reverse (drop (- (inc y) n) (take (inc y) (get-in @game-board [:board x]))))]
                (swap! game-board assoc
                       :current [(dec x) (- y (dec n))]
                       :dir :up
                       :count (- n 2))
                arr)
              #_(println "traversed left, Now at" [(dec x) (- y (dec n))] " count " (get-in @game-board [:count])))
      :up (do
            (let [arr (for [i (reverse (range (- (inc x)  n) (inc x)))]
                        (get-in @game-board [:board i y]))]
              (swap! game-board assoc
                     :current [(- x (dec n)) (inc y)]
                     :dir :right)
              arr)
            #_(println "traversed up, Now at" [(- x (dec n)) (inc y)] " count " (get-in @game-board [:count]))))
    #_"MADE A MOVE"
    ))

(defn traverse []
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :a-path] into (make-move)))
  (swap! game-board assoc
         :dir :left
         :current [5 5]
         :count 6)
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :b-path] into (make-move)))
  (get @game-board :paths))
