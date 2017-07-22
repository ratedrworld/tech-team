(ns noob2pro.karthikeyan.4clojure062)

;;http://www.4clojure.com/problem/62


(defn my-iterate
  [f x]
  (lazy-seq (cons x (my-iterate f (f x)))))
