(ns noob2pro.karthikeyan.4clojure107)

;;http://www.4clojure.com/problem/107


(defn power
  [x]
  (fn [a]
    (reduce * (repeat x a))))
