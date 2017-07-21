(ns noob2pro.karthikeyan.codechef2
  (:require [clojure.string :as str1]))

;;https://www.codechef.com/problems/INTEST

(defn divisible
  [arr k]
  (let [n (first arr)
        arr1 (rest arr)]
    (count (filter #(= 0 (mod % k)) arr1))))

(defn readinput
  []
  (let [txt (slurp "resources/INTEST.txt")
        splitxt (str1/split txt #"\n")
        k (read-string (second (str1/split txt #" ")))
        arr (map #(read-string %) splitxt)]
    (divisible arr k)))




(fn compress
  [lis]
  (if (string? lis)
    (distinct lis)
    (reduce (fn [a b]
              (if-not (= (last a) b)
                (conj a b)
                a))
            []
            lis)))
