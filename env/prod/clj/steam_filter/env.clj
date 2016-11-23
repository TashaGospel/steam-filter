(ns steam-filter.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[steam-filter started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[steam-filter has shut down successfully]=-"))
   :middleware identity})
