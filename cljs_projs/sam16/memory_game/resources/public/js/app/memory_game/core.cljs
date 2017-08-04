(ns memory_game.core)

(def board (atom
            [{:id 1 :value " " :status "closed" :matched "no"}
             {:id 2 :value "" :status "closed" :matched "no"}
             {:id 3 :value "" :status "closed" :matched "no"}
             {:id 4 :value "" :status "closed" :matched "no"}
             {:id 5 :value "" :status "closed" :matched "no"}
             {:id 6 :value "" :status "closed" :matched "no"}
             {:id 7 :value "" :status "closed" :matched "no"}
             {:id 8 :value "" :status "closed" :matched "no"}
             {:id 9 :value "" :status "closed" :matched "no"}
             {:id 10 :value "" :status "closed" :matched "no"}
             {:id 11 :value "" :status "closed" :matched "no"}
             {:id 12 :value "" :status "closed" :matched "no"}
             {:id 13 :value "" :status "closed" :matched "no"}
             {:id 14 :value "" :status "closed" :matched "no"}
             {:id 15 :value "" :status "closed" :matched "no"}
             {:id 16 :value "" :status "closed" :matched "no"}]) )

(defn log
  [& args]
  (.log js/console (apply str args)))

(defn alphabets []
  (map char (range 65 91)))

(defn rand-alphs [size]
  (shuffle (mapcat (fn [x] (let [a (str (rand-nth (alphabets)))]
                    [a a]))
        (range (* size 2)))))

(defn init [init-lis]
  (doall  (map
           (fn [x y] (swap! board update-in [y] assoc :value x) (str x))
           init-lis
           (range 0 16)))
  (log @board))

(defn set-value
  [place value]
  (set! (.-value (.getElementById js/document place)) value))

(defn change-status [id1 id2]
    (swap! board update-in [(dec id1)] assoc :matched "yes")
  (swap! board update-in [(dec  id2)] assoc :matched "yes")
    (set! (.-disabled (.getElementById js/document id1)) true)
  (set! (.-disabled (.getElementById js/document id2)) true)
  (log "Changed status"))

(defn close-cards [id1 id2]
  (set-value id1 "")
  (set-value id2 "")
  (swap! board assoc-in [(dec id1) :status] "closed")
  (swap! board update-in [(dec id2)] assoc :status "closed")
  (log "close cards"))

(defn open-card
  [pos]
  (swap! board update-in [(dec  pos)] assoc :status "open")
  (set-value pos (get-in @board [(dec pos) :value]))
  (log "Open card " pos " With value " (get-in @board [(dec pos) :value])))

(defn filter-list
  []
  (filter (fn [x] (and (= "open" (get-in x [:status]))
                       (= "no" (get-in x [:matched]))))
          @board))

(defn check-match
  [fil-lis]
  (let [[a b] fil-lis
        {id1 :id val1 :value} a
        {id2 :id val2 :value} (or b {})
        my-fn (if-not (= val1 val2)
                (fn [x y] (.setTimeout js/window #(close-cards x y) (* 1 1000)))
                change-status)]
    (when (> (count fil-lis) 1)
      (my-fn id1 id2))))

(defn game-over?
  []
  (when  (= 16 (count
              (filter (fn [x] (= "yes" (get-in x [:matched])))
                      @board)))
    (js/alert "GAME OVER")
    (.reload js/location true)))

(init (rand-alphs 4))

(defn -main
  "I don't do a whole lot ... yet."
  [pos]
  #_(log (str pos))

  (open-card pos)
  (check-match (filter-list))
  (game-over?))
