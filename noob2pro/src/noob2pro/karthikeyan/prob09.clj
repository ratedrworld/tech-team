(ns noob2pro.karthikeyan.prob09)


(defn square
  [a]
  (* a a))

(defn pythagorean?
  "Checks whether three natural numbers are pythagorean triplets or not"
  [a b c]
  (= (square c) (+ (square a) (square b))))

(defn calculate-c
  "Returns the value of a^2 + b^2"
  [a b]
  (+ (square a) (square b)))

(defn sumn?
  [n a b c]
  (if (= (+ a b c) n)
    (* a b c)))

(defn cross-product
  "Returns all possible combinations of a and b and"
  [n]
   (for [a (range 1 (/ n 2))
           b (range (inc a) (/ n 2))
           :let [c (- n a b)]
         :when (pythagorean? a b c)]
     ( a b c)))
