(ns memory-game.core
  (:require [clojure.string :as string]))

(def board (atom {0 {:val "A" :open false :done false}
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
                  15 {:val "E" :open false :done false}}))

(defn get-map
  "reads input from DOM"
  []
  (filter #(and (= true (get-in @board [% :open]))
                (= false (get-in @board [% :done])))
          (range 16)))

(defn check
  "check if two open are equal or not"
  [a b]
  (= (get-in @board [a :val]) (get-in @board [b :val])))

(defn disable [id]
  (set! (.-disabled (.getElementById js/document id)) true))

(defn board-set [id val]
  (set! (.-value (.getElementById js/document id)) val))

(defn board-assoc [id k val]
  (swap! board assoc-in [id k] val))

(defn close-cards
  "Close the unmatched cards"
  [fi si]
  (board-set fi "")
  (board-set si "")
  (board-assoc fi :open false)
  (board-assoc si :open false))


(defn change-open
  "Switches value of :open"
  [a]
  (board-set a (get-in @board [a :val]))
  (board-assoc a :open true)
  (let [arr (get-map)
        fi (first arr)
        si (second arr)]
    (if (= 2 (count arr))
      (if (check fi si)
        (do (disable fi)
            (disable si)
            (board-assoc fi :open false)
            (board-assoc si :open false)
            (board-assoc fi :done true)
            (board-assoc si :done true))
        (.setTimeout js/window (fn [] (close-cards fi si)) (* 1 1000)))))
  (when (= 16 (count (filter #(= true (get-in @board [% :done])) (range 16))))
    (js/alert "GAME SAMAPT KRIPIYA FIR SE SHURU KARE")
    (.reload js/location true)))
