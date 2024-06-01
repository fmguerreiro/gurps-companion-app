;; This page displays a section list of all the spells in the game, grouped by category.
;; Each spell is a button that can be clicked to view the details of that spell and add it to the character

(ns gurps.pages.character.spells.groups
  (:require [clojure.string :as str]
            [reagent.core :as r]
            ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [str->key key->str]]
            [gurps.pages.character.utils.spells :refer [spells spells-by-college]]
            [gurps.pages.character.utils.skills :refer [skill->txt]]
            [gurps.widgets.base :refer [view text button section-list]]
            [taoensso.timbre :as log]
            [re-frame.core :as rf]))

;; TODO: helper
(defn- keyword->title
  [keyword]
  (let [namespace (namespace keyword)
        name (name keyword)
        text (if namespace namespace name)]
    (str/replace text #"-" " ")))

;; TODO: helper
(defn- vec->js-array [vec]
  (let [arr #js []]
    (doseq [x vec]
      (.push arr x))
    arr))
(defn- row
  [props expanded-colleges]
  (let [navigation (rnn/useNavigation)
        item-txt  (.-name (.-item ^js props))
        college   (.-college (.-item ^js props))
        expanded? (get-in expanded-colleges [college :expanded?] false)
        item-key  (str->key item-txt)]
    (r/as-element
     (if (not expanded?)
       [:<>]

       [:> button {:key (str item-txt "-btn")
                   :style (tw "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white")
                   :onPress #(-> navigation (.navigate (i18n/label :t/spell-details) #js {:id item-txt}))}
        [:> view {:style (tw "flex flex-row justify-between")}
         [:> text {:style (tw "capitalize")}
          (i18n/label (keyword :t (str "spell-" item-txt)))]]]))))

(defn- section-header
  [props expanded-colleges]
  (let [college   (-> ^js props .-section .-title)
        expanded? (get-in expanded-colleges [college :expanded?] false)]
    (r/as-element
     [:> button {:style (tw "h-8 bg-white")
                 :onPress #(rf/dispatch [:college-list/toggle-section college])}
      [:> view {:style (tw "flex flex-row justify-between items-center my-auto")}
       [:> text {:style (tw "font-bold my-auto capitalize")}
        (i18n/label (keyword :t college))]
       [:> text (if expanded? "▲" "▼")]]])))

(defn- get-sections
  [grouped-map]
  (map
   (fn [x]
     (let [college   (-> x key key->str)]
       #js {:title college
            :data (->> x
                       val
                       (map key->str)
                       (map #(do #js {:college college, :name %}))
                       vec->js-array)}))
   grouped-map))

(defn spell-groups
  []
  (let [sections       (get-sections spells-by-college)
        key-extractor  (fn [item] (str (.-name ^js item) "-" (.-college ^js item) "-row"))
        expanded-colleges (some-> (rf/subscribe [:college-list/expanded]) deref)
        render-item    (fn [props] (row props expanded-colleges))
        render-section (fn [props] (section-header props expanded-colleges))]

    (r/create-element
     section-list
     #js {:sections (vec->js-array sections)
          :renderSectionHeader render-section
          :keyExtractor key-extractor
          :renderItem render-item})))

(defn spell-groups-page
  []
  [:> view {:style (tw "flex flex-col bg-white flex-1 px-2")}
   [spell-groups]])

(rf/reg-sub
 :college-list/expanded?
 (fn [db [college]]
   (get-in db [:spell-list college :expanded?] false)))

(rf/reg-sub
 :college-list/expanded
 (fn [db]
   (get-in db [:spell-list] {})))

(rf/reg-event-db
 :college-list/toggle-section
 (fn [db [_ college]]
   (update-in db [:spell-list college :expanded?] not)))
