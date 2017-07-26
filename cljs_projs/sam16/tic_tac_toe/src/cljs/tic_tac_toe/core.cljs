(ns tic_tac_toe.core
  (:require [clojure.string :as String]))

(defn get-input []
  (vec (for [i (range 3)]
         (vec (for [ j (range 3)
                    :let [blockno (str "box" i j)]]
              (.-innerHTML (.getElementById js/document blockno)))))))

(defn x-or-o? [input]
  (if (odd? (count (filter empty? (flatten input))))
    "X"
    "O"))

(defn make-move [i j brd]
  (vec (for [x (range 3)]
         (vec (for [y (range 3)]
                (if (and (= x i) (= y j))
                  (do
                    (set! (.-innerHTML (.getElementById js/document (str "box" i j))) (x-or-o? brd))
                    (x-or-o? brd))
                  (get-in brd [x y])))))))

(defn done-row? [i board]
  (reduce (fn [a x] (if (and (= a x) (not= x ""))  a false)) (mapv #(get-in board [i %]) (range 0 3))))

(defn done-col? [i board]
  (reduce (fn [a x] (if (and (= a x) (not= x ""))  a false)) (mapv #(get-in board [% i]) (range 0 3))))

(defn diag1? [board]
  (reduce (fn [a x] (if (and (= a x) (not= x ""))  a false)) (mapv #(get-in board [%1 %2]) (range 0 3) (range 0 3))))

(defn diag2? [board]
  (reduce (fn [a x] (if (and (= a x) (not= x ""))  a false)) (mapv #(get-in board [%1 %2]) (range 0 3) (reverse (range 0 3)))))

(defn won? [board]
  (or (some #(if (not= % false) %) (map #(done-row? % board) (range 3)))
      (some #(if (not= % false) %) (map #(done-col? % board) (range 3)))
      (diag1? board)
      (diag2? board)))

(defn ttt-main
  "TIC TAC TOE MAIN FUNCTION"
  [i j]
  (let [inp-board (get-input)
        ;;zk (won? (check))
        new (make-move i j inp-board)]
    (js/alert new)
    (if (won? new)
      (js/alert (str "Player " (won? new) " Won..!!"))
      false)
    ))
