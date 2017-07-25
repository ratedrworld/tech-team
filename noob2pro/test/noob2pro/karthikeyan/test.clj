(ns noob2pro.karthikeyan.test
  (:require #_[clojure.test :refer :all]
            [noob2pro.karthikeyan.core :refer :all]
            [noob2pro.karthikeyan.codechef1 :as chef1]
            [noob2pro.karthikeyan.codechef2 :as chef2]
            [noob2pro.karthikeyan.4clojure039
             :as clo4-39]
            [noob2pro.karthikeyan.4clojure049
             :as clo4-49]
            [noob2pro.karthikeyan.4clojure061
             :as clo4-61]
            [noob2pro.karthikeyan.4clojure081
             :as clo4-81]
            [noob2pro.karthikeyan.4clojure062
             :as clo4-62]
            [noob2pro.karthikeyan.4clojure090
             :as clo4-90]
            [noob2pro.karthikeyan.4clojure099
             :as clo4-99]
            [noob2pro.karthikeyan.game
             :refer :all]
            [noob2pro.karthikeyan.transpose
             :as transpose]
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

(expect/expect 89.50 (chef1/atm 30 120.0))

(expect/expect 120.00 (chef1/atm 42 120.00))

(expect/expect '(1 :a 2 :b 3 :c) (clo4-39/interleav [1 2 3] [:a :b :c]))

(expect/expect [[1 2 3] [4 5 6]] (clo4-49/my-split-at 3 [1 2 3 4 5 6]))

(expect/expect [[1 2 3] [4 5]] (clo4-49/my-split-at 3 [1 2 3 4 5]))

(expect/expect nil (clo4-49/my-split-at 7 [1 2 3 4 5 6]))

(expect/expect {:a 1, :b 2,:c 3} (clo4-61/map-construct [:a :b :c] [1 2 3]))

;(expect/expect {:a , :b , :c} (clo4-61/map-construct [:a :b :c] []))

;(expect/expect nil (clo4-61/map-construct [] [:a :b :c]))

(expect/expect #{2 3} (clo4-81/set-inter #{2 3 4 5} #{2 3}))

(expect/expect [1 2 4 8 16] (take 5 (clo4-62/my-iterate #(* 2 %) 1)))


(expect/expect #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]} (clo4-90/cartesian #{1 2 3} #{4 5}))

(expect/expect [8 9 1] (clo4-99/product-digits 99 9))

#_(expect/expect {false [1 3], true [6 8]} ())

(expect/expect [[0 0] [0 1] [1 0] [1 1]]
               (index-list 2))

(expect/expect ["a" "b"] (transpose/split-letters "ab"))
