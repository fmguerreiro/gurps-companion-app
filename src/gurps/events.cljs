(ns gurps.events
  (:require
   [gurps.events.profile]
   [react-native.async-storage :as async-storage]
   [re-frame.core :as rf]
   [gurps.db :as db :refer [app-db]]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(rf/reg-event-fx
 :initialize-storage
 (fn [{:keys [db]} [_]]
   {:db db
    :effects.async-storage/get {:keys [:profile/name
                                       :profile/player
                                       :t/attr-strength
                                       :t/attr-strength-cost
                                       :t/attr-dexterity
                                       :t/attr-dexterity-cost
                                       :t/attr-intelligence
                                       :t/attr-intelligence-cost
                                       :t/attr-health
                                       :t/attr-health-cost
                                       :t/attr-hitpoints
                                       :t/attr-hitpoints-cost
                                       :t/attr-will
                                       :t/attr-will-cost
                                       :t/attr-perception
                                       :t/attr-perception-cost
                                       :t/attr-fatigue
                                       :t/attr-fatigue-cost
                                       :t/attr-hitpoints-current
                                       :t/attr-fatigue-current
                                       :t/basic-move-cost
                                       :t/basic-speed-cost
                                       ] ;; TODO: add more keys/re-write this to be less verbose
                                :cb #(rf/dispatch [:initialize-storage/set %])}}))

(rf/reg-event-db
 :initialize-storage/set
 (fn [db [_ res]]
   (merge db res)))

(rf/reg-event-db
 :inc-counter
 (fn [db [_ _]]
   (update db :counter inc)))

(rf/reg-event-db
 :navigation/set-root-state
 (fn [db [_ navigation-root-state]]
   (assoc-in db [:navigation :root-state] navigation-root-state)))
