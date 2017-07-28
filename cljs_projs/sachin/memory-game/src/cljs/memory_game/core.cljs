(ns memory-game.core)

#_(defn get-input
  []
  (apply hash-map
         (mapcat (fn [x y] [x y])
                 (range 1 17)
                 (for [i (range 1 17)]
                   (hash-map :value (.-value (.getElementById js/document (str i "1"))),
                             :status (.-value (.getElementById js/document (str i "2"))),
                             :result (.-value (.getElementById js/document (str i "3"))))))))

(defn log [& msgs]
  (.log js/console (apply str msgs)))

(defn ->long [x] (js/parseInt x))

(defn get-value
  [place]
  (.-value (.getElementById js/document place)))

(defn set-value
  [place value]
  (set! (.-value (.getElementById js/document place)) value))

(defn get-input []
  (map (fn [i]
         {:id i
          :value (get-value (+  (* 10 i) 1))
          :status (get-value (+  (* 10 i) 2))
          :matched (get-value (+  (* 10 i) 3))})
       (range 1 17)))

(defn filter-list [inp]
  (filter (fn [v]
            (and (= "open" (:status v))
                 (= "no" (:matched v))))
          inp))

(defn change-status [id1 id2]
  (let [id1 (* (->long id1) 10)
        id2 (* (->long id2) 10)]
    (log id1 "!!!!!!!!!!" id2)
    (set-value (+ id1 3) "yes")
    (set-value (+ id2 3) "yes")
    (set! (.-disabled (.getElementById js/document id1)) true)
    (set! (.-disabled (.getElementById js/document id2)) true)))

(defn close-cards [id1 id2]
  (let [id1 (* (->long id1) 10)
        id2 (* (->long id2) 10)]
    (log id1 "CLOSED" id2)
    (set-value id1 "")
    (set-value id2 "")
    (set-value (+ id1 2) "closed")
    (set-value (+ id2 2) "closed")))

(defn check-match [ans]
  (let [[v1 v2] ans
        {id1 :id val1 :value} v1
        {id2 :id val2 :value} (or v2 {})
        my-fn (if-not (= val1 val2)
                (fn [x y]
                  (.setTimeout js/window  #(close-cards x y) (* 1 1000)))
                change-status)]
  (when (> (count ans) 1)
    (my-fn id1 id2))))

(defn open-card
  [pos]
  (let [int-pos (->long pos)]
    (log int-pos)
    (set-value (+ int-pos 2) "open")
    (set-value int-pos (get-value (+ int-pos 1)))))

(defn -main
  "I don't do a whole lot ... yet."
  [pos]
  (log (str pos))
  (open-card pos)
  (let [ip (get-input)]
    #_(log (str "@@@@@" ip))
    #_(js/alert ip)
    (log "###" (filter-list ip))
    (check-match (filter-list ip))))

(defn gen-rand []
  (shuffle (mapcat
            (fn [x] [x x])
            (range 1 9))))

(defn initial [in]
  #_(js/alert in)
  (doall (map (fn [x y]
                (set! (.-value (.getElementById js/document (str x "1"))) y))
              (range 1 17)
              in)))

(initial (gen-rand))
