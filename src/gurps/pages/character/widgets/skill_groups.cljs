;; This page/widget displays a section list of all the skills in the game, grouped by category.
;; Each skill is a button that can be clicked to view the details of that skill and add the skill to the character.

(ns gurps.pages.character.widgets.skill-groups
  (:require [clojure.string :as str]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills grouped-skills categories difficulties default-skill-lvl]]
            [gurps.widgets.base :refer [view text button section-list]]))

;; NOTE: passing keywords to js functions is a bit tricky, so we convert them to strings first
(defn- key->str
  [key]
  (str (symbol key)))

;; NOTE: then we convert the strings back to keywords when we need to
(defn- str->keyword
  [str]
  (keyword str))

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
  (let [item-txt (.-item props)
        item-key (str->keyword item-txt)
        skill (item-key skills)
        difficulty (i18n/label (keyword "t" ((:diff skill) difficulties)))]
    (r/as-element
     [:> button {:key (str item-txt "-btn")
                 :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"
                 ;; TODO
                 :onClick #(js/console.log item-txt)}
      [:> view {:className "flex flex-row justify-between"}
       [:> text {:className "capitalize"} item-txt]
       [:> view {:className "flex flex-row"}
        [:> text {:className ""} difficulty]
        [:> text (item-key default-lvls)]]]])))

(defn skill-header [props]
  (let [title (-> ^js props .-section .-title str->keyword keyword->title)]
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

;; TODO: this is probably gonna be pretty slow
(rf/reg-sub
 :skills/defaults
 (fn [db]
   (let [skill-keys (keys skills)]
     (js/console.log "default-lvls" (count skill-keys))
     (reduce (fn [acc key] (assoc acc key (default-skill-lvl db key)))
             {}
             skill-keys))))
