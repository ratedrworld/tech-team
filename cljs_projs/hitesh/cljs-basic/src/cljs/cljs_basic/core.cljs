(ns cljs-basic.core
  (:require [clojure.string :as string]))


(defn get-output
  "Converts input to output"
  [input]
  (string/join " " (mapv string/capitalize (string/split input #" "))))



(defn encrypt
  "Encrypts the string based on key"
  [stri key]
  #_(string/split stri #"")
  (let [split-arr (partition (/ (count stri)
                                (count key))
                             (string/split stri ""))
        split-key (string/split key "")]
    (apply str (flatten (vals (sort (zipmap split-key split-arr)))))))



(defn mymain
  "I don't do a whole lot ... yet."
  [& args]
  #_(.write js/document "hello world")
  (let [stri (.-value (.getElementById js/document "stri"))
        key (.-value (.getElementById js/document "key"))
        output (encrypt stri key)]
    (set! (.-value (.getElementById js/document "output"))
          output)))
