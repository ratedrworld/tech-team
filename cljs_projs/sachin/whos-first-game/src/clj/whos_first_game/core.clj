(ns whos-first-game.core)


(defn make-board
  [size]
  (apply vector (for [x (range size)
                      y (range size)]
                  {:pos-x x :pos-y y :value ""})))

(def board (atom {:current-pos [0 0]
                  :dir :right
                  :board []}))


(defn fill-board
  [size]
  (map #(swap! board assoc-in [:board % :value] %) (range (* size size))))


(defn init-board
  [size]
  (swap! board assoc-in [:board] (make-board size)))


(defn get-element
  [i j]
  (first (filter (fn [x]
                   (let [values (map val x)]
                     (and
                      (= i (first values))
                      (= j (second values)))))
                 (:board @board))))

(defn get-position
  [value]
  (let [map1  (filter (fn [x]
                        (= value (:value x)))
                      (get-in @board [:board]))
        val-map (flatten (map vals map1))]
    [(first val-map) (second val-map)]))


(defn change-dir-indexes
  [size]
  (drop 1 (reverse (mapcat (fn [x y] [x y]) (range 1 (inc size)) (range 1 (inc size))))))

(defn update-current-position
  [x y]
  (swap! board assoc-in [:current-pos] [x y]))


(defn move-player
  [steps direction]
  (let [[x-pos y-pos] (:current-pos @board)]
    (condp = direction
      :right (let [ans (mapv (fn [y]
                               (:value (get-element x-pos y)))
                             (range y-pos (+ y-pos steps)))
                   [x y] (get-position (last ans))]
               (update-current-position (inc x) y)
               ans)

      :down (let [ans (mapv (fn [x]
                              (:value (get-element x y-pos)))
                            (range x-pos (+ x-pos steps)))
                  [x y] (get-position (last ans))]
              (update-current-position x (dec  y))
              ans)

      :left (let [ans (mapv (fn [y]
                              (:value (get-element x-pos y)))
                            (reverse  (range (- (inc  y-pos) steps) (inc y-pos))))
                  [x y] (get-position (last ans))]
              (update-current-position (dec x) y)
              ans)

      :up (let [ans (mapv (fn [x]
                            (:value (get-element x y-pos)))
                          (reverse (range (- (inc  x-pos) steps) (inc x-pos))))
                [x y] (get-position (last ans))]
            (update-current-position x (inc y))
            ans))))



#_(defn move-right
  [steps]
  (let [cur-pos (get-in @board [:current-pos])
        [x-pos y-pos] cur-pos
        ans (map (fn [y]
                   (:value (get-element x-pos y)))
                 (range y-pos (+ y-pos steps)))
        last-pos (get-position (last ans))
        [x y] last-pos]
    #_(println "!" cur-pos x-pos y-pos "!" last-pos x y "!")
    (swap! board assoc-in [:current-pos] [(inc x) y])
    ans))
#_(defn move-down
  [steps]
  (let [cur-pos (get-in @board [:current-pos])
        [x-pos y-pos] cur-pos
        ans (map (fn [x]
                   (:value (get-element x y-pos)))
                 (range x-pos (+ x-pos steps)))
        last-pos (get-position (last ans))
        [x y] last-pos]
    (swap! board assoc-in [:current-pos] [x (dec  y)])
    ans))


#_(defn move-left
  [steps]
  (let [cur-pos (get-in @board [:current-pos])
        [x-pos y-pos] cur-pos
        ans (map (fn [y]
                   (:value (get-element x-pos y)))
                 (reverse  (range (- (inc  y-pos) steps) (inc y-pos))))
        last-pos (get-position (last ans))
        [x y] last-pos]
    (swap! board assoc-in [:current-pos] [(dec x) y])
    ans))

#_(defn move-up
  [steps]
  (let [cur-pos (get-in @board [:current-pos])
        [x-pos y-pos] cur-pos
        ans (map (fn [x]
                   (:value (get-element x y-pos)))
                 (reverse (range (- (inc  x-pos) steps) (inc x-pos))))
        last-pos (get-position (last ans))
        [x y] last-pos]
    (swap! board assoc-in [:current-pos] [x (inc  y)])
    ans))

(defn change-direction
  [dir]
  (swap! board assoc-in [:dir] dir))

(defn create-fill-board
  [size]
  (init-board 8)
  (fill-board 8))


(defn execute-spiral
  [size]
  (mapcat (fn [x]
            (let [dir (:dir @board)
                  cur-pos (get-in @board [:current-pos])]
              (condp = dir
                :right (do
                         (change-direction :down)
                         (move-player x :right))

                :down  (do
                         (change-direction :left)
                         (move-player x :down))

                :left (do
                        (change-direction :up)
                        (move-player x :left))

                :up (do
                      (change-direction :right)
                      (move-player x :up)))))
          (change-dir-indexes size)))
