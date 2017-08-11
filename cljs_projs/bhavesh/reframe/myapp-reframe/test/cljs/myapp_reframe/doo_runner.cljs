(ns myapp-reframe.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [myapp-reframe.core-test]))

(doo-tests 'myapp-reframe.core-test)

