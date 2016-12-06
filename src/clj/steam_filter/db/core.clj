(ns steam-filter.db.core
  (:require [steam-filter.db.interface :as db]
            [steam-filter.db.steam :as api]))

(defn update-games []
  (doseq [game api/games-list]
    (db/upsert-game (api/get-game-details (:appid game)))))
