(ns gurps.pages.character.widgets.attributes
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.reified-attribute :refer [reified-attribute]]
            [gurps.pages.character.widgets.reified-secondary-attribute :refer [reified-secondary-attribute]]))

(defn attribute-group []
  [:> view {:className "flex flex-row gap-0"}

   [:> view {:className "flex flex-col"}
    [reified-attribute {:attr :str}]
    [reified-attribute {:attr :dex}]
    [reified-attribute {:attr :int}]
    [reified-attribute {:attr :ht}]]

   [:> view {:className "flex flex-col"}
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
     (or (get-in db [(keyword (namespace attr)) (keyword (name attr))]) 0))))

(rf/reg-event-db
 :attrs/update
 (fn [db [_ k v]]
   (info "update attr" k v)
   (assoc-in db [(keyword (namespace k)) (keyword (name k))] v)))
