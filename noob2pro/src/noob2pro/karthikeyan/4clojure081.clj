(ns noob2pro.karthikeyan.4clojure081)

;;http://www.4clojure.com/problem/81
;;Set intersection

(defn set-inter
  [m1 m2]
  (into #{} (reduce (fn [a b]
                      #_(println a b)
                      (if (contains? m2 b)
                        (conj a b)
                        a))
                    []
                    m1)))
