(ns tictactoe.core)



(defn make-board
  "Returns a map with 9 indexes and empty positions"
  ([] (make-board {} 1))
  ([bmap index]
   (if (= index 9)
     (assoc bmap :next-move "x")
     (recur (assoc bmap index "") (inc index)))))

(def board (atom (make-board)))



(defn print-board
  "sets the value of all elements , taking value from the atom board"
  []
  (doall (map (fn [id]
                (set! (.-value (.getElementById js/document id))
                      (get @board id)))
              (range 1 10))))


(defn rev-interleave
  "reverse interleaves a sequence into number of sequences
  This is used to get columns from the board"
  [arr n]
  (let [part (partition n arr)]
    (apply map list part)))



(defn equal-array?
  "checks if all the elements in the array are equal
  gives false when all are empty"
  [array]
  (if-not (empty? (first array))
    (apply = array)))


(defn game-over
  "divides the board into rows, columns and two diagnols and calls equal-array on each of them"
  []
  (let [values (map #(get @board %) (range 1 10))
        [r1 r2 r3] (partition 3 values)
        [c1 c2 c3] (rev-interleave values 3)
        d1 (map #(nth values %) [0 4 8])
        d2 (map #(nth values %) [2 4 6])]
    (some equal-array? [r1 r2 r3 c1 c2 c3 d1 d2])))



(defn -main
  "I don't do a whole lot ... yet."
  [id]
  (set! (.-disabled (.getElementById js/document id))
        true)
  (let [next-move (get @board :next-move)]
    (swap! board assoc id next-move)
    (if (= next-move "x")
      (swap! board assoc :next-move "o")
      (swap! board assoc :next-move "x"))
    (set! (.-value (.getElementById js/document 10))
          (get @board :next-move))
    (print-board)
    (when (game-over)
      (js/alert (str "Game over! Player " next-move " won"))
      (doall
       (map (fn [id]
              (set! (.-disabled (.getElementById js/document id))
                    true)) (range 1 10))))))
