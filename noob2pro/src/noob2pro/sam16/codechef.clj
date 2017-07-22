(ns noob2pro.sam16.codechef
  (:gen-class)
  (:require [clojure.string :as String]))

;;;;;;;;;;;;;;;;;;;;; CODE CHEF PROBS
(defn inp2string [fname]
  (String/split (slurp (str  "resources/sam16/" fname)) #"\s+"))

;; Problem 1 ATM
;; https://www.codechef.com/problems/HS08TEST
(defn atm [fname]
  (let [arr (inp2string fname)
        wdamt (read-string (first arr))
        bal (read-string (second arr))]
    (if (and (zero? (mod wdamt 5)) (< wdamt bal))
      (- bal wdamt 0.50)
      bal)))

;; Problem 2 Enormous Input Test
;; https://www.codechef.com/problems/INTEST
(defn inp_test [fname]
  (let [inp (inp2string fname)
        nos (read-string (first inp))
        divby (read-string (second inp))
        arr (drop 2 inp)]
    (count (filter #(zero? (mod (read-string %) divby)) arr))))


;; Problem 3 Factorial
;; https://www.codechef.com/problems/FCTRL
(defn count_zeros [num fives count]
  (if (> fives num)
    count
    (recur num (* fives 5) (+ count (quot num fives)))))

(defn fctrl [fname]
  (let [inp (inp2string fname)
        arr (rest inp)]
    (map #(count_zeros (read-string %) 5 0) arr)))

;; Problem 4 Small Factorials
;; https://www.codechef.com/problems/FCTRL2
(defn factorial [no]
  (reduce * (range 1 (inc no))))

(defn small_fact [fname]
  (let [inp (inp2string fname)
        arr (rest inp)]
    (map #(factorial (read-string %)) arr)))

;; Problem 5 TSORT
;; https://www.codechef.com/problems/TSORT
(defn tsort [fname]
  (let [arr (rest (inp2string fname))
        nosarr (map #(read-string %) arr)]
    (sort nosarr)))

;; Problem 6 NITIKA
;; https://www.codechef.com/problems/NITIKA
(defn split_lines [fname]
  (String/split (slurp (str "resources/sam16/" fname)) #"\n"))

(defn split_spaces [str]
  (String/split str #"\s+"))

(defn cap_dot [n]
  (str (first (String/capitalize n)) ". " ))

(defn format_name [s]
  (str (apply str (map cap_dot (drop-last s))) (String/capitalize (last s))))

(defn nitika [fname]
  (let [inp (rest (split_lines fname))
        names_list (map split_spaces inp)]
    (map format_name names_list)))


;; Problem 7 Ciel and A-B Problem
;; https://www.codechef.com/problems/CIELAB
(defn cielAB [fname]
  (let [inp (inp2string fname)
        a (read-string (first inp))
        b (read-string (second inp))]
    (dec (- a b))))

;; Problem 8 CleanUp
;; https://www.codechef.com/problems/CLEANUP
(defn assignjobs [x]
  (let [line1 (split_spaces (first x))
        total (read-string (first line1))
        done (read-string (second line1))
        done_jobs (map #(read-string %) (split_spaces (second x)))
        left (remove (set done_jobs) (range 1 (inc total)))]
    (list
     (filter #(not (nil? %))
             (map-indexed (fn [idx item] (if (even? idx) item)) left))
     (filter #(not (nil? %))
             (map-indexed (fn [idx item] (if (odd? idx) item)) left)))))

(defn cleanup [fname]
  (let [inp (split_lines fname)
        count (read-string (first inp))
        arr (rest inp)]
    (mapcat #(assignjobs %) (partition 2 arr))))


;; Problem 9 Racing HORSES
;; https://www.codechef.com/problems/HORSES
(defn racing_horses [fname]
  (let [inp (inp2string fname)
        inpsets (read-string (first inp))
        count (read-string (second inp))
        arr (rest (rest inp))]
    (apply min (map (fn [a] (- (second a) (first a)))
                    (partition 2 1 (sort
                                    (map #(read-string %) arr)))))))
