(ns sam-cljs.core
  (:require [clojure.string :as string]))

(defn sort-cipher [cipher]
  (into (sorted-map)
        (zipmap cipher (range (count cipher)))))

(defn transform-cipher [input cipher]
  (let [pair-count (/ (count input) (count cipher))
        ip-vec (vec (partition pair-count input))]
    (string/join (flatten
                  (map #(get-in ip-vec [(second %)])
                       (sort-cipher cipher))))))


(defn encryption-main
  "I don't do a whole lot ... yet."
  [& args]
  (let [inp-string (.-value (.getElementById js/document "inp-string"))
        cipher-key (.-value (.getElementById js/document "inp-key"))
        inp (js->clj (.split (clj->js inp-string) ""))
        cipher (string/split cipher-key "")
        cipher-text (transform-cipher inp cipher)]
    (set! (.-value (.getElementById js/document "cipher-text"))
          cipher-text)))
