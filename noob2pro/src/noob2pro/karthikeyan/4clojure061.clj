(ns noob2pro.karthikeyan.4clojure061)

;;http://www.4clojure.com/problem/61
;;Map construction

(defn map-construct
  [alst blst]
  (into {} (map vector alst blst)))
