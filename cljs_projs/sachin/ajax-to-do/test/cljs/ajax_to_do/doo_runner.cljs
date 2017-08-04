(ns ajax-to-do.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [ajax-to-do.core-test]))

(doo-tests 'ajax-to-do.core-test)

