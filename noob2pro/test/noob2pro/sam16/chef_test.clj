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
