(ns noob2pro.rupesh.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))




;;;;; Project Euler problems



;;;;;; problem 1 Multiples of 3 and 5

(defn mul
  [n]
  (reduce +
          (filter #(zero? (min (mod % 3)
                               (mod % 5)))
                  (range n))))

;;;;;  fibo numbers


(defn fibo
  ([]
   (fibo 1 1))
  ([a b]
   (lazy-seq (cons a (fibo b (+ a b))))))


(def a (reduce +
               (take-while #(<= % 4000000)
                           (filter even? (fibo)))))


;;;;;; Largest prime factor

(defn prime-factors [n]
  (loop [n n
         div 2
         factors []]
    (if (< n 2)
      (last factors)
      (if (= 0 (rem n div))
        (recur (/ n div)
               div
               (conj factors div))
        (recur n
               (inc div)
               factors)))))


;;;;; Largest palindrome product

(defn palin? [s]
  (if (= (str s)
         (apply str
                (reverse (str s))))
    true
    false))

(apply max
       (filter palin?
               (for
                   [a (range 100 1000)
                    b (range 100 1000)]
                 (* a b))))


;;;;; smallest multiple


(defn gcd
  [x y]
  (if (zero? y)
    x
    (recur y (mod x y))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(reduce lcm (range 1 20))


;;;; sum square difference


(defn exp [x n]
  (if (zero? n) 1
      (* x (exp x (dec n)))))


(defn sum-of-square
  [n]
  (reduce + (map #(* % %) (range 1 (inc n)))))

(defn final
  [n]
  (- (exp (reduce + (range 1 (+ n 1))) 2) (sum-of-square n)))


;;;;;; 10001st prime


(defn prime? [n]
  (if (even? n)
    false
    (let [root (num (int (Math/sqrt n)))]
      (loop [i 3]
        (if (> i root)
          true
          (if (zero? (mod n i))
            false
            (recur (+ i 2))))))))


(defn nth-prime
  [n]
  (last (take n
              (filter #(prime? %)
                      (range)))))



;;;;; Special pythagoras Triplet

(defn my-triplet
  [s]
  (first (for [a (range (/ s 2))
               b (range (/ s 2))
               :let [c (- s a b)]
               :when (= (* c c) (+ (* a a) (* b b)))]
           (* a b c))))



;;;;;; summation of primes


(defn prime? [n]
  (if (even? n)
    false
    (let [root (num (int (Math/sqrt n)))]
      (loop [i 3]
        (if (> i root)
          true
          (if (zero? (mod n i))
            false
            (recur (+ i 1))))))))


(defn sum-of-primes
  [n]
  (reduce + (conj  (filter #(prime? %)
                           (range 2 n)) 2)))


;;;;;; Highly divisible triangular number





(defn tri*
  "Generates lazy sequence of triangular numbers"
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(defn divisors
  [n]
  (filter #(= 0 (rem n %))
          (range 1 (inc n))))


(defn triangular?
  [n]
  (= n (last (take-while #(>= n %) tri))) n)


(defn div-tri-num
  []
  (loop [sum 0
         num 1]
    (if (> (count (divisors (triangular? sum))) 50)
      sum
      (recur (+ sum
                num) (inc num)))))
