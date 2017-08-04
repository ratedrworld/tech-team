(ns to-do-list.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [to-do-list.core-test]))

(doo-tests 'to-do-list.core-test)

