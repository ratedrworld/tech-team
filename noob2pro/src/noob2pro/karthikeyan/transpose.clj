(ns noob2pro.karthikeyan.transpose
  (:require [clojure.string :as str]))

(defn split-letters
  [a]
  (let [b (str/split a #"")]
    b))
