(ns noob2pro.bhavesh.core
  (:require [clojure.java.io :refer :all]
            [clojure.string :as str]))


;;problem 1
;;sum of all multiples of x and y below n

(defn sum-multiples
  [x y n]
  (reduce +
          (filter ;;condition for multiples of x and y
           #(or (zero? (rem % x))
                (zero? (rem % y)))
           (range 1 n))))


;;problem 2
;;sum of even-valued terms in fibonacci sequence upto 4 million

(defn lazy-fib
  "generates a lazy sequence of fibonacci numbers"
  ([]
   (lazy-fib 1 2))
  ([a b]
   (lazy-seq (cons a
                   (lazy-fib b (+ a b))))))

(defn fib-sum
  "returns the sum of even-valued tersm in fibonacci sequence upto limit"
  [limit]
  (reduce +
          (filter #(even? %)
                  (take-while #(< % limit) (lazy-fib)))))



;;problem 3 largest prime factor second try
(defn larg-prime-factor
  ([num]
   (larg-prime-factor num 2 (Math/sqrt num)))
  ([num n sqr-root]
   (if  (<= num sqr-root)
     (if (= num 1)
       n

       num)
     (if (= 0 (mod num n))
       (larg-prime-factor (/ num n) n sqr-root)
       (larg-prime-factor num (inc n) sqr-root)))))


;;problem 4
;;largest palindrome by multiplication of two 3 digit numbers

(defn palin?
  "returns true if a number is a palindrome, false otherwise"
  [num]
  (= (str num)
     (clojure.string/reverse (str num))))



(defn prob3
  "returns the largers palindrome formed by multiplication of two 3 digit numbers."
  []
  (apply max (for [i (range 100 1000)
                   j (range 100 1000)
                   :let [mult (* i j)]
                   :when (palin? mult)]
               mult)))





;;problem 5
(defn gcd
  [a b]
  (if (= 0 b)
    a
    (if (= 0 a)
      b
      (gcd b (mod a b)))))


(defn lcm
  [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-arr
  [arr]
  (reduce lcm arr))

(lcm-arr (range 1 21))

;;problem 6
(defn sum-square
  []
  (let [sum-square (reduce + (map #(* % %) (range 1 101)))
        sum (reduce + (range 1 101))]
    (- (* sum sum) sum-square)))

;;problem 7
(defn isprime?
  [n]
  (if (or (= n 0) (= n 1))
    true
    (some #(= 0 (mod n %)) (range 2 (/ n 2)))))


(defn nth-prime
  [n]
  (last (take (+ n 1) (filter #(not (isprime? %)) (range)))))


;;problem 8, 13 adjacent digits having largest sum


(defn num-to-list
  "Converts a number to list of it's digits"
  [num]
  (map (fn [^Character c] (Character/digit c 10)) (str num)))

(defn prob8
  "Returns the largest product of n adjacent digits in a given number"
  [n num]
  (let [num-list (num-to-list num)]
    (apply max (map #(reduce *
                             (take n (drop % num-list))) (range 0 (- (count num-list) n))))))



;;problem 9, pythagorean triplets whose sum is 10000
(defn pyth
  "Returns product of pythagoream triplets with given sum"
  [sum]
  (first (for [a (range 1 (/ sum 2))
               b (range (inc a) (/ sum 2))
               :let [c (- sum a b)]
               :when (= (* c c)
                        (+ (* a a) (* b b)))]
           (* a b c))))




;;problem 10, sum of prime numbers less than 2 million




(defn sum-of-primes
  [limit]
  (reduce +
          (conj (remove isprime?
                        (range 3 limit))
                2)))



;;problem 11, largest product of 4 numbers in a grid

(def grid (list 8 2 22 97 38 15 00 40 00 75 4 5 7 78 52 12 50 77 91 8 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 4 56 62 00 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 3 49 13 36 65 52 70 95 23 4 60 11 42 69 24 68 56 01 32 56 71 37 2 36 91 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 24 47 32 60 99 3 45 2 44 75 33 53 78 36 84 20 35 17 12 50 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 67 26 20 68 2 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21 24 55 58 5 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 21 36 23 9 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 78 17 53 28 22 75 31 67 15 94 3 80 4 62 16 14 9 53 56 92 16 39 5 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 86 56 00 48 35 71 89 7 5 44 44 37 44 60 21 58 51 54 17 58 19 80 81 68 5 94 47 69 28 73 92 13 86 52 17 77 4 89 55 40 4 52 8 83 97 35 99 16 7 97 57 32 16 26 26 79 33 27 98 66 88 36 68 87 57 62 20 72 3 46 33 67 46 55 12 32 63 93 53 69 4 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 4 36 16 20 73 35 29 78 31 90 1 74 31 49 71 48 86 81 16 23 57 5 54 1 70 54 71 83 51 54 69 16 92 33 48 61 43 52 1 89 19 67 48))


(defn right-sum
  [arr]
  (apply max (map #(reduce *
                           (take 4 (drop % arr)))
                  (range 0 (- (count arr) 4)))))


(defn down-sum
  "returns max product of 4 neighbours in down direction"
  [arr size]
  (apply max (map #(* (first (drop % arr))
                      (first (drop (+ % size) arr))
                      (first (drop (+ % (* 2 size)) arr))
                      (first (drop (+ % (* 3 size)) arr)))
                  (range 0 (* (- size 3) size)))))

(defn diag-index
  "Returns index to be used to calculate diagnal products"
  [arr size]
  (filter #(> 17 (rem % size)) (range 0 (* (- size 3) size))))

(defn rev-diag-index
  "Returns index to be used to calculate reverse diagnol products"
  [arr size]
  (filter #(< 2 (rem % size)) (range 0 (* (- size 3) size))))


(defn diag-sum
  "Returns max product of 4 diagnol elements"
  [arr size]
  (apply max (map #(* (first (drop % arr))
                      (first (drop (+ % 1 size) arr))
                      (first (drop (+ % 2 (* 2 size)) arr))
                      (first (drop (+ % 3 (* 3 size)) arr)))
                  (diag-index arr size))))


(defn rev-diag-sum
  "Returns max product of 4 reverse-diagnol elements"
  [arr size]
  (apply max (map #(* (first (drop % arr))
                      (first (drop (+ % (- size 1)) arr))
                      (first (drop (+ % (- (* 2 size) 2)) arr))
                      (first (drop (+ % (- (* 3 size) 3)) arr)))
                  (rev-diag-index arr size))))


(defn prob11
  "Returns max product of 4 consecutive digits in any direction"
  [arr size]
  (max (right-sum arr) (down-sum arr size) (diag-sum arr size) (rev-diag-sum arr size)))




;; problem 12 , first traingular number to have over 500 divisors.


(defn lazy-triag
  "returns a lazy sequence of trainglular numbers"
  ([] (lazy-triag 1 2))
  ([a b]
   (lazy-seq (cons a (lazy-triag (+ a b) (inc b))))))

(defn n-divisors
  "returns the number of divisors of a number"
  [num]
  (conj (filter #(= 0 (rem num %)) (range 1 (inc (/ num 2)))) num))


(defn prob12
  "returns the first triangular no. with 500 divisors"
  []
  (first (drop-while
         #(< (count (n-divisors %)) 100)
         (lazy-triag))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; codechef problems start herer

;;problem 1 , ATM

(defn take-ip
  "Reads space separated strings from file, returns a list of corresponding number"
  [fname]
  (let [content (slurp (str "resources/" fname))
        input (str/split content #"[\s]")]
    (map #(Integer/parseInt %) input)))


(defn atm
  "Reads input from given file name, input has two parts
  1. Withdrawal amount
  2. Initial account balance
  Returns the account balance after attempted transaction."
  [fname]
  (let [input (take-ip "problem1")
        withdraw (first input)
        balance (second input)]
    (if (not= 0 (rem withdraw 5)) ;; withdrawal amount should be a multiple of 5
      balance
      (if (> withdraw balance)
        balance
        ;;0.5 is the transaction fees which gets subracted from balance
        (- balance withdraw 0.5)))))


;; problem 2; function returns the number of intergers divisible by the given number in input.


(defn inputs-div-k
  "The input begins with two positive integers n k The next n lines of input contain one positive integer each.
  Function returns the number of integers divisible by k"
  [fname]
  (let [input (take-ip "problem2")
        k (second input)]
    (count (filter
            #(= 0 (rem % k))
            (drop 2 input)))))


;;;;;; problem 3

#_(defn fact
  "Returns factorial of a number"
  [num]
  (reduce * (range 1 (inc num))))


(defn n-zero
  "Returns number of trailing zero's in the factorial of a number by counting number of 5's and 2's in the factors of the number"
  ([num] (n-zero num 0 5))
  ([num  zeros power-5]
   (let [q (quot num power-5)]
     (if (>= q 1)
       (n-zero num (+ zeros q) (* 5 power-5))
       zeros))))


(defn prob3-cc
  "Returns number of zeros in the factorial of each number from the input file."
  []
  (let [input (take-ip "problem3")]
    (map n-zero input)))



;;;;;;;;;;4clojure problems



(defn my-interpose
  [arr]
  (drop-last (mapcat #(list %1 0) arr)))


(defn drop-nth
  "Drops every nth element from the list"
  ([arr n] (drop-nth arr n [] ))
  ([arr n result]
   (if (empty? arr)
     result
     (drop-nth (drop n arr) n (concat result (take (- n 1) arr))))))
