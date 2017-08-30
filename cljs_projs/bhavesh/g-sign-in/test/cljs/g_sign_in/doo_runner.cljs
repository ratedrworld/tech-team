(ns g-sign-in.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [g-sign-in.core-test]))

(doo-tests 'g-sign-in.core-test)

