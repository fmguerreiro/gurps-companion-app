(ns gurps.pages.character.items.ranged-weapons-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.base :refer [keyboard-avoiding-view view text]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]))

(defn- row
  [col1 col2 col3 col4 col5 col6 col7]
  [:> view {:style (tw "flex flex-row h-6 gap-2")}
   ;; weapon
   [:> view {:style (tw "w-3/12")} col1]
   ;; damage
   [:> view {:style (tw "w-2/12")} col2]
   ;; acc
   [:> view {:style (tw "w-1/12")} col3]
   ;; range
   [:> view {:style (tw "w-2/12")} col4]
   ;; rof
   [:> view {:style (tw "w-1/12")} col5]
   ;; shots
   [:> view {:style (tw "w-1/12")} col6]
   ;; weight
   [:> view {:style (tw "w-1/12 pr-4")} col7]])

(defn- header
  []
  [row
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/weapon)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/damage)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/acc)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/range)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/rof)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/shots)]
   [:> text {:style (tw "font-bold capitalize")} (first (i18n/label :t/weight))]])

(def empty-weapon {:name "" :weight 0 :dmg 0 :acc 0 :rof 0 :shots 0})

(defn ranged-weapons-page
  []
  (let [weapons (some-> (rf/subscribe [:items/ranged-weapons]) deref)]
    [keyboard-avoiding-view {:behavior :padding, :style (tw "flex-1")}
     [:> view {:style (tw "flex flex-col gap-2 flex-grow bg-white p-2")}

      [header]

      (map-indexed (fn [i {:keys [name dmg acc range rof shots weight]}]
                     ^{:key (str "ranged-" i)}
                     [row
                      [underlined-input {:val name
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :name %] 500)}]
                      [underlined-input {:val dmg
                                         :text-align "center"
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :dmg %] 500)}]
                      [underlined-input {:val acc
                                         :text-align "center"
                                         :input-mode "numeric"
                                         :max-length 2
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :acc (->int %)] 500)}]
                      [underlined-input {:val range
                                         :text-align "center"
                                         :input-mode "numeric"
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :range %] 500)}]
                      [underlined-input {:val rof
                                         :text-align "center"
                                         :input-mode "numeric"
                                         :max-length 3
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :rof (->int %)] 500)}]
                      [underlined-input {:val shots
                                         :text-align "center"
                                         :input-mode "numeric"
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :shots %] 500)}]
                      [underlined-input {:val weight
                                         :text-align "center"
                                         :input-mode "numeric"
                                         :max-length 3
                                         :on-change-text #(debounce-and-dispatch [:items.ranged/update i :weight (->int %)] 500)}]])
                   (conj weapons empty-weapon))]]))

(rf/reg-sub
 :items/ranged-weapons
 (fn [db]
   (get-in db [:items :ranged-weapons] [])))

(rf/reg-event-fx
 :items.ranged/update
 (fn [{:keys [db]} [_ idx k v]]
   (let [weapon (merge (get-in db [:items :ranged-weapons idx] empty-weapon) {k v})
         new-db (update-in db [:items :ranged-weapons] (fnil #(do (assoc-in % [idx] weapon)) [weapon]))]
     {:db new-db
      :effects.async-storage/set {:k     :items/ranged-weapons
                                  :value (get-in new-db [:items :ranged-weapons])}})))
