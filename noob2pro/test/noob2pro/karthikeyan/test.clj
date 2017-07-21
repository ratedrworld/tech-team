(ns noob2pro.karthikeyan.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.karthikeyan.core :refer :all]
            [expectations :as expect]))

(expect/expect "hello world" "hello world")

(expect/expect 23 (mulsum35 10))

(expect/expect 2318 (mulsum35 100))

(expect/expect 2 (evenfibo 3))

(expect/expect '(1 1 2) (take 3 (fibo)))

(expect/expect 5 (largestprime 5))

(expect/expect true (prime? 31))

(expect/expect 32 (exp 2 5))

(expect/expect [1 2] (numdigits 12))

(expect/expect true (palindrome? 121))

(expect/expect false (palindrome? 123))

(expect/expect 10 (gcd 20 10))

(expect/expect 100 (lcm 10 100))

(expect/expect 2520 (smallestmultiple 1 10))
