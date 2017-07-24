(ns noob2pro.sachin.game_of_life)

(defn demo
  []
  [[1 1 0 1 0] [1 0 0 0 0] [1 1 1 0 1] [1 0 0 1 0] [1 1 0 0 0]])

(defn create_board
  "Creates a board of size n with random initialization of 0 & 1"
  [size]
  (mapv
   (fn [x]
     (mapv (fn [y] (rand-int 2)) (range size)))
   (range size)))

(defn get_alive_neigh
  "Returns the number of alive neighbours"
  [board i j]
  (+ (get-in board [(dec i) (inc j)] 0)
     (get-in board [i (inc j)] 0)
     (get-in board [(inc i) (inc j)] 0)
     (get-in board [(dec i) j] 0)
     (get-in board [(inc i) j] 0)
     (get-in board [(dec i) (dec j)] 0)
     (get-in board [i (dec j)] 0)
     (get-in board [(inc i) (dec j)] 0)
     ))

(defn check_rules
  "Returns the appropriate value by applying ruleson the count"
  [count]
  (if (or (= count 2) (= count 3))
    1
    0))

;;USING FOR
#_(defn game_of_life
  "Accepts board, traverses the board applying the rules and returns the updated board"
  [board size]
  (vec (for [i (range size)]
         (vec (for [j (range size)
                    :let [alive (get_alive_neigh board i j)]]
                (check_rules alive))))))
;;USING MAP
(defn game_of_life
  [board size]
  (mapv
   (fn [i]
     (mapv (fn [j]
             (check_rules (get_alive_neigh board i j)))
           (range size)))
   (range size)))


(defn gol_main_test
  "Runs the game of life for n number of times"
  [size n]
  (loop [board (demo)
         i 1]
    (if (> i n)
      board
      (recur (game_of_life board size) (inc i)))))

(defn gol_main
  "Runs the game of life for n number of times"
  [size n]
  (loop [board (create_board size)
         i 1]
    (if (> i n)
      board
      (recur (game_of_life board size) (inc i)))))
