(ns gurps.pages.character.advantages.groups
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            ["@expo/vector-icons/MaterialCommunityIcons" :default icon]
            [cljs-bean.core :refer [->clj ->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [singularize-key]]
            [gurps.pages.character.utils.advantages :refer [advantages-by-name advantages-by-type]]
            [gurps.pages.character.utils.disadvantages :refer [disadvantages-by-name disadvantages-by-type]]
            [gurps.widgets.base :refer [view text button section-list]]
            [re-frame.core :as rf]))

(defn- row
  [col1 col2]
  [:> view {:style (tw "flex flex-row gap-2 p-2 bg-inherit")}
   [:> view {:style (tw "flex-3 justify-center items-start")} col1]
   (when col2
     [:> view {:style (tw "flex-1 justify-center items-end")} col2])])

(defn- header
  [{id :title} expanded? type]
  (r/as-element
   [:> button {:style   (tw "bg-white")
               :onPress #(rf/dispatch [(keyword (str (singularize-key type) "-list") :toggle-section) id])}
    [row
     [:> text {:style (tw "capitalize font-bold")} (i18n/label (keyword :t id))]
     [:> text (if expanded? "▲" "▼")]]]))

(defn- item
  [{id :name, type :type-2} visible? owned? adv-type]
  (let [name  (i18n/label (keyword :t (str (singularize-key adv-type) "-" id)))
        icon' (if (= :supernatural (keyword type)) "lightning-bolt" "alien")
        nav   (rnn/useNavigation)]
    (r/as-element
     (if (not visible?)
       [:<>]
       ;; visible
       [:> button {:style #js [(tw "w-full px-4 font-medium text-left rtl:text-right border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"),
                               (tw (if owned? "bg-green-100" ""))]
                   :onPress #(-> nav
                                 (.navigate
                                  (i18n/label (keyword :t (str (singularize-key adv-type) "-details")))
                                  #js {:id id}))}
        [row
         [:> view {:style (tw "flex flex-row flex-grow items-center gap-1")}
          [:> text name]
          (when (not= :mundane (keyword type))
            [:> icon {:name icon' :size 20 :color (tw "text-black")}])]
         [:> text {:style (tw "capitalize")} ">"]]]))))

;; {:physical [...], :mental [...], ...}
;; => #js [{title: "Physical", data: #js [{name: "Acute Hearing", level: "1", cost: "2"}]}, ...]
(defn- sections
  [type]
  (let [by-type (if (= type :advantages) advantages-by-type disadvantages-by-type)]
    (->> by-type
         (map (fn [[type advantages]]
                {:title type
                 :data advantages}))
         ->js)))

(defn advantage-groups-page
  [type]
  (let [advantages        (some-> (rf/subscribe [type]) deref)
        expanded-sections (some-> (rf/subscribe [(keyword (str (singularize-key type) "-list") :expanded)]) deref)
        by-name           (if (= type :advantages) advantages-by-name disadvantages-by-name)]
    [:> view {:style (tw "flex flex-col bg-white flex-1 px-2")}
     [section-list
      {:sections (sections type)

       :render-section-header
       (fn [item-info-js]
         (let [item-info       (->clj item-info-js :keywordize-keys true)
               {data :section} item-info
               expanded?       (get-in expanded-sections [(-> data :title keyword) :expanded?] false)]
           (header data expanded? type)))

       :key-extractor
       (fn [item-js idx]
         (-> item-js
             (->clj :keywordize-keys true)
             :name
             (str "-" idx "-row")))

       :render-item
       (fn [item-info-js]
         (let [item-info    (->clj item-info-js :keywordize-keys true)
               {data :item} item-info
               visible?     (get-in expanded-sections [(:type-1 data) :expanded?] false)
               owned?       (contains? advantages (keyword (:name data)))
               item'        (merge ((keyword (:name data)) by-name) data)]
           (item item' visible? owned? type)))}]]))
