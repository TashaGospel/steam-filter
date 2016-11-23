(ns user
  (:require [mount.core :as mount]
            [steam-filter.figwheel :refer [start-fw stop-fw cljs]]
            steam-filter.core))

(defn start []
  (mount/start-without #'steam-filter.core/repl-server))

(defn stop []
  (mount/stop-except #'steam-filter.core/repl-server))

(defn restart []
  (stop)
  (start))


