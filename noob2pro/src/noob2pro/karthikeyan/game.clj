(ns noob2pro.karthikeyan.game)

(defn init-board
  "Returns a n x n board with random values between 0 and 1"
  [n]
  (into [] (map (fn [a]
                  (into [] (map #(rand-int %)
                                (repeat n 2))))
                (range n))))

(defn get-count-neighbours
  [board x y]
  (let [a (get-in board [(dec x) (dec y)] 0)
        b (get-in board [(inc x) (inc y)] 0)
        c (get-in board [(inc x) y] 0)
        d (get-in board [x (inc y)] 0)
        e (get-in board [(dec x) y] 0)
        f (get-in board [x (dec y)] 0)
        g (get-in board [(inc x) (dec y)] 0)
        h (get-in board [(dec x) (inc y)] 0)]
    (+ a b c d e f g h)))

(defn rules
  [board x y]
  (let [a (get-count-neighbours board x y)]
    (if (= 1 (get-in board [x y]))
      (if (< a 2)
        0
        (if (or (= a 2) (= a 3))
          1
          (if (> a 3)
            0)))
      (if (= a 3)
        1
        0))))

(defn index-list
  [n]
  (for [i (range n)
        j (range n)]
    [i j]))

(defn traverse
  [board n]
  (let [indexes (index-list n)]
    (partition n (map (fn [a]
                        (rules board (first a) (second a)))
                      indexes))))

(defn infinite-traverse
  ([n]
   (let [board (init-board n)]
     (infinite-traverse board n)))
  ([board n]
   (let [nboard (traverse board n)]
     (cons nboard (lazy-seq (infinite-traverse nboard n))))))
