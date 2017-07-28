(ns tic-tac-toe.oldmethod)

#_(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (js/alert  "Hello, World!"))

(defn convert-to-input
  "Converts the input X and O to 1 and O respectively"
  [board]
  (mapv vec  (partition 3
                        (mapv #(if (= "X" %)
                                 1
                                 (if (= "O" %)
                                   0
                                   nil))
                              board))))

(defn next-move
  "Returns X or O according to last move"
  [board]
  (let [in (flatten board)
        cx (count (filter #(= 1 %) in))
        co (count (filter #(= 0 %) in))]
    (if(<= cx co)
      "X"
      "O")))

(defn check-row
  "Checks if elements on row are in win state"
  [input]
  (some true?
        (mapv #(= 1 (count
                     (if (= '(nil)(distinct (get input %)))
                       [0 0]
                       (distinct (get input %)))))
              (range 0 3))))


(defn check-column
  "Checks if elements on column are in win state"
  [input]
  (some true?
        (mapv (fn [x]
                (= 1 (count
                      (if (= '(nil) (distinct (map
                                               #(get-in input [% x])
                                               (range 0 3))))
                        [0 0]
                        (distinct (map #(get-in input [% x]) (range 0 3)))))))
              (range 0 3))))


(defn check-diagonal
  [input]
  (some true?
        (map #(= 1 (count (if (= '(nil) (distinct %))
                            [0 0]
                            (distinct %))))
             (vector (map #(get-in input [%1 %2]) (range 0 3) (range 0 3))
                     (map #(get-in input [%1 %2]) '(2 1 0) '(0 1 2))))))

(defn check-win?
  "Returns true if user has won else false"
  [input]
  (or
   (check-row input)
   (check-column input)
   (check-diagonal input)))

#_(defn have-moves?
  [input]
  (< (count (flatten input)) 9))

#_(defn convert-to-output
  "Converts the input 1 and 0 to X and O respectively"
  [input]
  (map #(if (= 1 %)
          "X"
          "O")
       (flatten input)))

(defn play
  [inp]
  (set! (.-disabled (.getElementById js/document inp))
        true)

  (set! (.-value (.getElementById js/document inp))
        (next-move (convert-to-input
                    (mapv #(.-value (.getElementById js/document %))
                          (range 0 9)))))
  (let [in  (mapv #(.-value (.getElementById js/document %))
                  (range 0 9))]

    (if (check-win? (convert-to-input in))
      (js/alert (str  "Congratulations: Player " (.-value (.getElementById js/document inp)) " wins")))))
