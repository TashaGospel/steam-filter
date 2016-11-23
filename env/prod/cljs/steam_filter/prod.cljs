(ns steam-filter.app
  (:require [steam-filter.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
