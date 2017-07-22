(ns noob2pro.dhiren.4clojure)

(defn my-zipmap
  "http://www.4clojure.com/problem/61"
  [a b]
  (into {} (map vector a b)))


(defn my-intersection
  "http://www.4clojure.com/problem/81"
  [a b]
  (into #{} (filter #(contains? a %) b)))

(fn [n] (fn [b]
          (reduce * (repeat b n))))


(defn iterate1
"creates a lazy sequence after applying function "
  [f x]
  (lazy-seq (cons x (iterate1 f (f x)))))

(defn cart-prod
  "Calculates cartesian product"
  [a b]
  (into #{} (mapcat (fn [x]
                      (map #(vector % x) a))
                    b)))

#_(defn sep-digits
  "seperates the digits after multiplying"
  [a b]
    (str (* a b))
    ;;not completed
  )
