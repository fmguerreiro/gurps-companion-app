(ns gurps.pages.character.widgets.attributes
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.reified-attribute :refer [reified-attribute]]
            [gurps.pages.character.widgets.reified-secondary-attribute :refer [reified-secondary-attribute]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn attribute-group []
  [:> view {:style (tw "flex flex-row gap-0")}

   [:> view {:style (tw "flex flex-col")}
    [reified-attribute {:attr :str}]
    [reified-attribute {:attr :dex}]
    [reified-attribute {:attr :int}]
    [reified-attribute {:attr :ht}]]

   [:> view {:style (tw "flex flex-col")}
    [reified-secondary-attribute {:attr :hp :based-on :str :has-current? true}]
    [reified-secondary-attribute {:attr :will :based-on :int}]
    [reified-secondary-attribute {:attr :per :based-on :int}]
    [reified-secondary-attribute {:attr :fp :based-on :ht :has-current? true}]]])

(def attrs [:attributes/str
            :attribute-costs/str
            :attributes/dex
            :attribute-costs/dex
            :attributes/int
            :attribute-costs/int
            :attributes/ht
            :attribute-costs/ht
            :attribute-costs/hp
            :attributes/hp-current
            :attribute-costs/will
            :attribute-costs/per
            :attribute-costs/fp
            :attributes/fp-current])
(doseq [attr attrs]
  (rf/reg-sub
   attr
   (fn [db _]
     (get-in db [(keyword (namespace attr)) (keyword (name attr))] 0))))

;; (rf/reg-event-db
;;  :attrs/update
;;  (fn [db [_ k v]]
;;    (info "update attr" k v)
;;    (let [old-val (get-in db [(keyword (namespace k)) (keyword (name k))])
;;          diff    (- v old-val)]
;;      (-> db
;;          (update-in [:profile :unspent-points] #(- % diff))
;;          (assoc-in [(keyword (namespace k)) (keyword (name k))] v)))))

(rf/reg-event-fx
 :attrs/update
 (fn [{:keys [db]} [_ k v]]
   (info "update attr" k v)
   (let [old-val (get-in db [(keyword (namespace k)) (keyword (name k))])
         diff    (- v old-val)]
     {:db (-> db
              (update-in [:profile :unspent-points] #(- % diff))
              (assoc-in [(keyword (namespace k)) (keyword (name k))] v))

      :effects.async-storage/set {:k     :profile/unspent-points
                                  :value (- (get-in db [:profile :unspent-points] 0) diff)}}))) ;; TODO: should just call profile/update :unspent-points (- v diff)
