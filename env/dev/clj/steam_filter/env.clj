(ns steam-filter.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [steam-filter.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[steam-filter started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[steam-filter has shut down successfully]=-"))
   :middleware wrap-dev})
