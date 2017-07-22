(ns noob2pro.sam16.chef_test
  (:require [noob2pro.sam16.codechef :refer :all]
            [expectations :as exlib]))

;; Prob 1
(exlib/expect 74.50 (atm "chef1.txt"))
;;(exlib/expect 120.00 (atm))

;; Prob 2
(exlib/expect 4 (inp_test "chef2.txt"))

;; Prob 3
(exlib/expect 1 (count_zeros 5 5 0))
(exlib/expect '(0 14 24 253 5861 2183837) (fctrl "chef3.txt"))

;; Prob 4
(exlib/expect 120 (factorial 5))
(exlib/expect '(1 2 120 6) (small_fact "chef4.txt"))

;; Prob 5
(exlib/expect '(1 3 5 6 7) (tsort "chef5.txt"))

;; Prob 6
(exlib/expect '("mahatma" "gandhi") (split_spaces "mahatma gandhi"))
(exlib/expect ". " (cap_dot ""))
(exlib/expect "M. K. Gandhi" (format_name ["mohandaSAS" "koarnshkbfa" "ganDHI"]))
(exlib/expect '("Gandhi" "M. Gandhi" "M. K. Gandhi") (nitika "chef6.txt"))

;; Prob 7
(exlib/expect 4623 (cielAB "chef7.txt"))

;; Prob 8
(exlib/expect '((3 6) (5)) (assignjobs '("6 3" "2 4 1")))
(exlib/expect '((3 6) (5) (1) () (1 4 6) (2 5 7)) (cleanup "chef8.txt"))
