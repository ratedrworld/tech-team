(ns tic_tac_toe.new_xo
  (:require [clojure.string :as String]))

(defn restart []
  (.log js/console "restart")
  (reset! board (blank))
  (doall (for [i (range 3)
               j (range 3)
               :let [blockno (str "box" i j)]]
           (set! (.-innerHTML (.getElementById js/document blockno)) ""))))

(defn blank []
  [["" "" ""] ["" "" ""] ["" "" ""]])

(def board (atom (blank)))

(defn x-or-o? []
  (if (odd? (count (filter empty? (flatten @board))))
    "X"
    "O"))

(defn make-move [i j]
  (let [a (x-or-o?)]
    (swap! board assoc-in [i j] a)
    (set! (.-innerHTML (.getElementById js/document (str "box" i j))) a)))

(defn done-row? [i]
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [i %]) (range 0 3))))

(defn done-col? [i]
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [% i]) (range 0 3))))

(defn diag1? []
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [%1 %2]) (range 0 3) (range 0 3))))

(defn diag2? []
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [%1 %2]) (range 0 3) (reverse (range 0 3)))))

(defn won? []
  (or (some #(if (not= % false) %) (map #(done-row? %) (range 3)))
      (some #(if (not= % false) %) (map #(done-col? %) (range 3)))
      (diag1?)
      (diag2?)))

(defn ttt-main
  "TIC TAC TOE MAIN FUNCTION"
  [i j]
  (let [new (make-move i j)]
    (if (won?)
      (do
        (js/alert (str "Player " (won?) " Won..!!"))
        (restart))
      false)))
