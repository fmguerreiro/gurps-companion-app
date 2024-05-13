(ns gurps.pages.character.items
  (:require ["expo-status-bar" :refer [StatusBar]]
            ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            ["@expo/vector-icons/MaterialCommunityIcons" :default icon]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.pages.character.items.defenses-section :refer [defenses-section]]
            [taoensso.timbre :as log]
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
   [:> text {:style (tw "font-bold capitalize")} (i18n/label :t/weight)]
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
                                        :max-length 2
                                        :text-align "center"
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
  (when-let [navigation (rnn/useNavigation)]
    [:> view {:style (tw "flex flex-col bg-white gap-4 flex-grow p-2")}
     [:> text {:style (tw "font-bold text-center uppercase")} (i18n/label :t/armor-possessions)]

     [header]

     [items]

     [:> view {:style (tw "mt-2")}
      [defenses-section]]

     [:> button {:style (tw "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white")
                 :onPress (fn [] (-> navigation (.navigate (i18n/label :t/melee-weapons))))}
      [:> icon {:name "sword" :size 20}]]

     [:> StatusBar {:style "auto"}]]))

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
