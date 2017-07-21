(ns noob2pro.hitesh.test
  (:require [clojure.test :refer :all]
            [noob2pro.hitesh.core :refer :all]
            [expectations :as expect]))

#_(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
(comment
  ;;first

  (expect/expect 233168 (sum-of-multiples 1000))



  ;;second

  (expect/expect 1089154 (number-to-fibonacci 32))
  (expect/expect 23 (sum-calculator 33))


  ;;third

  (expect/expect 29 (largest-prime-factor 13195))
  (expect/expect nil (prime-generator 13))
  (expect/expect true (filter-prime [1 2 3 4 5]))
  (expect/expect true (isprime? 2 13))


  ;;fourth

  (expect/expect true (ispalindrome? 101))
  #_(expect/expect 90909 (fourth-prob 999 999))


  ;;fifth

  (expect/expect 232792560 (smallest-divisible))
  (expect/expect false (is-divisible? 56))


  ;;sixth

  (expect/expect 25164150 (diff-of-values))

  ;;seventh

  (expect/expect 13 (find-prime 6))


  ;;eight
  (expect/expect [1 2 3] (convert-to-list 123))
  (expect/expect 10 (check-highest (1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 67 7)))
  (expect/expect 10 (get-highest-product  123456789876543213252673738))

  ;;ninth

  (expect/expect 31875000 (find-product))

  ;;tenth

  (expect/expect 17 (sum-of-primes 2))


  ;;eleventh

  (expect/expect 24 (right 0 0 [[1 2] [3 4]]))
  (expect/expect 24 (down 0 0 [[1 2] [3 4]]))
  (expect/expect 24 (bottom-right 0 0 [[1 2] [3 4]]))
  (expect/expect 24 (bottom-left 0 0 [[1 2] [3 4]]))
  (expect/expect 70600674 (greatest-product ))

  ;;twelveth

  (expect/expect 3 (factors 6))
  (expect/expect false (tri? 20))
  (expect/expect 28 (find-number 6)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;Codechef

;;Prob 1
;;(expect/expect 89.5 (withdraw))
;;(expect/expect 120 (withdraw))

;;Prob 2
;;(expect/expect 4 (divisible))

;;Prob 3
;;(expect/expect (0 14 24 253 5861 2183837) (count-zero))
;;(expect/expect (1 2 6 24) (factorial '(1 2 3 4)))

;;Prob 4
;;(expect/expect (1 2 2) (small-fact))

;;Prob 5
;;(expect/expect {1 3 5 6 7} (turbo))

;;Prob 6
;;(expect/expect 1 58 (lead))
