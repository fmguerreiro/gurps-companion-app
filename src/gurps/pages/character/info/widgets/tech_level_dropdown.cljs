(ns gurps.pages.character.info.widgets.tech-level-dropdown
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.utils.i18n :as i18n]))

(def lvl->label
  {0 {:value "stone-age"
      :label (i18n/label :t/stone-age)
      :description (i18n/label :t/stone-age-desc)}
   1 {:value "bronze-age"
      :label (i18n/label :t/bronze-age)
      :description (i18n/label :t/bronze-age-desc)}
   2 {:value "iron-age"
      :label (i18n/label :t/iron-age)
      :description (i18n/label :t/iron-age-desc)}
   3 {:value "medieval"
      :label (i18n/label :t/medieval)
      :description (i18n/label :t/medieval-desc)}
   4 {:value "renaissance"
      :label (i18n/label :t/renaissance)
      :description (i18n/label :t/renaissance-desc)}
   5 {:value "industrial-revolution"
      :label (i18n/label :t/industrial-revolution)
      :description (i18n/label :t/industrial-revolution-desc)}
   6 {:value "world-wars"
      :label (i18n/label :t/world-wars)
      :description (i18n/label :t/world-wars-desc)}
   7 {:value "modern"
      :label (i18n/label :t/modern)
      :description (i18n/label :t/modern-desc)}
   8 {:value "spacefaring"
      :label (i18n/label :t/spacefaring)
      :description (i18n/label :t/spacefaring-desc)}
   9 {:value "starfaring"
      :label (i18n/label :t/starfaring)
      :description (i18n/label :t/starfaring-desc)}})

(def ^:private data
  (map #(merge (val %) {:description (str (inc (key %)) " - " (:description (val %)))}) lvl->label))

(def val->lvl (reduce (fn [acc kv] (assoc acc (:value (val kv)) (key kv))) {} lvl->label))

(defn tech-level-dropdown []
  (let [val (some-> (rf/subscribe [:world/tech-level]) deref)]
    [:> view {:style (tw "flex flex-row gap-2")}
     [:> text {:style (tw "capitalize font-bold my-auto")} (i18n/label :t/tech-level)]

     [dropdown {:style (tw "flex-1")
                :placeholder-style (tw "text-center text-xs")
                :selected-style (tw "text-center")
                :on-change #(rf/dispatch [:tech-level/update (get-in val->lvl [%])])
                :placeholder (get-in lvl->label [val :description])
                :data data}]]))

(rf/reg-sub
 :world/tech-level
 (fn [db]
   (get-in db [:world :tech-level])))

(rf/reg-event-fx
 :tech-level/update
 (fn [{:keys [db]} [_ v]]
   (let [new-db (assoc-in db [:world :tech-level] v)]
     {:db                        new-db
      :effects.async-storage/set {:k     :world/tech-level
                                  :value v}})))
