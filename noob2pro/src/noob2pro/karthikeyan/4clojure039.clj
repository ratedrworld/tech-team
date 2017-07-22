(ns noob2pro.karthikeyan.4clojure039)

;;http://www.4clojure.com/problem/39
;;Interleave two seqs

(defn interleav
  [a b]
  (mapcat list a b))
