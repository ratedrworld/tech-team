(ns noob2pro.karthikeyan.chef_test
  (:require #_[clojure.test :refer :all]
            [noob2pro.karthikeyan.codechef1 :as chef1]
	    [noob2pro.karthikeyan.codechef2 :as chef2]
            [expectations :as expect]))

(expect/expect "Hello" "Hello")

(expect/expect 89.50 (chef1/atm 30 120.0))

(expect/expect 120.00 (chef1/atm 42 120.00))
