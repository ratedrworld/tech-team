(ns tictactoe.core)



(defn make-board
  "makes a board map using the values of input tags"
  ([arr] (make-board arr {} 1))
  ([arr new-board id]
   (if (> id 10)
     new-board
     (make-board (rest arr)
                 (assoc-in new-board [id :value] (first arr))
                 (inc id)))))
(defn print-b
  "sets the value of clicked tag and alos sets the next move"
  [next-mov id]
  (set! (.-value (.getElementById js/document id))
          next-mov)
    (if (= "x" next-mov)
      (set! (.-value (.getElementById js/document 10))
            "o")
      (set! (.-value (.getElementById js/document 10))
            "x")))


(defn rev-interleave
  "reverse interleaves a sequence into number of sequences"
  [arr n]
  (let [part (partition n arr)]
    (apply map list part)))


(defn upd-board
  "calls print-b to display the move and updated the board map with the new position"
  [board id]
  (let [value (get-in board [id :value])
        next-mov (get-in board [10 :value])]
    (print-b next-mov id)
    (assoc-in board [id :value] next-mov)))


(defn equal-array?
  "checks if all the elements in the array are equal
  gives false when all are empty"
  [array]
  (if-not (empty? (first array))
    (apply = array)))


(defn game-over
  "divides the board into rows, columns and two diagnols and calls equal-array on each of them"
  [board]
  (let [values (map #(get-in board [% :value]) (range 1 10))
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
  (let [value-arr (map #(.-value (.getElementById js/document %))
                       (range 1 11))
        board     (make-board value-arr)
        new-board (upd-board board id)]

    (when (game-over new-board)
      (let [winner (get-in new-board [10 :value])]
        (js/alert (str "Game over! Player " winner " won")))
      (loop [x 1]
        (when (< x 10)
          (set! (.-disabled (.getElementById js/document x))
                true)
          (recur (+ x 1)))))))
