(ns ajax-hello-world.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [ajax-hello-world.core-test]))

(doo-tests 'ajax-hello-world.core-test)

