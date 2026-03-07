(ns app.db
  (:require [cljs.spec.alpha :as s]))

(s/def ::counter number?)
(s/def ::root-state any?)
(s/def ::navigation (s/keys :req-un [::root-state]))

(s/def ::db
  (s/keys :req-un [::counter ::navigation]))

(defonce app-db
  {:counter 0
   :navigation {:root-state #js {}}})
