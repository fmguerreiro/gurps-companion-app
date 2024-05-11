(ns gurps.pages.character.items
  (:require ["expo-status-bar" :refer [StatusBar]]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.base :refer [view text]]
            [taoensso.timbre :as log]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]))

(defn row
  [col1 col2]
  [:> view {:style (tw "flex flex-row h-5 gap-2")}
   [:> view {:style (tw "w-3/4")} col1]
   [:> view {:style (tw "w-1/4")} col2]])

(defn header
  []
  [row
   [:> text {:style (tw "font-bold capitalize")} (i18n/label :t/item)]
   [:> text {:style (tw "font-bold capitalize self-end")} (i18n/label :t/location)]])

(def locations
  [{:value "head" :label (i18n/label :t/head)}
   {:value "torso" :label (i18n/label :t/torso)}
   {:value "arm" :label (i18n/label :t/arm)}
   {:value "hand" :label (i18n/label :t/hand)}
   {:value "leg" :label (i18n/label :t/leg)}
   {:value "foot" :label (i18n/label :t/foot)}
   {:value "bag" :label (i18n/label :t/bag)}])

(def location-val->label
  (zipmap (map :value locations) (map :label locations)))

(def empty-item {:name "" :location "bag" :cost 0 :weight 0})

(defn items
  []
  (let [possessions (some-> (rf/subscribe [:items/possessions]) deref)]
    [:> view {:style (tw "flex flex-col gap-1")}
     (map-indexed (fn [i {:keys [name location]}]
                    ^{:key (str "item-" i)}
                    [row
                     [underlined-input {:val name
                                        :on-change-text #(debounce-and-dispatch [:items/update :possessions i % location] 500)}]
                     [dropdown {:style (tw "flex-1")
                                :placeholder-style (tw "text-right text-xs")
                                :selected-style (tw "text-right")
                                :on-change #(rf/dispatch [:items/update :possessions i name %])
                                :placeholder (get-in location-val->label [location])
                                :data locations}]])
                  (conj possessions empty-item))]))

(defn character-items-page
  []
  [:> view {:style (tw "flex flex-col bg-white flex-grow p-2")}
   [:> text {:style (tw "font-bold text-center uppercase")} (i18n/label :t/armor-possessions)]

   [header]

   [items]

   [:> StatusBar {:style "auto"}]])

(def ks [:possessions])
(doseq [k ks]
  (rf/reg-sub
   (keyword :items k)
   (fn [db]
     (get-in db [:items k]))))

(rf/reg-event-fx
 :items/update
 (fn [{:keys [db]} [_ k i name location]]
   (let [new-db (assoc-in db [:items k i] {:name name :location location})]
     {:db                         new-db
      :effects.async-storage/set {:k :items/possessions
                                  :value (get-in new-db [:items :possessions])}})))
