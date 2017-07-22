(ns noob2pro.radhakrishna.core
  (:require  [clojure.math.numeric-tower :as math]
		[clojure.string :as str]))

;; problem 1

(defn mod-3-5 [no] (or (= 0 (mod no 3))
                       (= 0  (mod no 5))))

(defn mult-3-5 [no] (reduce +
                            (filter mod-3-5
                                    (range 1
                                           no))))

;;;;;;;;;;;;;;;;
;;;; rewriting problem 1

;;here there is a great scope of improvement
(defn mod-no [no limit]
  (filter #(zero? (mod % no)) (range 1 (inc limit))))





;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; problem 2

(defn fibo [x]
  (if (= x 0)
    1
    (if (= x 1)
      1
      (+ (fibo (dec x))
         (fibo (- x 2))))))

(defn sum-even-fibo [no]
  (reduce +
          (filter even?
                  (map fibo
                       (range 1
                              (inc no))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;modified and correct code


(defn fibo [x]
  (if (= x 0)
    1
    (if (= x 1)
      1
      (+ (fibo (dec x))
         (fibo (- x 2))))))

(defn sum-even-fibo [no]
  (reduce +
          (filter even?
                  (take-while #(< % 4000000)
                              (map fibo
                                   (range 1
                                          (inc no)))))))


;; problem 3
;;not giving answer for very big number
(defn get-factors [no arr]
  (filter #(zero? (mod no %)) arr))

(defn prime? [no]
  (zero? (count (get-factors no
                       (range 2
                              (math/sqrt no))))))

(defn prime-factors [no]
  (filter prime?
          (get-factors no
                       (range 2
                              (/ no 2)))))
;(/ no 2)

(defn largest-prime-factor [no]
  (last (prime-factors no)))


;;;;;;;;;;;;;;;;;;;
;;;;better code


(defn prime1? [no]
  (zero? (count (filter #(zero? (mod no %))
                        (range 2
                               (math/sqrt no))))))

(defn prime-factors1 [no]
  (filter prime1?
          (filter #(zero? (mod no %))
                  (range 2
                         (/ no 2)))))

(defn largest-prime-factor1 [no]
  (last (prime-factors1 no)))


;; problem 4

#_ (so lets see how to do
      what i thinking was double loop java way but there is a function which i will start with and i will send  )

(defn palindrome? [no]
  (= (str no)
     (apply str
            (reverse (str no)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; modified problem 4

(defn palindrome1? [no]
  (let [stri (str no)]
    (= stri (apply str (reverse stri)))))

(defn large_palin [size]
  (apply max
         (for [i (range (math/expt 10
                                   (dec size))
                        (math/expt 10 size))
               j (range (math/expt 10
                                   (dec size))
                        (math/expt 10 size))
               :let [prod (* i j)]
               :when (palindrome1? prod)]
           prod)))

;; problem 5

#_ (in this i need a number which will return true or false if it is divisible by all the numbers from 1 to 20 )

(defn evenly-divisible? [no]
  (= 20
     (count (take-while #(= 0
                        (mod no %))
                    (range 1 21)))))

(defn check [x]
  (if (evenly-divisible? x)
    x
    (recur (inc x))))
;;;;;;;;;;;;;;;;;;;;;;;
;;;;modified code

;;use some instead of recursion


(defn evenly-divisible? [no limit]
  (= limit
     (count (take-while #(= 0
                            (mod no %))
                        (range 1 (inc limit))))))

(defn check [no]
  (some #(when (evenly-divisible? % no) %) (rest (range))))

;; problem 6

;;;; no changes needed its good optimized code

(defn sum-of-square [no]
  (reduce +
          (map #(* % %)
               (range 1 (inc no)))))

(defn square-of-sum [no]
  (let [sum (reduce + (range 1
                             (inc no)))]
    (* sum sum)))


(defn diff [no]
  (- (square-of-sum no)
     (sum-of-square no)))

;; probelm 7

#_ (here i need a function which returns a list of prime numbers once this happens i need to pass a list upto 10001 and its done)

(defn isprime? [ar]
  ((fn [b a]
     (if (> b (math/sqrt a))
       true
       (if (zero? (mod a b))
         false
         (recur (inc b) a))))
   2 ar))

(defn prime-at-pos [cp pn cnt pos]
  ;(println cnt pn)
  (if (= pos cp)
    pn
    (if (isprime? cnt)
      (recur (inc cp)
             cnt
             (inc cnt)
             pos)
      (recur cp
             pn
             (inc cnt)
             pos))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; modified solution

(defn my-prime? [no]
  (if (or  (= no 1)
           (= no 0))
    false
    (not (some #(zero? (mod no %))
               (drop 2 (range no))))))

(defn prime-at-pos1 [pos]
  (last (take pos
              (filter my-prime?
                      (range)))))

;; problem 8
(def no  7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450)

(defn digits [number] (map #(Character/digit % 10) (str number)))

;(digits no)

(defn great-prod [prod lis modd]
  (if (< (count lis) modd)
    prod
    (let [new-prod (reduce *
                           (take modd lis)) ] (if (> new-prod
                                                  prod)
                                             (recur new-prod (rest lis) modd)
                                             (recur prod (rest lis) modd)))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;modified solution

(defn great-prod1 [lis modd]
  (apply max (map #(reduce * %)
            (partition modd 1 lis))))



;; problem 10

(defn sum-prime [sum pn no]
  (if (> pn no)
    sum
    (if (isprime? pn)
      (recur (+ sum pn) (inc pn) no)
      (recur sum (inc pn) no))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; modified solution

(defn sum-prime1 [limit]
  (reduce +
          (take limit
                (filter prime?
                        (range)))))

;; problem 12

(defn get-tri [no]
  (reduce + (range 1 (inc no))))

(defn get-factors1 [no]
  (filter #(zero? (mod no %)) (rest (range (inc  no)))))

(defn get-factors-count [no]
  (count (get-factors1 no)))

(defn factor-of-triangle [no]
  (get-factors-count (get-tri no)))

(defn give-triangle-number [no]
  (some #(when (<= no
                   (factor-of-triangle %))
           (get-tri %)) (range)))

;; problem 9

(defn pytho-triplet [a b]
  (math/sqrt (+ (* a a) (* b b))))

(defn prod-pytho-triplet [no]
  (first  (for [a (range 1 no)
                 b (range 1 no)
                 :let [c (pytho-triplet a b)]
                 :when (= no (+ a b c))]
             (* a b c))))

;; problem 11

(def grid-20x20 [[8 2 22 97 38 15 0 40 0 75 4 5 7 78 52 12 50 77 91 8]
                 [49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 4 56 62 0]
                 [81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 3 49 13 36 65]
                 [52 70 95 23 4 60 11 42 69 24 68 56 1 32 56 71 37 2 36 91]
                 [22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80]
                 [24 47 32 60 99 03 45 2 44 75 33 53 78 36 84 20 35 17 12 50]
                 [32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70]
                 [67 26 20 68 2 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21]
                 [24 55 58 5 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72]
                 [21 36 23 9 75 0 76 44 20 45 35 14 0 61 33 97 34 31 33 95]
                 [78 17 53 28 22 75 31 67 15 94 3 80 04 62 16 14 9 53 56 92]
                 [16 39 5 42 96 35 31 47 55 58 88 24 0 17 54 24 36 29 85 57]
                 [86 56 0 48 35 71 89 7 5 44 44 37 44 60 21 58 51 54 17 58]
                 [19 80 81 68 5 94 47 69 28 73 92 13 86 52 17 77 4 89 55 40]
                 [4 52 8 83 97 35 99 16 7 97 57 32 16 26 26 79 33 27 98 66]
                 [88 36 68 87 57 62 20 72 3 46 33 67 46 55 12 32 63 93 53 69]
                 [4 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36]
                 [20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 4 36 16]
                 [20 73 35 29 78 31 90 1 74 31 49 71 48 86 81 16 23 57 5 54]
                 [1 70 54 71 83 51 54 69 16 92 33 48 61 43 52 1 89 19 67 48]])

(defn mult-right [grid i j]
  (* (get-in grid [i j] 1)
     (get-in grid [i (+ j 1)] 1)
     (get-in grid [i (+ j 2)] 1)
     (get-in grid [i (+ j 3)] 1)))

(defn mult-down [grid i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ i 1) j] 1)
     (get-in grid [(+ i 2) j] 1)
     (get-in grid [(+ i 3) j] 1)))

(defn mult-down-right [grid i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ i 1) (+ j 1)] 1)
     (get-in grid [(+ i 2) (+ j 2)] 1)
     (get-in grid [(+ i 3) (+ j 3)] 1)))

(defn mult-down-left [grid i j]
  (* (get-in grid [i j] 1)
     (get-in grid [(+ i 1) (- j 1)] 1)
     (get-in grid [(+ i 2) (- j 2)] 1)
     (get-in grid [(+ i 3) (- j 3)] 1)))

(defn max-prod [grid no]
  (apply max (for [i (range no)
         j (range no)]
     (max (mult-right grid i j)
          (mult-down grid i j)
          (mult-down-right grid i j)
          (mult-down-left grid i j)))))

#_(defn my-fn [& args])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;codechef

;;atm problem

(defn correct-trans [amt bal]
  (and  (zero? (mod amt 5))
        (not (neg? (- bal amt 0.5)))))

(defn ret-bal [filename]
  (let [inp (str/split  (slurp (str filename))
                    #" ")
        amt (first inp)
        bal (second inp)]
    (if (correct-trans amt bal)
      (- bal amt 0.5)
      bal)
    ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;codechef problem

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;prob atm

;;https://www.codechef.com/problems/FIRE

(defn correct-trans [amt bal]
  (and  (zero? (mod amt 5))
        (not (neg? (- bal amt 0.5)))))

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(defn take-ip1 [filename]
  (ret-bal (slurp filename)))

(defn ret-bal [strin]
  (let [inp (str/split (strin)
                        #" ")
        amt (parse-int (first inp))
        bal (parse-int (second inp))]
    (if (correct-trans amt bal)
      (- bal amt 0.5)
      bal)))

;;;;;; prob 2 enormous ip test

;;;;;;https://www.codechef.com/problems/INTEST


(defn take-ip2 [filename]
  (enormous (slurp filename)))

(defn enormous [filename]
  (let [inp  (str/split (take-ip filename)
                        #" ")
        fir (read-string (first inp))
        sec-vec (str/split (second inp)
                           #"\n")
        sec (read-string (first sec-vec))
        third-vec (rest sec-vec)]
    (count (filter #(zero? (mod (read-string %)
                                sec))
                   third-vec))))

;;;;prob 3 factorial

;;https://www.codechef.com/problems/FCTRL

(defn no-of-zeros [no]
  (count (last (re-seq #"[0]+" (str no)))))

(defn fact [no]
  (reduce *' (range 1 (inc no))))

(defn fact-count-0 [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        sec-vec (map read-string (rest inp))]
    (map no-of-zeros
         (map fact
              sec-vec))))

;;;;;;;;;;;;;;;;
;;;;;; prob get lead

;;https://www.codechef.com/problems/TLG

(defn give-sub [arr]
  (- (read-string (first arr))
     (read-string (second arr))))

(defn lead [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        fir (read-string (first inp))
        sec-vec (map #(str/split % #" ")
                     (rest inp))
        third-vec (map give-sub sec-vec)
        posi (filter pos? third-vec)
        negi (map - (filter neg? third-vec))]
    (if (> (apply max posi) (apply max negi))
      (println 1 (apply max posi))
      (println 2 (apply max negi)))))

;;;;;;;;;;;;;;;;;;;;

;;;;;;prob first and last

;;https://www.codechef.com/problems/FLOW001

(defn sfl [stri]
  (let [inp (map #(- % 48) (map int (vec stri)))
        fir (first inp)
        sec (last inp)]
    (+ fir sec)))

(defn fal [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        sec-vec (rest inp)]
    (map sfl sec-vec)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;; whats the name

;;https://www.codechef.com/problems/NITIKA

(defn first-dot [arr]
  (let [cap-arr (map str/capitalize arr)
        arr-drop (drop-last cap-arr)]
    (str (apply str (map #(str (first %) ". ") arr-drop))
         (last cap-arr))))

(defn wtn [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        fir (read-string (first inp))
        sec-vec (map #(str/split % #" ") (rest inp))]
    (map first-dot sec-vec )))

;;;;;;;;;;sum of digits

;;;https://www.codechef.com/problems/FLOW006

(defn sum-dig [stri]
  (reduce +
          (map #(- % 48)
               (map int
                    (vec stri)))))

(defn sod [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        sec-vec (rest inp)]
    (map sum-dig sec-vec)))

;;;;;;;;;;;;;;;;;;;

;;;;;temple land


;;;;;;;easy

;;;;;ceil and A-B prob

;;https://www.codechef.com/problems/CIELAB

(defn ceil [filename]
  (let [inp (str/split (slurp (str filename))
                       #" ")
        sec-vec (map read-string inp)]
    (- (first sec-vec)
       (second sec-vec)
       1)))

;;;;;;;clean up

;;;https://www.codechef.com/problems/CLEANUP

(defn clean-up [arr1 arr2]
  (let [ind (read-string (first arr1))
        done-jobs (map read-string
                       arr2)
        rem-jobs (remove (set done-jobs)
                         (range 1
                                (inc ind)))]
    rem-jobs))

(defn clean-list [lis arr]
  (if (empty? lis)
    arr
    (recur (drop 2 lis) (conj arr (clean-up (first lis)
                                            (second lis))))))

(defn assign-helper [arr chef assist]
  (if (empty? (rest arr))
    (cons (conj chef (first arr)) assist)
    (recur (drop 2 arr)
           (conj chef (first arr))
           (conj assist (second arr)))))

(defn assign [lis]
  (assign-helper lis [] []))

(defn clean [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        sec-vec (rest inp)
        th-vec (map #(str/split %
                                #" ")
                    sec-vec)]
    (map assign (clean-list th-vec []))))

;;;;;;;;;;;;;;;racing horse

;;https://www.codechef.com/problems/HORSES

(defn min-diff [lis]
  (- (last lis)
     (first lis)))

(defn horse [filename]
  (let [inp (str/split (slurp (str filename))
                       #"\n")
        lis (map read-string
                 (str/split (drop 2 inp)
                            #" "))]
    (apply min (map min-diff
                    (partition 2 1 (sort lis))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;dump
