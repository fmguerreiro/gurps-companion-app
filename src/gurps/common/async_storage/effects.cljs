(ns gurps.common.async-storage.effects
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [react-native.async-storage :as async-storage]))
(rf/reg-fx
 :effects.async-storage/set
 (fn [{k :k value :value}]
   (info "effects.async-storage/set" k value)
   (async-storage/set-item! k value)))

(rf/reg-fx
 :effects.async-storage/set-multiple
 (fn [{items :items}]
   (info "effects.async-storage/set-multiple" items)
   (doseq [{k :k value :value} items]
     (async-storage/set-item! k value))))

(rf/reg-fx
 :effects.async-storage/set-factory
 (async-storage/set-item-factory))

(rf/reg-fx
 :effects.async-storage/get
 (fn [{ks :keys cb :cb}]
   (async-storage/get-items ks cb)))
