(ns gurps.pages.character.widgets.attributes
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.reified-attribute :refer [reified-attribute]]
            [gurps.pages.character.widgets.reified-secondary-attribute :refer [reified-secondary-attribute]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn attribute-group []
  [:> view {:style (tw "flex flex-row gap-0 mt-2")} ;; NOTE: mt-2 to account for out-of-bounds "current" label

   [:> view {:style (tw "flex flex-col")}
    [reified-attribute {:attr :str}]
    [reified-attribute {:attr :dex}]
    [reified-attribute {:attr :int}]
    [reified-attribute {:attr :ht}]]

   [:> view {:style (tw "flex flex-col")}
    [reified-secondary-attribute {:attr :hp,   :based-on :str, :has-current? true}]
    [reified-secondary-attribute {:attr :will, :based-on :int}]
    [reified-secondary-attribute {:attr :per,  :based-on :int}]
    [reified-secondary-attribute {:attr :fp,   :based-on :ht,  :has-current? true}]]])

(def attrs [:attributes/str
            :attribute-costs/str
            :attributes/dex
            :attribute-costs/dex
            :attributes/int
            :attribute-costs/int
            :attributes/ht
            :attribute-costs/ht
            :attribute-costs/hp
            :attribute-current/hp
            :attribute-costs/will
            :attribute-costs/per
            :attribute-costs/fp])
(doseq [attr attrs]
  (rf/reg-sub
   attr
   (fn [db _]
     (get-in db [(keyword (namespace attr)) (keyword (name attr))] 0))))

(rf/reg-event-fx
 :attrs/update
 (fn [{:keys [db]} [_ k v]]
   (info "update attr" k v)
   (let [old-val (get-in db [(keyword (namespace k)) (keyword (name k))])
         diff    (- v old-val)]
     {:db (-> db
              (update-in [:profile :unspent-points] #(- % diff))
              (assoc-in [(keyword (namespace k)) (keyword (name k))] v))

      ;; TODO: for unspent-points, should just call profile/update :unspent-points (- v diff)
      :effects.async-storage/set-multiple {:items [{:k     :profile/unspent-points
                                                    :value (- (get-in db [:profile :unspent-points] 0) diff)}
                                                   {:k     k
                                                    :value v}]}})))

(def currents [:attribute-current/hp :attribute-current/fp])
(doseq [current currents]
  (rf/reg-sub
   current
   (fn [db _]
     (get-in db [(keyword (namespace current)) (keyword (name current))]))))

(rf/reg-event-fx
 :attribute-current/update
 (fn [{:keys [db]} [_ k v]]
   (info "attribute-current/update" k v)
   {:db (assoc-in db [(keyword (namespace k)) (keyword (name k))] v)
    :effects.async-storage/set {:k     k
                                :value v}}))
