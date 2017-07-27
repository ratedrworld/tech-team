(ns memory-game.core)






(defn make-rand-arr
  [n]
  (let [limit (* n n)
        arr (range 0 (/ limit 2))]
    (shuffle (concat arr arr))))


(defn make-board
  ([n] (make-board {} (make-rand-arr n) 1))
  ([board rand-arr pos]
   (if (empty? rand-arr)
     board
     (make-board (assoc board pos (str (first rand-arr))) (rest rand-arr) (inc pos)))))




(def board (make-board 4))

(defn disable
  [id1 id2]
  (doall (map #(set! (.-disabled (.getElementById js/document %))
                     true)
              [id1 id2]))
  (set! (.-value (.getElementById js/document 17))
        ""))

(defn clear
  [id1 id2]
  #_(.sleep js/Thread 1000)
  #_(js/alert "clear")
  (.setTimeout js/window
               (fn [x]
                 (doall (map #(set! (.-value (.getElementById js/document %))
                                    "")
                             [id1 id2 17])))
               (* 1 1000)))


(defn check
  [id1 id2]
  (if (= id1 id2)
    (set! (.-value (.getElementById js/document id1))
         "")
    (let [values (map #(.-value (.getElementById js/document %))
                      [id1 id2])]
      (if (apply = values)
        (disable id1 id2)
        (clear id1 id2)))))



(defn -main
  "I don't do a whole lot ... yet."
  [id]
  (let [value (get board id)
        last-tile (.-value (.getElementById js/document 17))]
    (set! (.-value (.getElementById js/document id))
          value)
    (if (empty? last-tile)
      (set! (.-value (.getElementById js/document 17))
            id)
      (check id last-tile))))
