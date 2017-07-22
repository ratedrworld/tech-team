(ns noob2pro.karthikeyan.4clojure090)

;;http://www.4clojure.com/problem/90
;;Cartesian Product

(defn cartesian
  [m1 m2]
  (into #{} (mapcat (fn
                      [a]
                      (reduce (fn
                                [b c]
                                (conj b (vector a c)))
                              []
                              m2))
                    m1)))
