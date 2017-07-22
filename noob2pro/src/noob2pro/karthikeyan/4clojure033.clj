(ns noob2pro.karthikeyan.4clojure033)


;;http://www.4clojure.com/problem/33
;;Replicate a Sequence



(fn
  [lst n]
  (mapcat #(repeat n %) lst))
