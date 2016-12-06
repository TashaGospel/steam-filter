(ns steam-filter.db.steam
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]
            [mount.core :refer [defstate]]))

(def games-list-url "http://api.steampowered.com/ISteamApps/GetAppList/v0001/")

(def game-details-url "http://store.steampowered.com/api/appdetails/?cc=us&appids=")

(defstate games-list
  :start (get-in (json/parse-stream (io/reader games-list-url) true)
                 [:applist :apps :app]))

(defn get-game-details [appid]
  (-> (io/reader (str game-details-url appid))
      (json/parse-stream true)
      (get-in [(keyword (str appid)) :data])
      (select-keys [:name :release_date :header_image :price_overview])
      (assoc :appid appid)))