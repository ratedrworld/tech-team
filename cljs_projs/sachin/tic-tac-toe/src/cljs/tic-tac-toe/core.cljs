(ns tic-tac-toe.core)

(def arry [["" "" ""]
           ["" "" ""]
           ["" "" ""]])

(def board (atom arry))

(defn log
  [&msgs]
  (.log js/console (apply str msgs)))


(defn next-move
  "Returns X or O according to last move"
  []
  (let [in (flatten @board)
        cx (count (filter #(= "X" %) in))
        co (count (filter #(= "O" %) in))]
    (.log js/console (str in "!!!!!" cx "!!!!!!" co))
    (if(<= cx co)
      "X"
      "O")))

(defn check-row
  "Checks if elements on row are in win state"
  []
        (some true? (mapv #(= 1 (count
                     (if (= '("") (distinct (get @board %)))
                       [0 0]
                       (distinct (get @board %)))))
                          (range 0 3))))

(defn check-column
  "Checks if elements on column are in win state"
  []
  (some true?
        (mapv (fn [x]
                (= 1 (count
                      (if (= '("") (distinct (map
                                               #(get-in @board [% x])
                                               (range 0 3))))
                        [0 0]
                        (distinct (map #(get-in @board [% x]) (range 0 3)))))))
              (range 0 3))))

(defn check-diagonal
  []
  (some true?
        (map #(= 1 (count (if (= '("") (distinct %))
                            [0 0]
                            (distinct %))))
             (vector (map #(get-in @board [%1 %2]) (range 0 3) (range 0 3))
                     (map #(get-in @board [%1 %2]) '(2 1 0) '(0 1 2))))))
(defn check-win?
  "Returns true if user has won else false"
  []
  (or
   (check-row)
   (check-column)
   (check-diagonal)))

 (defn play
   [inp]

   (let [val (next-move)
         i (quot inp 3)
         j (rem inp 3)]
     (set! (.-disabled (.getElementById js/document inp))
           true)

     (set! (.-value (.getElementById js/document inp))
           val)

     (swap! board assoc-in [i j] val)

     (if (check-win?)
       (js/alert (str  "Congratulations: Player " (.-value (.getElementById js/document inp)) " wins")))))
