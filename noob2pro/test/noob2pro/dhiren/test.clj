(ns noob2pro.dhiren.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.dhiren.core :refer :all]
            [noob2pro.dhiren.4clojure :refer :all]
            [noob2pro.dhiren.clock :refer :all]
            [expectations :as expect]
            ))

#_(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(expect/expect '(1 1 2) (b 3))


;;(expect/expect 5 (prime-f 15))

;;(expect/expect 29 (prime-f 13195))


(expect/expect 25164150 (prob6 100))
(expect/expect 2640 (prob6 10))


(expect/expect 22 (prob6 3))

(expect/expect 2520 (prob5 10))

(expect/expect 60 (triplet 12))

(expect/expect 23514624000 prob8-ans)

(expect/expect 17 (sum-prime 10))

(expect/expect 28 (prob12 6))

;;Codechef tests

#_(expect/expect 89.5 (ATM test.txt))

(expect/expect 6 (factorial 3))

(expect/expect 120 (factorial 5))

(expect/expect '(1 2 3 5) (my-interleave [1 3] [2 5]))

(expect/expect '(1 1 2 2 3 3) (replicate1 [1 2 3] 2))

(expect/expect [1 0 2 0 3] (my-interpose 0 [1 2 3]))

(expect/expect '((1 1)(2)) (pack [1 1 2]))

(expect/expect [1 2 3 5 6] (drop-nth [1 2 3 4 5 6] 4))

(expect/expect ['(1 2) '(3 4 5)] (my-splitat 2 [1 2 3 4 5]))

(expect/expect {:a 1 :b 2} (my-zipmap [:a :b] [1 2]))
(expect/expect #{3 2} (my-intersection [0 1 2 3] [2 3 4 5]))
#_(expect/expect 1 (my-powerfn 1 3))

(expect/expect '(1 2) (sep-digits 2 6))


;;;Clock game test cases;;;;;;;;

(expect/expect [10.0 19.0] (min-hand 30))

(expect/expect [19.0 10.0] (min-hand 15))

(expect/expect [1.0 10.0] (min-hand 45))

(expect/expect [16.36396103067893 16.36396103067893] (min-hand 22.5))

(expect/expect [10.0 4.0] (hour-hand 12 0))

(expect/expect [16.0 10.0] (hour-hand 3 0))

(expect/expect [10.0 16.0] (hour-hand 6 0))

(expect/expect [4.0 10.0] (hour-hand 9 0))
