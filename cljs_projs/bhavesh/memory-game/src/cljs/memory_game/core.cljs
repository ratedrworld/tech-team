(ns memory-game.core)






(defn make-rand-arr
  [n]
  (let [limit (* n n)
        arr (range 0 (/ limit 2))]
    (shuffle (concat arr arr))))


(defn make-board
  ([n] (make-board board (make-rand-arr n) 1))
  ([board rand-arr pos]
   (if (empty? rand-arr)
     board
     (make-board (assoc board pos (first rand-arr)) (rest rand-arr) (inc pos)))))




(def board (make-board 4))


(defn -main
  "I don't do a whole lot ... yet."
  [id]
  (js/alert (get board id)))
