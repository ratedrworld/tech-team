
(ns noob2pro.sachin.code_chef
(:gen-class))

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
  [input]
  (reduce (fn [m a]
            (apply max
                   (map #(+ m %) (vector (get a (.indexOf input m) 0)
                                         (get a (inc (.indexOf input m)) 0)))))
          1 input))


;;;;PROBLEM 7
;;;;
