(ns noob2pro.karthikeyan.core
  (:gen-class))

(defn mulsum35
  "Returns the sum of the multiples of 3 or 5 till x natural numbers"
  [x]
  (let [muls (filter #(or (= 0 (mod % 3)) (= 0 (mod % 5))) (range 1 x))]
    (reduce (fn [a b] (+ a b)) muls)))

(defn fibo
  ([] (fibo 1 1))
  ([a b] (lazy-seq (cons a (fibo b (+ a b))))))

(defn evenfibo
  "Returns the sum of all the even fibonacci terms till x"
  [x]
  (let [lst (take-while #(< % x) (fibo))
        evenlst (filter even? lst)]
    (reduce + evenlst)))

(defn prime?
  "Returns true if a number is prime otherwise false  "
  [x]
  (let [a (filter #(= 0 (mod x %)) (range 1 (inc x)))]
    (if (= 2 (count a))
      true
      false)))



(defn largestprime
  "Returns the largest prime factor of a number"
  ([x] (largestprime x 2 (Math/sqrt x)))
  ([x lprime root]
   (if (<= x root)
     (if (= x 1)
      lprime
      x)
     (if (= 0 (mod x lprime))
       (do
         (println x lprime)
         (largestprime (/ x lprime) lprime root))
       (largestprime x (inc lprime) root)))))

(defn exp [x n]
  "Returns the value of x to the power of n"
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn maxn
  "Returns the maximum product of two n-digit numbers"
  [n]
  (let [maxnum (* (dec (exp 10 n)) (dec (exp 10 n)))]
    maxnum))

(defn lown
  "Returns the lowest product of two n-digit numbers"
  [n]
  (let [lownum (* (exp 10 (dec n)) (exp 10 (dec n)) )]
    lownum))

(defn numdigits
  "Returns the list of digits in a number"
  [num]
  (loop [n num res []]
    (if (zero? n)
      res
      (recur (quot n 10) (cons (mod n 10) res)))))

(defn palindrome?
  "Returns true if a number is a palindrome"
  [a]
  (loop [b (numdigits a)]
    (if (or (= 1 (count b)) (empty? b))
      true
      (do
        (if-not (= (first b) (last b))
          false
          (recur (rest (drop-last b))))))))


(defn maxpalindrome
  [x]
  (let [a (numdigits x)]
    (if (palindrome? x)
      x
      (do
        (if-not (= (first a) (last a))
          (maxpalindrome  (conj (drop-last a) (first a)))
          (maxpalindrome (rest (drop-last a))))))))

(defn offset
  "Calculates the difference to the maximum number to form a palindrome"
  [n]
  (+ 2 (* 2 (exp 10 (dec n)))))

(defn maxpalindrome
  [x]
  (let [maxnum (maxn x)
        off (offset x)]
    (- maxnum off)))



(defn factors
  [a]
  (filter #(if (= 0 (mod a %)) true) (range 100 1000)))

(defn gcd
  [a b]
  (if (= 0 b)
    a
    (gcd b (mod a b))))

(defn lcm
  [a b]
  (/ (* a b) (gcd a b)))

(defn smallestmultiple
  [a b]
  (reduce (fn [a b] (lcm a b)) (range a (inc b))))

(defn sumofsquares
  [x]
  (reduce + (map (fn [a] (* a a)) (range 1 (inc x)))))

(defn squareofsum
  [x]
  (let [a (reduce + (range 1 (inc x)))]
    (* a a)))

(defn sumsquarediff
  [x]
  (- (sumofsquares x) (squareofsum x)))

(defn next-prime
  "Returns the next prime number after n"
  [n]
  (first (filter prime? (drop (inc n) (range)))))

(defn primegenerator
  "Returns a lazy-sequence of prime numbers"
  ([] (primegenerator 2))
  ([b]
   (lazy-seq (cons b
                   (primegenerator (next-prime b))))))



(defn splitnumbers
  [x n]
  (let [a (str x)]
    (reduce (fn [a b]
              (subs 1 n))
            a)))
