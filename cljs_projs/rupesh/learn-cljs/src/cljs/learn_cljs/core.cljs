(ns learn-cljs.core
  (:require [clojure.string :as string]))



(defn encrypt
  "Without using recursion
  Returns cipher text when passed plain text and key"
  [plain key]
  (let [sort-key (sort key)
        part-count (/ (count plain)
                      (count key))
        plain-p (partition part-count
                           plain)
        zmap (zipmap sort-key
                     plain-p )]
    (apply str (map #(apply str
                            (get zmap %))
                    key))))

(defn decrypt
  [cipher key]
  (let [sort-key (sort key)
        cipher-k (partition (/ (count cipher)
                               (count key)) cipher)
        zmap (zipmap key cipher-k)]
    (apply str (map #(apply str
                            (get zmap %))
                    sort-key))))

(defn func
  [&args]
  (let [input (.-value (.getElementById js/document "input"))
        key (.-value (.getElementById js/document "key"))
        option (.-value (.getElementById js/document "enc-dec"))]
    (if (= option "1")
      (set! (.-value (.getElementById js/document "output"))
            (encrypt input key))
      (set! (.-value (.getElementById js/document "output"))
            (decrypt input key)))))
