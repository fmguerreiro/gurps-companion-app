(ns gurps.pages.character.widgets.skill-groups
  (:require [reagent.core :as r]
            [gurps.pages.character.utils.skills :refer [skills categories]]
            [gurps.widgets.base :refer [view text button]]))

(defn- keyword->str
  [keyword]
  (clojure.string/replace (str (name keyword)) #"-" " "))

(defn skill-groups []
  [:> view {:className "w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-white"}
   (for [category categories]
     [:> view {:key (str category "-view")}
      [:> text {:key category
                :className "font-bold capitalize"}
       (keyword->str category)]
      (for [skill (-> skills category keys)]
        [:> button {:key (str skill "-btn")
                    :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"}
         [:> text {:key skill :className "capitalize"}
          (keyword->str skill)]])])])
