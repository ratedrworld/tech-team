(ns noob2pro.sam16.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; Prob 1 Sum of multiples of 3 & 5
(defn sumofmul [n]
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 1 n))))

;; Prob 2 Even Fibonacci No
(defn fib [n]
  (if (zero? n)
    0
    (if (= 1 n)
      1
      (+ (fib (- n 1)) (fib (- n 2))))))

(defn sumfib [n]
  (reduce + (filter #(and (<= % 4000000) (even? %)) (map #(fib %) (range 2 (+ n 2))))))

;; Prob 3
;; Old way of finding factors
#_(defn fact [n]
  ((fn [n c faclis]
     (if (> c (/ n 2))
       faclis
       (if (zero?  (mod n c))
         (recur n (inc c)  (conj faclis c))
         (recur n (inc c) faclis)
         )))
   n 1 []))

;; New Way of Finding factors
(defn factors [n]
  (filter #(zero? (mod n %)) (range 1 (inc (/ n 2)))))

(defn prime? [x]
  (if (>= x 2)
    (not  (some #(zero? (mod x %)) (range 2 (inc (/ x 2)))))))

#_(defn prime?
  ([n] (if (< n 2)
         false
         (prime? n 2)))
  ([x c] (if (> c (math/sqrt x))
           true
           (if (zero? (mod x c))
             false
             (recur x (inc c))))))

(defn largeprime [n]
  (last (filter #(prime? %) (factors n))))

;; Prob 4 Largest palindrome product

(defn palindrome? [n]
  (= (str n) (clojure.string/reverse (str n))))

(defn large_palin [size]
  (apply max (for [i (range (math/expt 10 (dec size)) (math/expt 10 size))
                   j (range (math/expt 10 (dec size)) (math/expt 10 size))
                   :let [prod (* i j)]
                   :when (palindrome? prod)]
               prod)))

;; Prob 5
(defn even_div? [no]
  (= 20
     (count (take-while #(= 0(mod no %))
                        (range 1 21)))))

(defn smallest []
  (some (fn [x] (when (even_div? x) x)) (range)))

;; Prob 6
(defn diff_sum_sqr []
  (let [arr (range 1 101)
        sumsqr (reduce + (map (fn [x] (* x x)) arr))
        sqrsum (* (reduce + arr) (reduce + arr))]
    (- sqrsum sumsqr)))

;; Prob 7
;; Old way of thinking - specific ans
#_(defn nthprime [primecount primeno count]
  (if (= 10001 primecount)
    primeno
    (if (prime? count)
      (recur (inc primecount) count (inc count))
      (recur primecount primeno (inc count)))))

;; Functional way of thinking. General ans
(defn nthprime [n]
  (last (take n (filter prime? (range)))))

;; Prob 8
(def in 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450)

(defn digits [number]
  (map #(Character/digit % 10) (str number)))

;; Direct function for decimal nos
#_(defn digits [number]
  (map #(Character/getNumericValue %) (str num)))

(defn mulall [arr]
  (apply * arr))

#_(defn highmul [ls prod]
  (if (< (count ls) 13)
    prod
    (let [curr  (mulall  (take 13 ls))]
      (if (> curr prod)
        (recur (rest ls) curr)
        (recur (rest ls) prod)))))

(defn highmul [ls no]
  (apply max (map #(apply * %) (partition no 1 ls))))

;; Prob 9
(defn pyth_trip [total]
  (first (for [a (range (/ total 2))
               b (range (/ total 2))
               :let [c (- total a b)]
               :when (=  (math/expt c 2) (+ (math/expt a 2) (math/expt b 2)))]
           (* a b c))))

;; Prob 10

;;Old method
#_(defn sumprime [primesum count]
      (if (= 2000000 count)
        primesum
        (if (prime? count)
          (recur (+ primesum count) (inc count))
          (recur primesum (inc count)))))

;; New Method
(defn sumprime [n]
  (reduce + (filter prime? (range (inc n)))))

;; Prob 11

(def  grid [[8 2 22 97 38 15 0 40 0 75 4 5 7 78 52 12 50 77 91 8]
            [49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 4 56 62 0]
            [81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 3 49 13 36 65]
            [52 70 95 23 4 60 11 42 69 24 68 56 1 32 56 71 37 2 36 91]
            [22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80]
            [24 47 32 60 99 3 45 2 44 75 33 53 78 36 84 20 35 17 12 50]
            [32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70]
            [67 26 20 68 2 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21]
            [24 55 58 5 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72]
            [21 36 23 9 75 0 76 44 20 45 35 14 0 61 33 97 34 31 33 95]
            [78 17 53 28 22 75 31 67 15 94 3 80 4 62 16 14 9 53 56 92]
            [16 39 5 42 96 35 31 47 55 58 88 24 0 17 54 24 36 29 85 57]
            [86 56 0 48 35 71 89 7 5 44 44 37 44 60 21 58 51 54 17 58]
            [19 80 81 68 5 94 47 69 28 73 92 13 86 52 17 77 4 89 55 40]
            [4 52 8 83 97 35 99 16 7 97 57 32 16 26 26 79 33 27 98 66]
            [88 36 68 87 57 62 20 72 3 46 33 67 46 55 12 32 63 93 53 69]
            [4 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36]
            [20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 4 36 16]
            [20 73 35 29 78 31 90 1 74 31 49 71 48 86 81 16 23 57 5 54]
            [1 70 54 71 83 51 54 69 16 92 33 48 61 43 52 1 89 19 67 48]])

(defn right [i j]
  (* (get-in grid [i j] 1)
     (get-in grid [i (+ 1 j)] 1)
     (get-in grid [i (+ 2  j)] 1)
     (get-in grid [i (+ 3 j)] 1)))

(defn down [i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ 1 i) j] 1)
     (get-in grid [(+ 2 i) j] 1)
     (get-in grid [(+ 3 i) j] 1)))

(defn down-right [i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ 1 i) (+ 1 j)] 1)
     (get-in grid [(+ 2 i) (+ 2  j)] 1)
     (get-in grid [(+ 3 i) (+ 3 j)] 1)))

(defn down-left [i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ 1 i) (- j 1)] 1)
     (get-in grid [(+ 2 i) (- j 2)] 1)
     (get-in grid [(+ 3 i) (- j 3)] 1)))

(defn large_prod_grid []
  (apply max (for [i (range 20)
                   j (range 20)]
               (max (right i j) (down i j) (down-right i j) (down-left i j)))))

;; Prob 12

;; Old method
#_(defn trino [n]
    ((fn [acc x]
       (if (zero? x)
         acc
         (recur (+ acc x) (dec x))))
     0 n))

;; Functional method
(defn trino [x] (reduce + (range (inc x))))

;; Old method
#_(defn maxdiv [dn]
    ((fn firsttri [n nodiv]
       (let [trinum (trino n)
             factls (fact trinum)]
         (if (<= nodiv (count factls))
           trinum
           (recur (inc n) nodiv)))) 1 dn))

(defn maxdiv [dn]
  (some #(let [num (trino %)]
           (when (<= dn (count (factors num)))
             num))
        (range)))
