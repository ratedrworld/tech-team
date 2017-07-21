(ns noob2pro.karthikeyan.4clojure042)

(defn fact
  [n]
  (loop [a n res 1]
    (if (zero? a)
      res
      (recur (dec a) (* res a)))))
