;; This page/widget displays a section list of all the skills in the game, grouped by category.
;; Each skill is a button that can be clicked to view the details of that skill and add the skill to the character.

(ns gurps.pages.character.widgets.skill-groups
  (:require [clojure.string :as str]
            [reagent.core :as r]
            [re-frame.core :as rf]
            ["@react-navigation/native" :as rnn]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [str->key key->str]]
            [gurps.pages.character.utils.skills :refer [skills grouped-skills difficulties default-skill-lvl]]
            [gurps.widgets.base :refer [view text button section-list]]))

(defn- keyword->title
  [keyword]
  (let [namespace (namespace keyword)
        name (name keyword)
        text (if namespace namespace name)]
    (str/replace text #"-" " ")))

(defn- vec->js-array [vec]
  (let [arr #js []]
    (doseq [x vec]
      (.push arr x))
    arr))

(defn skill-row [props default-lvls]
  (let [navigation (rnn/useNavigation)
        item-txt (.-item props)
        item-key (str->key item-txt)
        skill (item-key skills)
        difficulty (i18n/label (keyword "t" ((:diff skill) difficulties)))
        needs-specialization? (= "sp" (name item-key))]
    (r/as-element
     [:> button {:key (str item-txt "-btn")
                 :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"
                 :onPress #(-> navigation (.navigate (i18n/label :t/add-skill-specialization) #js {:id item-txt}))}
      [:> view {:className "flex flex-row justify-between"}
       [:> text {:className "capitalize"} (if needs-specialization? (namespace item-key) item-txt)]
       [:> view {:className "flex flex-row"}
        [:> text {:className ""} difficulty]
        [:> text (item-key default-lvls)]]]])))

(defn skill-header [props]
  (let [title (-> ^js props .-section .-title str->key keyword->title)]
    (r/as-element
     [:> text {:className "font-bold capitalize bg-white"} title])))

(defn skill-groups
  []
  (r/with-let [sections (->> grouped-skills
                             (map (fn [x]
                                    #js {:title (-> x key key->str)
                                         :data  (->> x val keys (map key->str) vec->js-array)})))
               default-lvls @(rf/subscribe [:skills/defaults])]
    (r/create-element
     section-list
     #js {:sections (vec->js-array sections)
          :renderSectionHeader skill-header
          :keyExtractor (fn [item] (str item "-key"))
          :renderItem #(skill-row % default-lvls)})))

(rf/reg-sub
 :skills/defaults
 (fn [db]
   (let [skill-keys (keys skills)]
     (reduce (fn [acc key] (assoc acc key (default-skill-lvl db key)))
             {}
             skill-keys))))
