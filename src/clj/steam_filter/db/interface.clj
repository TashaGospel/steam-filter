(ns steam-filter.db.interface
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all]
            [mount.core :refer [defstate]]
            [steam-filter.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn upsert-game [game]
  (mc/update db "games"
             (select-keys game [:appid])
             {$set game}
             {:upsert true}))

(defn get-user [id]
  (mc/find-one-as-map db "users" {:_id id}))
