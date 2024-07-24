(ns gurps.pages.character.widgets.attributes
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.reified-attribute :refer [reified-attribute]]
            [gurps.pages.character.widgets.reified-secondary-attribute :refer [reified-secondary-attribute]]
            [gurps.pages.character.widgets.helpers :refer [cost->points]]))

(defn attribute-group []
  [:> view {:style (tw "flex flex-row justify-between mt-1")} ;; NOTE: mt to account for out-of-bounds "current" label

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
            :attributes/dex
            :attributes/int
            :attributes/ht
            :attribute-costs/str
            :attribute-costs/dex
            :attribute-costs/int
            :attribute-costs/ht
            :attribute-costs/hp
            :attribute-costs/will
            :attribute-costs/per
            :attribute-costs/fp
            :attribute-costs/basic-speed])
(doseq [attr attrs]
  (rf/reg-sub
   attr
   (fn [db _]
     (let [namespace (keyword (namespace attr))
           name (keyword (name attr))]
       (get-in db [namespace name] (if (= :attribute-costs namespace) 0 10))))))

(def cost-based-attrs [:attributes/hp :attributes/fp :attributes/per :attributes/will])
(doseq [attr cost-based-attrs]
  (rf/reg-sub
   attr
   (fn [db]
     (let [cost (get-in db [:attribute-costs (keyword (name attr))] 0)
           incr (get-in cost->points [(keyword (name attr)) :incr])]
       (+ 10 (js/Math.floor (/ cost incr)))))))

(rf/reg-event-fx
 :attrs/update
 (fn [{:keys [db]} [_ k v]]
   (let [old-v (get-in db [(keyword (namespace k)) (keyword (name k))])]
     {:db (-> db (assoc-in [(keyword (namespace k)) (keyword (name k))] v))
      :fx [(when (str/includes? (namespace k) "costs") [:dispatch [:profile.update/unspent-points (- v old-v)]])]
      :log/info {:label ":attrs/update" :vals [k v]}
      :effects.async-storage/set {:k k :value v}})))

(def currents [:attribute-current/hp :attribute-current/fp])
(doseq [current currents]
  (rf/reg-sub
   (keyword (str (symbol current) "-stored"))
   (fn [db]
     (get-in db [(keyword (namespace current)) (keyword (name current))] 10)))

  (rf/reg-sub
   current
   :<- [(keyword :attributes (name current))]
   :<- [(keyword (str (symbol current) "-stored"))]
   (fn [[max stored]]
     (or stored max))))

(rf/reg-event-fx
 :attribute-current/update
 (fn [{:keys [db]} [_ k v]]
   {:db (assoc-in db [(keyword (namespace k)) (keyword (name k))] v)
    :log/info {:label "attribute-current/update" :vals [k v]}
    :effects.async-storage/set {:k     k
                                :value v}}))
