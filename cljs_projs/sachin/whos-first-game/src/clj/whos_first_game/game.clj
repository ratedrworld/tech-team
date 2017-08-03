(ns whos-first-game.game)



(def board (atom {:size 8
                  :chance 0
                  :a {:current-pos [0 0]
                      :dir :right
                      :color "red"
                      :path []}

                  :b {:current-pos [7 7]
                      :dir :left
                      :color "yellow"
                      :path []}
                  :board (make-board)}))

(defn make-board
  []
  (let [size (:size @board)]
    (apply vector (for [x (range size)
                        y (range size)]
                    {:pos-x x :pos-y y :value ""}))))

(defn fill-board
  []
  (let [size (:size @board)]
    (map #(swap! board assoc-in [:board % :value] %) (range (* size size)))))

(defn create-board
  []
  (fill-board))


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



(defn update-current-position
  [x y element]
  (swap! board assoc-in [element :current-pos] [x y]))


(defn move-player
  [steps direction element]
  (let [[x-pos y-pos] (:current-pos (element @board))]
    (condp = direction
      :right (let [ans (mapv (fn [y]
                               (:value (get-element x-pos y)))
                             (range y-pos (+ y-pos steps)))
                   [x y] (get-position (last ans))]
               (update-current-position (inc x) y element)
               ans)

      :down (let [ans (mapv (fn [x]
                              (:value (get-element x y-pos)))
                            (range x-pos (+ x-pos steps)))
                  [x y] (get-position (last ans))]
              (update-current-position x (dec  y) element)
              ans)

      :left (let [ans (mapv (fn [y]
                              (:value (get-element x-pos y)))
                            (reverse  (range (- (inc  y-pos) steps) (inc y-pos))))
                  [x y] (get-position (last ans))]
              (update-current-position (dec x) y element)
              ans)

      :up (let [ans (mapv (fn [x]
                            (:value (get-element x y-pos)))
                          (reverse (range (- (inc  x-pos) steps) (inc x-pos))))
                [x y] (get-position (last ans))]
            (update-current-position x (inc y) element)
            ans))))



(defn change-direction
  [dir element]
  (swap! board assoc-in [element :dir] dir))




(defn get-path-dir
  [size]
  (reverse (drop 1
                 (drop-last (mapcat
                             (fn [x y] [x y])
                             (range 2 (+ 2 size) 2) (range 2 (+ 2 size) 2))))))



(defn execute-spiral
 [element]
  (mapcat (fn [x]
            (let [ele (element @board)
                  dir (:dir ele)
                  cur-pos (:current-pos ele)]
              #_(println ele dir cur-pos)
              (condp = dir
                :right (do
                         (change-direction :down element)
                         (move-player x :right element))

                :down  (do
                         (change-direction :left element)
                         (move-player x :down element))

                :left (do
                        (change-direction :up element)
                        (move-player x :left element))

                :up (do
                      (change-direction :right element)
                      (move-player x :up element)))))
          (get-path-dir (:size @board))))


(defn set-paths
  []
  (let [a-path (apply vector (execute-spiral :a))
        b-path (apply vector (execute-spiral :b))]
    (swap! board update-in [:a :path] into  a-path)
    (swap! board update-in [:b :path] into  b-path)))
