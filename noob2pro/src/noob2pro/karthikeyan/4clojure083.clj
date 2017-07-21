(ns noob2pro.karthikeyan.4clojure083)

(defn half-truth
  [& args]
  (if (= true (reduce (fn [a b]
                        (or a b))
                      args))
    false
    (reduce (fn [a b]
              (or a b))
            args)))
