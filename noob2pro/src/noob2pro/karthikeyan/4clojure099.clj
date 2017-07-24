(ns noob2pro.karthikeyan.4clojure099
  (:require [clojure.string :as str]))

;;http://www.4clojure.com/problem/99

(defn product-digits
  [& args]
  (let [a (reduce * args)
        s (str a)]
    (into [] (map read-string (clojure.string/split s #"")))))
