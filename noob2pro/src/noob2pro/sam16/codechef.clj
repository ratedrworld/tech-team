(ns noob2pro.sam16.codechef
  (:gen-class)
  (:require [clojure.string :as String]))

;;;;;;;;;;;;;;;;;;;;; CODE CHEF PROBS
(defn inp2string [fname]
  (String/split (slurp (str  "resources/sam16/" fname)) #"\s+"))

;; Problem 1 ATM
(defn atm [fname]
  (let [arr (inp2string fname)
        wdamt (read-string (first arr))
        bal (read-string (second arr))]
    (if (and (zero? (mod wdamt 5)) (< wdamt bal))
      (- bal wdamt 0.50)
      bal)))

;; Problem 2 Enormous Input Test
(defn inp_test [fname]
  (let [inp (inp2string fname)
        nos (read-string (first inp))
        divby (read-string (second inp))
        arr (drop 2 inp)]
    (count (filter #(zero? (mod (read-string %) divby)) arr))))


;; Problem 3 Factorial
(defn count_zeros [num fives count]
  (if (> fives num)
    count
    (recur num (* fives 5) (+ count (quot num fives)))))

(defn fctrl [fname]
  (let [inp (inp2string fname)
        arr (rest inp)]
    (map #(count_zeros (read-string %) 5 0) arr)))

;; Problem 4 Small Factorials
(defn factorial [no]
  (reduce * (range 1 (inc no))))

(defn small_fact [fname]
  (let [inp (inp2string fname)
        arr (rest inp)]
    (map #(factorial (read-string %)) arr)))

;; Problem 5 TSORT
(defn tsort [fname]
  (let [arr (rest (inp2string fname))
        nosarr (map #(read-string %) arr)]
    (sort nosarr)))
