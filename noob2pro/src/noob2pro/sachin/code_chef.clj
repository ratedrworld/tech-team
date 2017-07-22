(ns noob2pro.sachin.code_chef)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; CODE CHEF PROBLEMS
;;;;;;;;;;;BEGINNER LEVEL

(defn take-input
  "Accepts input from resources/input.txt"
  [filename]
  (let [input (slurp (str  "resources/"filename))
        num (clojure.string/split input #"[\s]")]
   (map (fn [x] (Integer/parseInt x)) num)))

;;;;PROBLEM 1
;;;;https://www.codechef.com/problems/HS08TEST

(defn atm
  "Returns Updated balance if withdraw amt < balance & witdraw is multiple of 5 else returns balance"
  [filename]
  (let [input (take-input filename)
        withdraw (first input)
        balance (second input)]
    (if (and  (< withdraw balance) (mod withdraw 5))
      (- balance withdraw 0.5)
      balance)))

;;;;PROBLEM 2
;;;;https://www.codechef.com/problems/INTEST

(defn enormos
  "Returns how many numbers are divisible"
  [filename]
  (let [input (take-input filename)
        div (second input)
        list (drop 2 input)]
    (count (filter (fn [x] (zero? (mod x div))) list)) ))


;;;;PROBLEM 3
;;;;https://www.codechef.com/problems/FCTRL
;;;;Concept of finding trailing 0's learnt  from:http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/


(defn helper-trailing
  "Returns number of trailing 0's of input"
  [inp div cnt]
  (let [quo (quot inp div)]
    (if (< quo 1)
      cnt
      (recur inp (* div 5) (+ cnt quo)))))
(defn trailing
  "Returns no. of trailing zeros of file"
  [filename]
  (let [file (take-input filename)
        input (drop 1 file)]
    (map (fn [a] (helper-trailing a 5 0)) input)))


;;;;PROBLEM 4
;;;;https://www.codechef.com/problems/FCTRL2

(defn factorial-of
  "Returns the factorial of number"
  [inp]
  (reduce * (range 1 (inc inp))))

(defn small-factorials
  [filename]
  (let [file (take-input filename)
        input (drop 1 file)]
    (map #(factorial-of %) input)))


;;;;PROBLEM 5
;;;;https://www.codechef.com/problems/CIELAB

(defn cielab
  "Returns the wrong A-B"
  [filename]
  (let [file (take-input filename)
        a (first file)
        b (second file)
        result (- a b)]
    (if (< (mod result 10) 9)
      (+ result 1)
      (- result 1))))


;;;;PROBLEM 6
;;;;https://www.codechef.com/problems/SUMTRIAN

(defn convert-inp
  "COnverts input into set of vectors in vector accordint to levels of triangle. For eg '(1 2 3) -> [[1] [1 2]] "
  ([input] (convert-inp (rest input) [] 1))
  ([input out cnt ]
   (if (empty? input)
     out
     (recur (drop cnt input) (conj out (apply vector (take cnt input))) (inc cnt)))))

(defn sum-tri
  "Returns the max sum moving along triangle path"
  [input]
  (reduce (fn [m a]
            (apply max
                   (map #(+ m %) (vector (get a (.indexOf input m) 0)
                                         (get a (inc (.indexOf input m)) 0)))))
          1 input))


;;;;PROBLEM 7
;;;;https://www.codechef.com/problems/TWONMS

(defn get-moves
  "Converts input to vector of moves"
  [filename]
  (let [inp (take-input filename)
        no (first inp)
        arr (rest inp)]
    (partition no arr)))

(defn apply-move
  "Applies moves on each player and returns int division"
  [input]
  (let [a (first input)
        b (second input)
        n (last input)
        na (int (Math/ceil (float (/ n 2))))
        nb (int (Math/floor (float (/ n 2))))
        c (reduce (fn [a n] (* a n)) a (repeat na 2))
        d (reduce (fn [a n] (* a n)) b (repeat nb 2))]
    (int  (/ (apply max (vector c d)) (apply min (vector c d))))
    #_(println (str  na nb c d))))
(defn int-divison
  "Calculates the integer divison for all the moves"
  ([filename] (int-divison filename (get-moves filename)))
  ([filename input]
   (map #(apply-move %) input)))


;;;;PROBLEM 8
;;;;https://www.codechef.com/problems/NITIKA

(defn take-input-nitika
  "Accepts input from resources/input.txt"
  [filename]
  (let [input (slurp (str  "resources/"filename))
        num (clojure.string/split input #"[\n]")]
    (map str num)))

(defn get-fix-name
  "Fixes name that is takes initial of first and middle"
  [inp cnt]
  (if (= 2 cnt)
    (str (nth (first inp) 0) ". "(second inp))
    (str (nth (first inp) 0) ". "(nth (second inp) 0)". "(last inp))))



(defn fix-format
  "Note- HAVE CONSIDERED NAME TO ALWAYS BE DIVIDED INTO FIRST NAME, MIDDLE NAME AND LAST NAME.
  Fixes the wrong format accoridng to the rules"
  ([input] (fix-format (map clojure.string/capitalize (clojure.string/split input #"\s")) []))
  ([inp out]
   (if (= (count inp) 1)
     (first inp)
     (get-fix-name inp (count inp)))))

(defn fix-nitika
  "Fixes format for all input"
  [filename]
  (map fix-format (rest  (take-input-nitika filename))))


;;;;PROBLEM 9
;;;;https://www.codechef.com/problems/CLEANUP

(defn input-chef
  "Splits input into total jobs, completed jobs and list of jobs"
  [filename]
  (let [inp (rest (take-input filename))
        total-jobs (first inp)
        no-comp-jobs (second inp)
        comp-jobs (drop 2 inp)]
    (vector total-jobs no-comp-jobs comp-jobs)))


(defn assign-jobs
  "Returns a nested list that contains the list of jobs by chef and then assistant i.e ((Jobs by chef ) (Jobs by assistant))"
  [input]
  (let [tot (first input)
        no-comp (second input)
        comp-jobs (set (last input))
        rem-jobs (into []  (remove comp-jobs (range 1 (inc tot))))]
    (list
     (map (fn [x]
            (get rem-jobs x))
          (filter even? (range 0 (count rem-jobs))))
     (map (fn [x]
            (get rem-jobs x))
          (filter odd? (range 0 (count rem-jobs)))))))
