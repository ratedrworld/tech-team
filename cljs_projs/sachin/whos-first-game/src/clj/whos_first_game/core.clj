(ns whos-first-game.core)


#_[{:pos-x 0, :pos-y 0, :value 0} {:pos-x 0, :pos-y 1, :value 1} {:pos-x 0, :pos-y 2, :value 2} {:pos-x 0, :pos-y 3, :value 3} {:pos-x 0, :pos-y 4, :value 4} {:pos-x 0, :pos-y 5, :value 5} {:pos-x 0, :pos-y 6, :value 6} {:pos-x 0, :pos-y 7, :value 7} {:pos-x 1, :pos-y 0, :value 8} {:pos-x 1, :pos-y 1, :value 9} {:pos-x 1, :pos-y 2, :value 10} {:pos-x 1, :pos-y 3, :value 11} {:pos-x 1, :pos-y 4, :value 12} {:pos-x 1, :pos-y 5, :value 13} {:pos-x 1, :pos-y 6, :value 14} {:pos-x 1, :pos-y 7, :value 15} {:pos-x 2, :pos-y 0, :value 16} {:pos-x 2, :pos-y 1, :value 17} {:pos-x 2, :pos-y 2, :value 18} {:pos-x 2, :pos-y 3, :value 19} {:pos-x 2, :pos-y 4, :value 20} {:pos-x 2, :pos-y 5, :value 21} {:pos-x 2, :pos-y 6, :value 22} {:pos-x 2, :pos-y 7, :value 23} {:pos-x 3, :pos-y 0, :value 24} {:pos-x 3, :pos-y 1, :value 25} {:pos-x 3, :pos-y 2, :value 26} {:pos-x 3, :pos-y 3, :value 27} {:pos-x 3, :pos-y 4, :value 28} {:pos-x 3, :pos-y 5, :value 29} {:pos-x 3, :pos-y 6, :value 30} {:pos-x 3, :pos-y 7, :value 31} {:pos-x 4, :pos-y 0, :value 32} {:pos-x 4, :pos-y 1, :value 33} {:pos-x 4, :pos-y 2, :value 34} {:pos-x 4, :pos-y 3, :value 35} {:pos-x 4, :pos-y 4, :value 36} {:pos-x 4, :pos-y 5, :value 37} {:pos-x 4, :pos-y 6, :value 38} {:pos-x 4, :pos-y 7, :value 39} {:pos-x 5, :pos-y 0, :value 40} {:pos-x 5, :pos-y 1, :value 41} {:pos-x 5, :pos-y 2, :value 42} {:pos-x 5, :pos-y 3, :value 43} {:pos-x 5, :pos-y 4, :value 44} {:pos-x 5, :pos-y 5, :value 45} {:pos-x 5, :pos-y 6, :value 46} {:pos-x 5, :pos-y 7, :value 47} {:pos-x 6, :pos-y 0, :value 48} {:pos-x 6, :pos-y 1, :value 49} {:pos-x 6, :pos-y 2, :value 50} {:pos-x 6, :pos-y 3, :value 51} {:pos-x 6, :pos-y 4, :value 52} {:pos-x 6, :pos-y 5, :value 53} {:pos-x 6, :pos-y 6, :value 54} {:pos-x 6, :pos-y 7, :value 55} {:pos-x 7, :pos-y 0, :value 56} {:pos-x 7, :pos-y 1, :value 57} {:pos-x 7, :pos-y 2, :value 58} {:pos-x 7, :pos-y 3, :value 59} {:pos-x 7, :pos-y 4, :value 60} {:pos-x 7, :pos-y 5, :value 61} {:pos-x 7, :pos-y 6, :value 62} {:pos-x 7, :pos-y 7, :value 63}]


(defn make-board
  [size]
  (apply vector (for [x (range size)
                       y (range size)]
                   {:pos-x x :pos-y y :value ""})))

(defn fill-board
  [size]
  (map #(swap! board assoc-in [% :value] %) (range (* size size))))

(def board (atom (make-board 8)))


(defn get-element
  [i j]
  (first (filter (fn [x]
                   (let [values (map val x)]
                     (and
                      (= i (first values))
                      (= j (second values)))))
                 @board)))

(defn get-position
  [value]
  (let [map1  (filter (fn [x]
                       (= value (:value x)))
                     @board)
        val-map (flatten (map vals map1))]
    (vector (first val-map) (second val-map))))


(defn change-dir-indexes
  [size]
  (flatten (cons size (reverse (vec  (zipmap (range size) (range size)))))))


(defn move-right
  [[x-pos y-pos] steps]
  (map (fn [y]
         (:value (get-element x-pos y)))
          (range y-pos (inc (+ y-pos steps)))))

(defn move-down
  [[x-pos y-pos] steps]
  (map (fn [x]
         (:value (get-element x y-pos)))
       (range x-pos (inc (+ x-pos steps)))))


(defn move-left
  [[x-pos y-pos] steps]
  (map (fn [y]
         (:value (get-element x-pos y)))
       (reverse  (range (- y-pos steps) (inc y-pos)))))

(defn move-up
  [[x-pos y-pos] steps]
  (map (fn [x]
         (:value (get-element x y-pos)))
       (reverse (range (- x-pos steps) (inc x-pos)))))

#_(defn execute-round
  [cp dir out]
  (condp = dir
    :right (do (println "CP:" cp "dir:" dir "out:" out)
             (recur (get-position (last (move-right cp 7))) :down (conj out (move-right cp 7))))

    :down (do (println "CP:" cp "dir:" dir "out:" out)
              (recur (get-position (last (move-down cp 6))) :left (conj out (move-down cp 6))))

    :left (do (println "CP:" cp "dir:" dir "out:" out)
              (recur (get-position (last (move-left cp 6))) :up (conj out (move-left cp 6))))

    :up (do (println "CP:" cp "dir:" dir "out:" out) (recur (get-position (last (move-up cp 5))) :right (conj out (move-up cp 5))))

    :else
    out))
