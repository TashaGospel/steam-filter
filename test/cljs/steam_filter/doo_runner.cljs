(ns steam-filter.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [steam-filter.core-test]))

(doo-tests 'steam-filter.core-test)

