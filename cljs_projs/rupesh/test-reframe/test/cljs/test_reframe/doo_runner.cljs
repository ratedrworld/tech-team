(ns test-reframe.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [test-reframe.core-test]))

(doo-tests 'test-reframe.core-test)

