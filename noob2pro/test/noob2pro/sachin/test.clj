(ns noob2pro.sachin.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.sachin.core :refer :all]
            [noob2pro.sachin.code_chef :refer :all]
            [expectations :as expect]))

;; Problem 1 Test Cases
(expect/expect 23 (sum-of-multi 10))

(expect/expect 233168 (sum-of-multi 1000))

;; Problem 2 Test Cases

(expect/expect '(1 2 3 5 8 13 21 34 55 89) (take 10 (get-fibo-num)))
#_(expect/expect 44 (sum-even-fibo 10))
(expect/expect 4613732 (sum-even-fibo))

;; Problem 3 Test Cases

(expect/expect '(1 3 5) (get-factors 15))
(expect/expect 29 (largest-prime-factor 13195))
(expect/expect 29 (largest-prime-factor-1 13195))
#_(expect/expect 6857 (largest-prime-factor-1 600851475143))

;; Problem 4 Test Cases

(expect/expect [906609] (largest-palin))

;; Problem 5 Test Cases

(expect/expect nil (isdiv? 2520))
#_(expect/expect 232792560 (smallest-div-num)) ;;Returns success but takes too much time to execute

;; Problem 6 Test Cases

(expect/expect 338350 (sum-of-squares))
(expect/expect 25502500 (square-of-sum))
(expect/expect 25164150 (final-difference))

;; Problem 7 Test Cases

(expect/expect true (prime? 7))
(expect/expect false (prime? 9))
(expect/expect 13 (prime-no-index 6))

;; Problem 8 Test

#_(expect/expect '(1 2 3) (multiply-parts [[1 1 2] [1 1 3] [1 1 4]]))
#_(expect/expect [1 2 3] (split-digits [123]))
#_(expect/expect [[1 2 3 4] [5 6 7 8]] (split-parts 4))

;; Problem 9 Test Cases

#_(expect/expect true (triplet? 3 4 5))
#_(expect/expect false (triplet? 6 7 8))

(expect/expect 31875000 (special-triplet 1000))

;; Problem 10 Test Cases

(expect/expect 17 (prime-sum 10))

;; Problem 11 Test Cases

(expect/expect 1651104 (down 0 0))
(expect/expect 34144 (right 0 0))
(expect/expect 279496 (diagonal-right 0 0))
(expect/expect 8 (diagonal-left 0 0 ))
(expect/expect 70600674 (largest-prod-grid grid))

;; Problem 12 Test Cases

(expect/expect '(28) (highly-div-tri 5))
#_(expect/expect '(73920) (highly-div-tri 100))

;;;;;;;;;;;; Code chef Problems

;;;;Problem 1

(expect/expect 89.5 (atm "atm-input.txt"))

;;;;Problem 2

(expect/expect 4 (enormos "enormos-input.txt")
               )

;; Problem 3

;(expect/expect '(0 14 24 253 5861 2183837) (trailing "trailing-input.txt"))

;;Problem 4

;(expect/expect '(1 2 120 6) (small-factorials "small-factorials-input"))

;;Problem 5

;(expect/expect 1118 (cielab "cielab-input.txt"))

;;Problem 6

;(expect/expect '(4 1 1 2 4 1 2 2 3 1 1) (take-input "sum-tri-input"))
;(expect/expect [[1] [1 2] [4 1 2] [2 3 1 1]] (convert-inp (take-input "sum-tri-input")))
;(expect/expect 9 (sum-tri (convert-inp (take-input "sum-tri-input"))))


;;Problem 7

(expect/expect '((1 2 1) (3 2 3) (3 7 2)) (get-moves "two-numbers-input"))
(expect/expect 2 (apply-move '(3 7 2)))
(expect/expect '(1 3 2) (int-divison "two-numbers-input"))
