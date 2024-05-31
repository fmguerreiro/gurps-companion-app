
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
            [taoensso.timbre :as log]))

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

(defn row [props]
  (let [navigation (rnn/useNavigation)
        item-txt (.-name (.-item props))
        item-key (str->key item-txt)]
    (r/as-element
     [:> button {:key (str item-txt "-btn")
                 :style (tw "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white")
                 :onPress #(-> navigation (.navigate (i18n/label :t/add-spell) #js {:id item-txt}))}
      [:> view {:style (tw "flex flex-row justify-between")}
       [:> text {:style (tw "capitalize")}
        (i18n/label (keyword :t (str "spell-" item-txt)))]]])))

(defn header-text
  [props]
  (let [title (-> ^js props .-section .-title)]
    (r/as-element
     [:> view {:style (tw "h-8 bg-white")}
      [:> text {:style (tw "font-bold my-auto capitalize")}
       (i18n/label (keyword :t title))]])))

(defn- get-sections
  [grouped-map]
  (map (fn [x]
         (let [college (-> x key key->str)]
           #js {:title college
                :data (->> x val (map key->str) (map #(do #js {:college college :name %})) vec->js-array)}))
       grouped-map))

(defn spell-groups
  []
  (r/with-let [sections      (get-sections spells-by-college)
               render-item   row
               key-extractor (fn [item] (str (.-name ^js item) "-" (.-college ^js item) "-key"))]
    (r/create-element
     section-list
     #js {:sections (vec->js-array sections)
          :renderSectionHeader header-text
          :keyExtractor key-extractor
          :renderItem render-item})))

(defn spell-groups-page
  []
  [:> view {:style (tw "flex flex-col bg-white px-2")}
   [spell-groups]])
