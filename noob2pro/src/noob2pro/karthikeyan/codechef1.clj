(ns noob2pro.karthikeyan.codechef1)


;;https://www.codechef.com/problems/HS08TEST

(defn atm
  [a b]
  (if-not (zero? (rem a 5))
    b
    (if (<= 0 (- b a 0.50))
      (- b a 0.50)
      b)))

(defn readinput
  []
  (let [a (slurp "resources/ATM.txt")
        b (clojure.string/split a #" ")]
    (atm (read-string (first b)) (read-string (second b)))))
