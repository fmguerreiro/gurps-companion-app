(ns gurps.pages.character.items
  (:require ["expo-status-bar" :refer [StatusBar]]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.base :refer [view text]]
            [gurps.pages.character.items.defenses-section :refer [defenses-section]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]))

(defn row
  [col1 col2 col3 col4]
  [:> view {:style (tw "flex flex-row h-6 gap-2")}
   [:> view {:style (tw "w-3/4 flex flex-row h-6 gap-2")}
    [:> view {:style (tw "w-9/12")} col1]
    [:> view {:style (tw "w-1/12")} col2]
    [:> view {:style (tw "w-2/12")} col3]]
   [:> view {:style (tw "w-1/4 pr-2")} col4]])

(defn header
  []
  [row
   [:> text {:style (tw "font-bold capitalize")} (i18n/label :t/item)]
   [:> text {:style (tw "font-bold uppercase")} (i18n/label :t/dr)]
   [:> text {:style (tw "font-bold capitalize") :numberOfLines 1} (i18n/label :t/weight)]
   [:> text {:style (tw "font-bold capitalize self-end") :numberOfLines 1} (i18n/label :t/location)]])

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

(def empty-item {:name "" :location "bag" :weight 0 :dr nil})

(defn items
  []
  (let [possessions (some-> (rf/subscribe [:items/possessions]) deref)]
    [:> view {:style (tw "flex flex-col gap-1")}
     (map-indexed (fn [i {:keys [name location dr weight]}]
                    ^{:key (str "item-" i)}
                    [row
                     ;; name
                     [underlined-input {:val name
                                        :on-change-text #(debounce-and-dispatch [:items/update :possessions i % location dr weight] 500)}]
                     ;; dr
                     (if (not= location "bag")
                       [underlined-input {:val dr
                                          :input-mode "numeric"
                                          :max-length 2
                                          :text-align "center"
                                          :on-change-text #(debounce-and-dispatch [:items/update :possessions i name location (->int %) weight] 500)}]
                       [:> text ""])
                     ;; weight
                     [underlined-input {:val weight
                                        :input-mode "numeric"
                                        :max-length 3
                                        :text-align "center"
                                        :style (tw "mr-2")
                                        :on-change-text #(debounce-and-dispatch [:items/update :possessions i name location dr (->int %)] 500)}]
                     ;; location
                     [dropdown {:style (tw "flex-1")
                                :placeholder-style (tw "text-right text-xs")
                                :selected-style (tw "text-right")
                                :on-change #(rf/dispatch [:items/update :possessions i name % dr weight])
                                :placeholder (get-in location-val->label [location])
                                :data locations}]])
                  (conj possessions empty-item))]))

(defn character-items-page
  []
  [:> view {:style (tw "flex flex-col bg-white gap-4 flex-grow p-2")}
   [header]

   [items]

   [:> view {:style (tw "mt-2")}
    [defenses-section]]

   [:> StatusBar {:style "auto"}]])

(def ks [:possessions])
(doseq [k ks]
  (rf/reg-sub
   (keyword :items k)
   (fn [db]
     (get-in db [:items k]))))

(rf/reg-event-fx
 :items/update
 (fn [{:keys [db]} [_ k i name location dr weight]]
   (let [new-db (assoc-in db [:items k i] {:name name :location location :dr dr :weight weight})]
     {:db                         new-db
      :effects.async-storage/set {:k :items/possessions
                                  :value (get-in new-db [:items :possessions])}})))
