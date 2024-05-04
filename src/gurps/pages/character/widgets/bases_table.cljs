(ns gurps.pages.character.widgets.bases-table
  (:require [taoensso.timbre :refer [info]]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.base-text :refer [base-text]]
            [gurps.pages.character.utils.damage-table :refer [damage-table]]
            ;; NOTE: referenced because of events registered there we depend on, this is kinda jank, need to refactor so we dont need to do this
            [gurps.pages.character.widgets.encumbrance-table]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]))

(defn bases-table
  []
  [:> view {:style (tw "flex flex-col gap-2")}

   [:> view {:style (tw "flex flex-row gap-2 items-stretch")}
    [base-text {:attr :basic-lift}]
    [base-text {:attr :damage-thrust}]
    [base-text {:attr :damage-swing}]]

   [:> view {:style (tw "flex flex-row gap-2")}
    [base-text {:attr :basic-speed, :upgradable? true}]
    [base-text {:attr :basic-move,  :upgradable? true}]]])

(def attrs [:basic-move
            :basic-speed])
(doseq [attr attrs]
  (rf/reg-sub
   (keyword :attribute-costs attr)
   (fn [db _]
     (get-in db [:attribute-costs attr] 0))))

(rf/reg-event-fx
 :attribute-costs/update
 (fn [{:keys [db]} [_ k v]]
   {:db (assoc-in db [:attribute-costs k] v)
    :effects.async-storage/set {:k     (keyword :attribute-costs k)
                                :value v}}))

(rf/reg-sub
 :attributes/basic-speed
 :<- [:attributes/ht]
 :<- [:attributes/dex]
 (fn [[ht dx]]
   (/ (+ ht dx) 4)))

(rf/reg-sub
 :attributes/damage-thrust
 :<- [:attributes/str]
 (fn [str]
   (get-in damage-table [str :sw])))

(rf/reg-sub
 :attributes/damage-swing
 :<- [:attributes/str]
 (fn [str]
   (get-in damage-table [str :thr])))
