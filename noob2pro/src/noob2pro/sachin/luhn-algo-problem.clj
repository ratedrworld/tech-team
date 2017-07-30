(ns noob2pro.sachin.luhn-algo-problem)


(defn get-luhn-sum
  "Returns the sum using luhn algrorithm logic"
  [input]
  (let [size (count input)
        even-pos (take-nth 2 input)
        odd-pos (take-nth 2 (rest  input))
        odd-nums (reduce + (map
                            #(if (> (count (str (* 2 %))) 1)
                               (-  (* 2 %) 9)
                               (* 2 %))
                            odd-pos))
        even-nums (reduce + even-pos)]
    (+ odd-nums even-nums)))

(defn is-luhn-algo
  "Checks if the input satisfies the luhn algorithm, if it does return true"
  [input]
  (= 0 (mod (get-luhn-sum (reverse input)) 10)))

(defn convert-str-int
  "Converts string to vector of numbers"
  [input]
  (mapv #(- (int %) 48) input))


(defn get-missing-digit
  "Returns the correct number by replacing value of ? with appropriate digit that satisfies luhn algorithm"
  [input]
  (some (fn [x]
          (if (is-luhn-algo (convert-str-int
                             (clojure.string/replace input #"\?" (str x))))
            (clojure.string/replace input #"\?" (str x))
            false))
        (range 10)))


(defn swap-pos
  "Swaps the position at index and returns the result"
  [input index]
  (assoc input index (vec  (reverse (get input index)))))

(defn fix-swap-error
  "Fixes swap error and returns the correct number that satisfies luhn algorithm"
  [input]
  (let [in (mapv vec (partition 2 (convert-str-int input)))]
    (some (fn [x]
            (if  (is-luhn-algo (vec (flatten (swap-pos in x))))
              (apply str (flatten (swap-pos in x)))
              false))
          (range (count in)))))

(defn solve-luhn-prob
  "Solves the inputs and returns the list of correct answer"
  [filename]
  (let [input (slurp (str "resources/" filename))
        num (clojure.string/split input #"[\n]")]
    (map (fn [x]
           (if (clojure.string/includes? x "?")
             (get-missing-digit x)
             (fix-swap-error x)))
         (rest num))))
