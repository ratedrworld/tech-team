(ns noob2pro.karthikeyan.4clojure041)

;;http://www.4clojure.com/problem/41
;;Drop every Nth item

(fn dro
  [lst n]
  (let [ans (apply concat (reduce (fn
                                    [a b]
                                    (conj a (drop-last b)))
                                  []
                                  (partition-all n lst)))]
    (if (zero? (mod (count lst) n))
      ans
      (conj ans (last lst)))))
