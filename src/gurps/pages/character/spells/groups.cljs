;; This page displays a section list of all the spells in the game, grouped by category.
;; Each spell is a button that can be clicked to view the details of that spell and add it to the character

(ns gurps.pages.character.spells.groups
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->clj ->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.pages.character.utils.spells :refer [spells-by-college]]
            [gurps.widgets.base :refer [view text button section-list]]
            [re-frame.core :as rf]))

(defn- row
  [item expanded-colleges spells]
  (let [navigation (rnn/useNavigation)
        item-txt   (:name item)
        college    (:college item)
        expanded?  (get-in expanded-colleges [college :expanded?] false)
        item-key   (str->key item-txt)]
    (r/as-element
     (if (not expanded?)
       [:<>]

       [:> button {:key (str item-txt "-btn")
                   :style (tw (str "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white")
                              (when (item-key spells) " bg-green-100"))
                   :onPress #(-> navigation (.navigate (i18n/label :t/spell-details) #js {:id item-txt}))}
        [:> view {:style (tw "flex flex-row justify-between")}
         [:> text {:style (tw "capitalize")}
          (i18n/label (keyword :t (str "spell-" item-txt)))]]]))))

(defn- section-header
  [section expanded-sections]
  (let [college   (:title section)
        expanded? (get-in expanded-sections [college :expanded?] false)]
    (r/as-element
     [:> button {:style (tw "h-10 bg-white")
                 :onPress #(rf/dispatch [:college-list/toggle-section college])}
      [:> view {:style (tw "flex flex-row justify-between items-center my-auto")}
       [:> text {:style (tw "font-bold my-auto capitalize")}
        (i18n/label (keyword :t college))]
       [:> text (if expanded? "▲" "▼")]]])))

(def ^:private sections
  (->> spells-by-college
       (map (fn [x]
              {:title (key x)
               :data (map #(do {:college (key x), :name %}) (val x))}))
       ->js))

(defn spell-groups-page
  []
  (let [expanded-sections (some-> (rf/subscribe [:college-list/expanded]) deref)
        spells            (some-> (rf/subscribe [:spells]) deref)]
    [:> view {:style (tw "flex flex-col bg-white flex-1 px-2")}
     [section-list
      {:sections sections

       :render-section-header
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :section} item-info]
           (section-header data expanded-sections)))

       :key-extractor
       (fn [item-js idx]
         (-> item-js
             (->clj :keywordize-keys true)
             :name
             (str "-" idx "-row")))

       :render-item
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :item} item-info]
           (row data expanded-sections spells)))}]]))

(rf/reg-sub
 :college-list/expanded
 (fn [db]
   (get-in db [:spell-list] {})))

(rf/reg-event-db
 :college-list/toggle-section
 (fn [db [_ college]]
   (update-in db [:spell-list college :expanded?] not)))
