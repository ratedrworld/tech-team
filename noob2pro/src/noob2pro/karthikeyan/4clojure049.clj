(ns noob2pro.karthikeyan.4clojure049)

;;http://www.4clojure.com/problem/49


(defn my-split-at
  "Splits the list at x and returns two lists"
  [x lst]
  (if (> x (count lst))
    nil
    (vector (take x lst) (drop x lst))))
