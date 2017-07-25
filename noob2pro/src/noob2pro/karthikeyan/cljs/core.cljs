(ns learn-cljs.core
  (:require [clojure.string :as string]))

(defn real-magic-happens-here [input]
  (string/join " "
               (mapv string/capitalize
                     (string/split input #" "))))

(defn encryption1
  [data key]
  (let [x (count key)
        y (partition (/ (count data) (count key)) data)
        s (sort key)
         arr (string/split s #"")
        z (zipmap s y)]
    (apply str
           (map #(apply str (get z %)) key))))



(defn decryption1
  [cipher k]
  (let [a (/ (count cipher) (count k))
        b (partition a cipher)
                                        ; arr (seq (char-array k))
        c (zipmap k b)
        d (sort-by key c)]
    (reduce str (map #(apply str (get c %)) (sort k)))))

(defn decryption
  "I don't do a whole lot ... yet."
  [& args]
  (let [data (.-value (.getElementById js/document "cipher"))
        key (.-value (.getElementById js/document "key1"))
        output (decryption1 data key)]

    (set! (.-value (.getElementById js/document "plain"))
          output)))

(defn encryption
  "I don't do a whole lot ... yet."
  [& args]
  (let [data (.-value (.getElementById js/document "plaintext"))
        key (.-value (.getElementById js/document "key"))
        output (encryption1 data key)]
    (set! (.-value (.getElementById js/document "cipher"))
          output)))
