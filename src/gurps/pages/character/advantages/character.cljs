(ns gurps.pages.character.advantages.character
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [cljs-bean.core :refer [->js ->clj]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.base :refer [view flat-list text button]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.pages.character.utils.advantages :refer [advantages-by-name]]
            [gurps.pages.character.utils.disadvantages :refer [disadvantages-by-name]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int singularize-key index-of]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]))

(defn- row
  [col1 col2 col3]
  [:> view {:style (tw "flex flex-row h-6 gap-2 mx-2 my-1")}
   [:> view {:style (tw "flex-3 justify-center items-start")} col1]
   [:> view {:style (tw "flex-1 justify-center items-center")} col2]
   [:> view {:style (tw "flex-1 min-w-8 justify-center items-end")} col3]])

(defn- header
  []
  (r/as-element
   [row
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/name)]
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/level)]
    [:> text {:style (tw "capitalize mr-1 font-bold")} (i18n/label :t/cost)]]))

(defn- item
  [{:keys [id lvl cost], :or {lvl 1}} nav type]
  (let [name      (i18n/label (keyword :t (str (singularize-key type) "-" id)))
        by-name   (if (= type :advantages) advantages-by-name disadvantages-by-name)
        cost-info (get-in by-name [(keyword id) :cost])]
    (r/as-element
     [row
      [:> button {:onPress #(-> nav (.push (i18n/label (keyword :t (str (singularize-key type) "-details")))
                                           #js {:id id}))}
       [:> text {:style (tw "capitalize")} name]]

      ;; lvl
      (if (= cost-info :variable)
        [bracketed-numeric-input {:val (->int lvl)
                                  :on-change-text
                                  #(debounce-and-dispatch [(keyword type :update) :lvl (keyword id) (->int %)] 500)}]
        [:> text {:style (tw "text-xl")} lvl])

      ;; cost
      (cond (= cost-info :variable)
            [bracketed-numeric-input {:val cost
                                      :on-change-text
                                      #(debounce-and-dispatch [(keyword type :update) :cost (keyword id) (->int %)] 500)}]
            (number? cost-info) [:> text {:style (tw "text-xl mr-2")} cost]
            (coll?   cost-info) [dropdown {:data        (->> cost-info (map #(do {:label %, :value %})))
                                           :style       (tw "min-w-12 flex-1")
                                           :list-style  (tw "min-w-16 left-82")
                                           :placeholder-style (tw "text-right")
                                           :selected-style    (tw "text-right")
                                           :val         cost
                                           :placeholder cost
                                           :on-change   #(do
                                                           (rf/dispatch [(keyword type :update) :cost (keyword id) (->int %)])
                                                           (rf/dispatch [(keyword type :update) :lvl  (keyword id) (inc (index-of (->int %) cost-info))]))}])])))

(defn character-advantages-page
  [type]
  (let [nav        (rnn/useNavigation)
        advantages (some-> (rf/subscribe [type]) deref)]
    [:> view {:style (tw "bg-white flex flex-col grow")}

     [flat-list
      {:data (->> advantages (map #(merge (val %) {:id (key %)})) ->js)

       :key-extractor
       (fn [item]
         (:id (->clj item :keywordize-keys true)))

       :render-item
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :item} item-info]
           (item data nav type)))

       :ListHeaderComponent header}]

     [:> view {:style (tw "absolute bottom-4 right-4")}
      [add-button {:on-click
                   #(-> nav
                        (.push (i18n/label (keyword :t (str (singularize-key type) "-list")))))}]]]))
