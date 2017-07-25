(ns noob2pro.rupesh.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.rupesh.core :refer :all]
            [expectations :as expect]))

#_(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

#_(expect/expect empty? [])
(expect/expect empty? [])

;my-take tests



;(expect/expect '(1) (my-take 1 [1]))


#_(expect/expect () (my-take 1 nil))

#_(expect/expect '(1 2 3) (my-take 3 [1 2 3 4]))

;(expect/expect '(1 2 3) (my-take 3 [1 2 3 4]))


;my-map tests

;(expect/expect '(2 3 4 5) (my-map-impl inc [1 2 3 4]))

;(expect/expect '(1 2 3) (my-take 3 [1 2 3 4]))

;(expect/expect '(2 3 4 5) (my-map-impl inc [1 2 3 4]))

;(expect/expect '(0 1 2 2) (my-map-impl dec [1 2 3 3]))

;my-func tests

#_(expect/expect '(2 4 6 8) (my-func [1 2 3 4]))

;my-filter tests

#_(expect/expect [0 2 4 6 8] (my-filter even? (range 10)))

;(expect/expect false (my-some? nil))


;my-sort tests
#_(expect/expect (3 6 7 12 34) (my-sort [34 12 6 7 3]))


;(expect/expect true (not-empty? [1 2]))

;my-into tests

;(expect/expect {:a 1, :b 2, :c 3} (my-into (sorted-map) [[:a 1] [:c 3] [:b 2]]))

;(expect/expect [[1 2] [3 4]] (my-into [] {1 2, 3 4}))

;(expect/expect [1 2 3 4 5 6] (my-into [1 2 3] '(4 5 6)))


;(expect/expect 10 (sum [1 2 3 4]))

;(expect/expect 10 (sum [1 2 3 4]))

;(expect/expect "This is my text, LOL" (xyz "This is my text, lol"))

                                        ;test for project euler problems

(expect/expect 23 (mul 10))

(expect/expect 0 (mul 1))



(expect/expect 4613732 a)

(expect/expect 29 (prime-factors 13195))

(expect/expect 6857 (prime-factors 600851475143))

(expect/expect 173 (prime-factors (* 113 173)))

(expect/expect 2 (gcd 4 6))

(expect/expect 2520 (reduce lcm (range 1 10)))

(expect/expect 2640 (final 10))

(expect/expect 25164150 (final 100))



(expect/expect 31875000 (my-triplet 1000))

(expect/expect 480 (my-triplet 24))

(expect/expect 5 (sum-of-primes 5))

(expect/expect 17 (sum-of-primes 10))

(expect/expect 142913828922 (sum-of-primes 2000000))

(expect/expect 25200 (div-tri-num))

(expect/expect 89.5 (atm "atm.txt"))

(expect/expect 5 (enormousInputTest "EIT.txt"))

(expect/expect '(1 2 120 6) (fact "factorial.txt"))

(expect/expect 1 (nth-element '(1 2 3 4) 0))

(expect/expect 3 (nth-element '(1 2 3 4) 2))

(expect/expect 5 (cnt-a-seq '(1 2 3 4 5)))

(expect/expect 0 (cnt-a-seq '()))

(expect/expect '(3 2 1) (rev-a-seq '(1 2 3)))

(expect/expect '(1 :a 2 :b 3 :c) (interleave-seq [1 2 3] [:a :b :c]))

(expect/expect 5 (count-seq '(1 2 3 4 5)))


(expect/expect '([16 10] [10 19]) (time-to-angle '("3" "00")))

(expect/expect '(([16 10] [10 19]) ([5 13] [5 18])) (main-clock "clock-hand"))

