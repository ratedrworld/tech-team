(ns noob2pro.sachin.test_luhnprob
  (:require [noob2pro.sachin.luhn-algo-problem :refer :all]
            [expectations :as :expect]))


(expect/expect 70 (get-luhn-sum (reverse [4 1 2 3 1 7 5 9 0 4 9 8 1 7 54 ])))

(expect/expect true (is-luhn-algo [4 1 2 3 1 7 5 9 0 4 9 8 1 7 54 ]))

(expect/expect [0 1 2 3] (convert-str-int "0123"))

(expect/expect "3942682966937054" (get-missing-digit "?942682966937054"))

(expect/expect [[1 2] [4 3]]) (swap-pos [[1 2] [3 4]] 1)

(expect/expect "1217040151414995" (fix-swap-error "1217400151414995"))

(expect/expect '("3942682966937054" "1217040151414995" "2146133934667114" "2553514623369425") (solve-luhn-prob "luhn-prob-input"))
