(ns noob2pro.karthikeyan.4clojure031)

;;http://www.4clojure.com/problem/31
;;Pack a sequence

(defn pack
  [lst]
  (if (empty? lst)
    lst
    (do
      (let [conseq (take-while #(= (first lst) %) lst)]
        (cons conseq (pack (drop (count conseq) lst)))))))
