;; This page/widget displays a section list of all the skills in the game, grouped by category.
;; Each skill is a button that can be clicked to view the details of that skill and add the skill to the character.

(ns gurps.pages.character.widgets.skill-groups
  (:require [clojure.string :as str]
            [reagent.core :as r]
            [gurps.pages.character.utils.skills :refer [skills grouped-skills categories]]
            [gurps.widgets.base :refer [view text button section-list]]))

(defn- keyword->str
  [keyword]
  (let [namespace (namespace keyword)
        name (name keyword)
        text (if namespace namespace name)]
    (str/replace text #"-" " ")))

;; (defn skill-groups []
;;   [:> view {:className "w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-white"}
;;    (for [category categories]
;;      [:> view {:key (str category "-view")}
;;       [:> text {:key category
;;                 :className "font-bold capitalize"}
;;        (keyword->str category)]
;;       (for [skill (-> skills category keys)]
;;         [:> button {:key (str skill "-btn")
;;                     :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"}
;;          [:> text {:key skill :className "capitalize"}
;;           (keyword->str skill)]])])])

;; (->> skills
;;      (map (fn [x]
;;             {:title (keyword->str (key x))
;;              :data (->> x val)}))
;;      first
;;      :data
;;      )

(defn skill-groups
  []
  (r/with-let [sections (->> grouped-skills
                             (map (fn [x]
                                    {:title (keyword->str (key x))
                                     :data (->> x val keys (map keyword->str))})))]
    [:> section-list
     {:sections sections
      :renderSectionHeader (fn [props]
                             (let [title (-> ^js props .-section .-title)]
                               (r/as-element [:> text {:className "font-bold capitalize bg-white"} title])))
      ;; :keyExtractor (fn [item] (str item "-key"))
      :renderItem (fn [props]
                    (let [item-txt (.-item props)
                          ;; item-txt (-> item keyword->str)
                          ]
                      (r/as-element
                       [:> button {:key (str item-txt "-btn")
                                   :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"
                                   :onClick #(js/console.log item-txt) ;; TODO
                                   }
                        [:> view {:className "flex flex-row justify-between"}
                         [:> text {:className "capitalize"} item-txt]
                         [:> text {:className ""} "0"]]])))}]))
