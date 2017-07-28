(ns memory-game.core2
  (:require [clojure.string :as string]))

(def board {0 {:val "A" :open false :done false}
            1 {:val "C" :open false :done false}
            2 {:val "G" :open false :done false}
            3 {:val "A" :open false :done false}
            4 {:val "H" :open false :done false}
            5 {:val "G" :open false :done false}
            6 {:val "C" :open false :done false}
            7 {:val "B" :open false :done false}
            8 {:val "B" :open false :done false}
            9 {:val "D" :open false :done false}
            10 {:val "E" :open false :done false}
            11 {:val "F" :open false :done false}
            12 {:val "F" :open false :done false}
            13 {:val "D" :open false :done false}
            14 {:val "H" :open false :done false}
            15 {:val "E" :open false :done false}})

(defn get-map
  "reads input from DOM"
  []
  (for [i (range 16)
        :let [prod (.-value (.getElementById js/document i))]]
    prod))

(defn check
  "check if two open are equal or not"
  [lis]
  (= (second (first lis)) (second (second lis))))

(defn splitter [x]
  (string/split x "_"))

(defn filter-list
  "removes the empty and already checked correct options"
  [lis]
  (remove #(= "T" (last %))
          (map splitter
               (remove empty? lis))))


(defn change-open
  "Switches value of :open"
  [a]
  (set! (.-value (.getElementById js/document a))
        (str a "_" (get-in board [a :val]) "_T_F"))
  (let [arr (filter-list (get-map))
        ff (first (first arr))
        sf (second (first arr))
        fs (first (second arr))
        ss (second (second arr))]
    (if (= 2 (count arr))
      (if (check arr)
        (do (set! (.-value (.getElementById js/document ff)) (str ff"_"sf"_F_T"))
            (set! (.-disabled (.getElementById js/document ff)) true)
            (set! (.-value (.getElementById js/document fs)) (str fs"_"ss"_F_T" ))
            (set! (.-disabled (.getElementById js/document fs)) true))
        (do (set! (.-value (.getElementById js/document ff)) "")
            (set! (.-value (.getElementById js/document fs)) ""))))))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn swapping
  "Gives the valid ans after swapping"
  [num]
  (let [arr (mapv read-string (string/split (str num) #""))]
    (first (remove nil? (for [i (range (dec (count arr)))
                         :let [mynum
                               (flatten
                                [(take i arr)
                                 (get arr (inc i))
                                 (get arr i)
                                 (drop (+ i 2) arr)])]]
                     (if (valid? mynum)
                       (read-string (apply str mynum))))))))

(defn valid?
  "Checks whether the number is valid or not"
  [arr]
  (if (zero? (mod (reduce + (map part-add (partition 2 (reverse arr)))) 10))
    true
    false))

(defn part-add [part]
  (if (>= (* 2 (second part)) 10)
    (+ (first part) (- (* 2 (second part)) 9))
    (+ (first part) (* 2 (second part)))))
