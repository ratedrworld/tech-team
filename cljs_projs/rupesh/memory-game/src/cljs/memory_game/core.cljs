(ns memory-game.core)



(defn make-rand-arr
  [n]
  (let [limit (* n n)
        arr (range 0
                   (/ limit 2))]
    (shuffle (concat arr arr))))


(defn make-board
  ([n] (make-board {} (make-rand-arr n) 1))
  ([board rand-arr pos]
   (if (empty? rand-arr)
     (assoc board :last "")
     (make-board (assoc board
                        pos (str
                             (first rand-arr)))
                 (rest rand-arr)
                 (inc pos)))))


(def board (atom (make-board 4)))



(defn disable
  [id1 id2]
  (doall (map #(set! (.-disabled (.getElementById js/document %))
                     true)
              [id1 id2])))


(defn clear
  [id1 id2]
  (.setTimeout js/window
               (fn [x]
                 (doall (map #(set! (.-value (.getElementById js/document %))
                                    "")
                             [id1 id2])))
               (* 1 500)))


(defn check
  [id1 id2]

  (let [values (map #(get @board %)
                    [id1 id2])]
    (swap! board assoc :last "")
    (if (apply = values)
      (disable id1 id2)
      (clear id1 id2))))


(defn -main
  [id]
  (let [value (get @board id)
        last-tile (get @board :last)]

    (set! (.-value (.getElementById js/document id))
          value)
    (if (empty? (str last-tile))
      (swap! board assoc :last id)
      (check id last-tile))))
