;; This page displays a section list of all the skills in the game, grouped by category.
;; Each skill is a button that can be clicked to view the details of that skill and add the skill to the character.

(ns gurps.pages.character.skills.groups
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [str->key key->str]]
            [gurps.pages.character.utils.skills :refer [skills grouped-skills difficulties default-skill-lvl skill->txt]]
            [gurps.widgets.base :refer [view text button section-list-raw]]))

(defn- keyword->title
  [keyword]
  (let [namespace (namespace keyword)
        name (name keyword)
        text (if namespace namespace name)]
    (str/replace text #"-" " ")))

(defn- vec->js-array
  [vec]
  (let [arr #js []]
    (doseq [x vec]
      (.push arr x))
    arr))

(defn item
  [props default-lvls owned-skills]
  (let [navigation (rnn/useNavigation)
        item-txt   (.-item props)
        item-key   (str->key item-txt)
        skill      (item-key skills)
        difficulty (i18n/label (keyword "t" ((:diff skill) difficulties)))
        needs-specialization? (= "sp" (name item-key))
        owned?     (contains? owned-skills item-key)]
    (r/as-element
     [:> button {:key (str item-txt "-btn")
                 :style #js [(tw "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"),
                             (when owned? (tw "bg-green-100"))]
                 :onPress #(-> navigation (.navigate (i18n/label :t/add-skill-specialization) #js {:id item-txt}))}
      [:> view {:style (tw "flex flex-row justify-between")}
       [:> text {:style (tw "capitalize")} (if needs-specialization?
                                             (skill->txt (symbol (namespace item-key)))
                                             (skill->txt item-key))]
       [:> view {:style (tw "flex flex-row gap-1")}
        [:> text {:style (tw "text-left")} difficulty]
        [:> text {:style (tw "text-right")} (item-key default-lvls)]]]])))

(defn section-header
  [props]
  (let [title (-> ^js props .-section .-title str->key keyword->title)]
    (r/as-element
     [:> view {:style (tw "h-8 bg-white")}
      [:> text {:style (tw "font-bold my-auto capitalize")} title]])))

(defn- get-sections
  [grouped-skills]
  (->> grouped-skills
       (map (fn [x]
              #js {:title (-> x key key->str)
                   :data  (->> x val keys (map key->str) vec->js-array)}))))

(rf/reg-sub
 :skills/defaults
 (fn [db]
   (let [skill-keys (keys skills)]
     (reduce (fn [acc key] (assoc acc key (default-skill-lvl db key)))
             {}
             skill-keys))))

(defn skill-groups-page
  []
  [:> view {:style (tw "flex flex-col bg-white px-2")}
   (let [sections     (get-sections grouped-skills)
         default-lvls (some-> (rf/subscribe [:skills/defaults]) deref)
         ;; NOTE: add generic skill when a specialization is owned, so as to highlight it
         owned-skills (some->> (rf/subscribe [:skill-map]) deref
                               (map #(if (namespace %) [% (keyword (namespace %) "sp")] %))
                               flatten
                               (into #{}))
         render-item  #(item % default-lvls owned-skills)]
     (r/create-element
      section-list-raw
      #js {:sections (vec->js-array sections)
           :renderSectionHeader section-header
           :keyExtractor (fn [item idx] (str item "-" idx))
           :renderItem render-item}))])
