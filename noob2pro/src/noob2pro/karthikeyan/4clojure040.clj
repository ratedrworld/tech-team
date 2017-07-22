(ns noob2pro.karthikeyan.4clojure040)

;;http://www.4clojure.com/problem/40
;;Interpose a seq

(defn interp
  [x lst]
  (conj (into []
              (mapcat list
                      lst
                      (repeat (dec (count lst))
                              x)))
        (last lst)))
