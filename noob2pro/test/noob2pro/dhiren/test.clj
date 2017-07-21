(ns noob2pro.dhiren.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.dhiren.core :refer :all]
            [expectations :as expect]))

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
