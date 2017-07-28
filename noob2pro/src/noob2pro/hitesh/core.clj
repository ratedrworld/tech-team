(ns noob2pro.hitesh.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;FIRST
;; This funtion calculates the sum of nos which
;; are multiples of 3 and 5 under 'n'

(defn sum-of-multiples [n]
  (reduce + (filter  (fn [x]
                     (or (zero? (mod x 3))
                         (zero? (mod x 5))))
                   (range n))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;SECOND
;;Finding the sum of even valued nos in a fibonacci
;;sequence under 4 million.

(defn number-to-fibonacci
  "This function maps a number to its fibonacci value"
  [a]
  (if (= 0 a)
    0
    (if (= 1 a)
      1
      (+ (number-to-fibonacci (- a 1))
         (number-to-fibonacci (- a 2))))))

(defn sum-calculator
  "This function returns the answer"
  [n]
  (reduce + (filter
             #(even? %)
             (take-while #(< % 4000000)
                         (map number-to-fibonacci
                              (range 1 (inc n)))))))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;THIRD
;;Finding the largest prime factor of a no

(defn isprime? [a]
  (if (> (count (filter #(zero? (mod a %)) (range 2 a))) 0)
    false
    true))

(defn filter-prime [arr]
  (filter #(isprime? %) arr))

(defn prime-generator [n]
  (filter-prime (filter
                 (fn [x] (zero? (mod n x)))
                 (range 2 (inc (/ n 2))))))


(defn largest-prime-factor [n]
  (last (prime-generator n)))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;FOURTH
;;Finds the biggest prime no which is a multiple of two 3-digits numbers

(defn ispalindrome? [n]
  (= (str n) (clojure.string/reverse (str n))))

(defn large_palin [size]
  (apply max
         (for [i (range (math/expt 10 (dec size)) (math/expt 10 size))
               j (range (math/expt 10 (dec size)) (math/expt 10 size))
               :let [prod (* i j)]
               :when (ispalindrome? prod)]
           prod)))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;FIFTH
;;Smallest no evenly divisible by 1-20

(defn is-divisible? [no]
  (= 20 (count (take-while #(zero? (mod no %)) (range 1 21)))))


(defn smallest-divisible []
  (some #(when (is-divisible? %) %) (range)))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;SIXTH
;;Calculates the difference of square of sum and sum of squares of an array

(defn diff-of-values []
  (let [num-square (reduce +
                           (map (fn [x] (* x x))
                                (range 1 101)))
        square-num (reduce +
                           (range 1 101))]
    (- (* square-num square-num) num-square)))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;SEVENTH
;;Calculates the given prime no

(defn find-prime [no]
  (last (take no (filter #(isprime? %) (drop 2 (range))))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;EIGHT
;;Find the highest product of 13 digits in a 1000 digit no.

(def numb 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450)




(defn convert-to-list [numb]
  (map #(Character/getNumericValue %) (str numb)))

(defn check-highest
  "Compares the old and new product"
  [mylist step]
  (apply max (map #(reduce * %)
                  (partition step 1 mylist))))





;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;NINTH
;;Finds the product of pythogorean triplet
;;let is used to check the given conditions

(defn find-product []
  (take 1
        (for[a (range 1000)
             b (range 1000)
             c (range 1000)
             :let [x (+ (* a a) (* b b))
                   z (+ a b c)]
             :when (and (= x (* c c))
                        (= 1000 z))]
          (* a b c))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;TENTH
;;Finds sum of all primes under 2 million.

(defn sum-of-primes [no]
  (reduce + (filter #(isprime? 2 %) (range 1 (inc no)))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;ELEVENTH
;;Finds the highest product in given array


(def arr [[8 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 8]
          [49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00]
          [81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65]
          [52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91]
          [22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80]
          [24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50]
          [32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70]
          [67 26 20 68 02 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21]
          [24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72]
          [21 36 23 9 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95]
          [78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 9 53 56 92]
          [16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57]
          [86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58]
          [19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40]
          [04 52 8 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66]
          [88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69]
          [04 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36]
          [20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16]
          [20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54]
          [01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48]])


(defn right
  "This function calculates the product of right values"
  [i j arr]
  (* (get-in arr [i j ] 1)
     (get-in arr [i (+ 1 j)] 1)
     (get-in arr [i (+ 2 j)] 1)
     (get-in arr [i (+ 3 j)] 1)))

(defn down
  "This function calculates the product of down values"
  [i j arr]
  (* (get-in arr [i j] 1)
     (get-in arr [(+ 1 i) j] 1)
     (get-in arr [(+ 2 i) j] 1)
     (get-in arr [(+ 3 i) j] 1)))

(defn bottom-right
  "This function calculates the product of right diagonal"
  [i j arr]
  (* (get-in arr [i j] 1)
     (get-in arr [(+ 1 i) (+ 1 j)] 1)
     (get-in arr [(+ 2 i) (+ 2 j)] 1)
     (get-in arr [(+ 3 i) (+ 3 j)] 1)))

(defn bottom-left
  "This function calculates the product of left diagonal"
  [i j arr]
   (* (get-in arr [i j] 1)
      (get-in arr [(+ i 1) (- j 1)] 1)
      (get-in arr [(+ i 2) (- j 2)] 1)
      (get-in arr [(+ i 3) (- j 3)] 1)))

(defn greatest-product
  "This function is for finding the greatest product"
  [arr]
  (apply max (for [i (range 1 20)
                   j (range 1 20)
                   :let [prod (max (right i j arr) (down i j arr) (bottom-right i j arr) (bottom-left i j arr))]]
               prod)))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;TWELVETH
;;triangular no to have n divisors

(def arr
  "This is a list of triangular nos"
  (map #(reduce + (range 1 (inc %)))
       (range 1 201)))

(defn tri?
  "Checks with a num is triangular or not"
  [arr no]
  (some #(= no %) arr))

(defn factors
  "Calculate the factors of a number"
  [num]
  (filter
   (fn [x] (zero? (mod num x)))
   (range 2 (inc (/ num 2)))))

(defn find-number
  "Finds number with n divisors"
  [n]
  (some #(when
             (and
              (tri? arr %)
              (= n (count (factors %))))
           %)
        (drop 2 (range))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;CODECHEF PROBLEMS

;;First Prob
;;https://www.codechef.com/problems/HS08TEST


(defn input-file
  "takes the file name and slurp"
  [file]
  (slurp (str "resources/" file) ))


(defn withdraw
  "Accepts the amount to withdraw and balance"
  [file]
  (let [amount (read-string (first (str/split (input-file file) #" ")))
        balance (read-string (second (str/split (input-file file) #" ")))]
    (if (and
         (zero? (mod amount 5))
         (< amount balance))
      (- balance amount 0.50)
      balance)))

;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/INTEST

(defn divisible
  "Accepts no and a divisor and returns count of divisible nos"
  [file]
  (let [arr (drop 2 (str/split (input-file file) #"\n" ))
        counter (read-string (first (str/split (input-file file) #"\n" )))
        divisor (read-string (second (str/split (input-file file) #"\n" )))]
    (count (filter #(zero? (mod (read-string %) divisor)) arr))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/FCTRL

(defn factorial [arr]
  (map #(reduce *' (range 1 (inc (read-string %)))) arr))


(defn count-zero
  "Counts the no of zeros in tail"
  [file]
  (let [arr (rest (str/split (input-file file) #"\n"))
        fact-arr (factorial arr)]
    (map #(count (last (re-seq #"[0]+" (str %))))
         fact-arr)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/FCTRL2

(defn small-fact
  "Returns the factorial of all the elemnts"
  [file]
  (let [arr (str/split (input-file file) #"\n")]
    (factorial arr)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/TSORT

(defn turbo
  "Returns a set of ascending nos"
  [file]
  (let [arr (str/split (input-file file) #"\n")]
    (sort (into #{} arr))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/TLG

(defn winner
  "Checks the lead and decides who is the winner"
  [file]
  (let [arr (rest (str/split (input-file file) #"\n"))
        leads (map #(-
                     (read-string (first (str/split % #" ")))
                     (read-string (second (str/split % #" ")))) arr)
        posi (apply max (filter #(pos? %) leads))
        neg (apply min (filter #(neg? %) leads))]
    (if (< posi (- neg))
      (str "Winner is 2 with lead " neg)
      (str "Winner is 1 with lead " posi))))

;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/TWONMS

(defn getprod [a b c]
  (if (= 0 c)
    (quot (max a b) (min a b))
    (if (= (dec c) 0)
      (recur (* a 2) b (dec c))
      (recur (* a 2) (* b 2) (- c 2)))))

(defn mult
  "Multiplies the element of array by 2 based on count"
  [arr ans]
  (if (empty? arr)
    ans
    (let [alice (read-string (first (str/split (first arr) #" ")))
          bob (read-string (second (str/split (first arr) #" ")))
          counter (read-string (last (str/split (first arr) #" ")))]
      (recur (rest arr) (conj ans (getprod alice bob counter))))))

(defn two-nos
  "Based on Codechef Problem TWO NUMBERS"
  [file]
  (let [arr (rest (str/split (input-file file) #"\n+"))]
    (mult arr [])))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/CIELAB

(defn cielab
  "Based on Codechef problem Ciel and his Restaurant"
  [file]
  (let [arr (str/split (input-file file) #" ")
        ans (- (read-string (first arr)) (read-string (second arr)))]
    (dec ans)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/CLEANUP

(defn assign-job [arr chef asst]
  (if (empty? (rest arr))
    (cons  (conj chef (first arr)) asst)
    (recur (drop 2 arr) (conj chef (first arr)) (conj asst (second arr)))))

(defn cleanup
  "Based on Codechef prob Cleanup"
  [file]
  (let [jobs (range (read-string (first (str/split (input-file file) #" "))))
        done (str/split (second (str/split (input-file file) #"\n")) #" ")
        rem (clojure.set/difference (set jobs) (set (map #(read-string %) done)))]
    (assign-job (into [] rem) [] [])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;https://www.codechef.com/problems/HORSES

(defn horse
  "Based on Codechef problem Racing horses"
  [file]
  (let [arr (sort (map #(read-string %) (str/split (input-file file) #"\s+")))]
    (apply min
           (filter #(pos? %)
                   (map
                    #(- (second %) (first %))
                    (partition 2 1 arr))))))


;;;;;;;;;;;;;;;;;;;;;;;;LUHN ALGORITHM

(defn take-input [filename]
  (slurp (str "resources/" filename)))


(defn part-add [part]
  (if (>= (* 2 (second part)) 10)
    (+ (first part) (- (* 2 (second part)) 9))
    (+ (first part) (* 2 (second part)))))


(defn part? [no]
  (zero? (mod no 10)))


(defn check? [stri]
  (part?  (reduce +
                  (map part-add
                       (partition 2
                                  (map read-string
                                       (clojure.string/split (string/reverse stri)
                                                             #"")))))))
(defn check-sum [arr]
  (if (clojure.string/includes? arr "?")
    (some #(when (check? %) %) (for [i (range 10)]
                                 (clojure.string/replace arr
                                                         #"\?"
                                                         (str i))))))



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
  (if (zero? (mod (reduce +
                          (map part-add
                               (partition 2 (reverse arr)))) 10))
    true
    false))
