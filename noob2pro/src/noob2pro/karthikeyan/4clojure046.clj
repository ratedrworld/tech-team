(ns noob2pro.karthikeyan.4clojure046)

;;http://www.4clojure.com/problem/46#prob-title
;;Flipping out

(fn
  [func]
  (fn
    [& args]
    (apply func args)))
