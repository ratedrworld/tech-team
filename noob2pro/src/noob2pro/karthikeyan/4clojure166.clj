(ns noob2pro.karthikeyan.4clojure166)

;;http://www.4clojure.com/problem/166

(defn comparisons
  [a b c]
  (if (a b c)
    :lt
    (if (a c b)
      :gt
      :eq)))
