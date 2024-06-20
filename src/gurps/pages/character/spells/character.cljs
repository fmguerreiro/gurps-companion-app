(ns gurps.pages.character.spells.character
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [cljs-bean.core :refer [->js ->clj]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.base :refer [view flat-list scroll-view text button]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.utils.skills :refer [lvl-with-difficulty lvl-with-cost]]
            [gurps.pages.character.utils.spells :refer [vh-spells]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]))
;; TODO
(defn debug
  [d]
  (println "DEBUG" d)
  d)

(defn- row
  [col1 col2 col3]
  [:> view {:style (tw "flex flex-row h-6 gap-2 mx-2 my-1")}
   [:> view {:style (tw "flex-3 justify-center items-start")} col1]
   [:> view {:style (tw "flex-1 justify-center items-center")} col2]
   [:> view {:style (tw "flex-1 justify-center items-end")} col3]])

(defn- header
  []
  (r/as-element
   [row
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/name)]
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/level)]
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/cost)]]))

(defn- item
  [{:keys [id lvl cost]}]
  (let [name (i18n/label (keyword :t (str "spell-" id)))]
    (r/as-element
     [row
      [:> text {:style (tw "capitalize")} name] ;; TODO: make clickable to go to spell details!
      [:> text {:style (tw "capitalize")} lvl]
      [bracketed-numeric-input {:val cost
                                :on-change-text
                                #(debounce-and-dispatch [:spells/update-cost (keyword id) (->int %)] 500)}]])))

;; TODO: add a custom empty spell at bottom for the user to input whatever they want
(defn character-spells-page
  []
  (let [nav    (rnn/useNavigation)
        spells (some-> (rf/subscribe [:spells]) deref)]
    [:> view {:style (tw "bg-white flex flex-col grow")}

     [flat-list
      {:data (->> spells (map #(merge (val %) {:id (key %)})) ->js)

       :key-extractor
       (fn [item]
         (:id (->clj item :keywordize-keys true)))

       :render-item
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :item} item-info]
           (item data)))

       :ListHeaderComponent header}]

     [:> view {:style (tw "absolute bottom-4 right-4")}
      [add-button {:on-click #(-> nav (.push (i18n/label :t/spells)))}]]]))

(defn spell-lvl
  [spell-k lvl cost]
  (lvl-with-cost
   (lvl-with-difficulty lvl (if (spell-k vh-spells) :vh :h))
   cost))

;; TODO: there is also "power investiture" for clerical spells (use that lvl instead of magery for clerical-type spells)
(rf/reg-sub
 :spells
 :<- [:spell-costs]
 :<- [:advantages]
 :<- [:attributes/int]
 (fn [[spell-costs advantages int]]
   (let [{mag :magery, :or {mag 0}} advantages
         lvl (fn [k cost] (spell-lvl k (+ mag int) cost))]
     (reduce (fn [acc [k {cost :cost}]]
               (update-in acc [k] merge {:lvl (lvl k cost) :cost cost}))
             {}
             (filter #(some? (:cost (val %))) spell-costs)))))

(rf/reg-sub
 :spell-costs
 (fn [db]
   (get-in db [:spell-costs] {})))

(rf/reg-event-fx
 :spells/update-cost
 (fn [{db :db} [_ id v]]
   (let [new-db (assoc-in db [:spell-costs id :cost] v)]
     {:db new-db
      :effects.async-storage/set {:k     :spell-costs
                                  :value (get-in new-db [:spell-costs])}})))
