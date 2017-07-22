(ns noob2pro.hitesh.test
  (:require [clojure.test :refer :all]
            [noob2pro.hitesh.core :refer :all]
            [expectations :as expect]))

#_(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

;;first
;;(expect/expect 233168 (sum-of-multiples 1000))

;;second
;;(expect/expect 1089154 (number-to-fibonacci 32))
;;(expect/expect 4613732 (sum-calculator 33))

;;third
;;(expect/expect 29 (largest-prime-factor 13195))
;;(expect/expect nil (prime-generator 13))
(expect/expect '(5 7) (filter-prime [5 6 7 8 9]))
(expect/expect true (isprime? 13))

;;fourth
(expect/expect true (ispalindrome? 101))
;;(expect/expect 90909 (fourth-prob 999 999))

;;fifth
;;(expect/expect 232792560 (smallest-divisible))
(expect/expect false (is-divisible? 56))

;;sixth
;;(expect/expect 25164150 (diff-of-values))

;;seventh
(expect/expect 13 (find-prime 6))

;;eight
(expect/expect [1 2 3] (convert-to-list 123))
(expect/expect 67 (check-highest '(1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 67 7) 1))
;;(expect/expect 10 (get-highest-product  123456789876543213252673738))

;;ninth
;;(expect/expect 31875000 (find-product))

;;tenth
;;(expect/expect 17 (sum-of-primes 2))

;;eleventh
(expect/expect 2 (right 0 0 [[1 2] [3 4]]))
(expect/expect 3 (down 0 0 [[1 2] [3 4]]))
(expect/expect 4 (bottom-right 0 0 [[1 2] [3 4]]))
(expect/expect 1 (bottom-left 0 0 [[1 2] [3 4]]))
;;(expect/expect 70600674 (greatest-product ))

;;twelveth
;;(expect/expect 3 (factors 6))
;;(expect/expect false (tri? 20))
(expect/expect 66 (find-number 6))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;Codechef

;;Prob 1
(expect/expect 120 (withdraw "hitesh_withdraw.txt" ))

;;Prob 2
(expect/expect 6 (divisible "hitesh_divisible.txt"))

;;Prob 3
;;(expect/expect (0 14 24 253 5861 2183837) (count-zero "hitesh_count-zero.txt"))
(expect/expect '(1 2 6 24) (factorial '("1" "2" "3" "4")))

;;Prob 4
(expect/expect '(24 1 2 120 6) (small-fact "hitesh_small-fact.txt"))


;;Prob 5
(expect/expect '("1" "3" "5" "6" "7") (turbo "hitesh_turbo.txt"))




;;Prob 6
(expect/expect "Winner is 1 with lead 58" (winner "hitesh_winner.txt"))


;;Prob 7
(expect/expect '(1 3 2) (two-nos "hitesh_twonos.txt"))
(expect/expect '(1 3 2) (mult '("1 2 1" "3 2 3" "3 7 2") []))
(expect/expect 1 (getprod 4 7 2))


;;Prob 8
(expect/expect 1220 (cielab "hitesh_ciel.txt"))

;;Prob 9
(expect/expect '([0 5] 3) (cleanup "hitesh_cleanup.txt"))
(expect/expect '([0 5] 3) (assign-job [0 3 5] [] []))

;;Prob 10
(expect/expect 3 (horse "hitesh_horse.txt"))
