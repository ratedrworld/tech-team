(ns sachin-cljs.core
  (:require [clojure.string :as string]))

(defn split-plaintext
  "Splits the plaintext into partitions of size key"
  [plaintext key]
  (vec (partition (/ (count plaintext) (count key)) (string/split plaintext ""))))

(defn sort-key
  "Sorts the key according alphabet and returns the sorted pattern"
  [key]
  (into (sorted-map) (zipmap (string/split key "") (range (count key)))))
(defn encrypt
  "Encrypts the plaintext using key and returns"
  [plaintext key]
  (string/join (flatten (map (fn [x] (get-in (split-plaintext plaintext key) [(second x)])) (sort-key key)))))

(defn main
  "Takes input from form and returns the output"
  [& args]
  (let [plaintext (.-value (.getElementById js/document "plaintext"))
        key (.-value (.getElementById js/document "key"))
        enc (encrypt plaintext key)]
    (set! (.-value (.getElementById js/document "output"))
          enc)))
