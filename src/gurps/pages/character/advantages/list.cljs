(ns gurps.pages.character.advantages.list
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->clj ->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.advantages :refer [advantages-by-type]]
            [gurps.widgets.base :refer [view text button section-list]]
            [re-frame.core :as rf]))

(defn- row
  [col1 col2]
  [:> view {:style (tw "bg-white flex flex-row gap-2 p-2")}
   [:> view {:style (tw "flex-3 justify-center items-start")} col1]
   (when col2
     [:> view {:style (tw "flex-1 justify-center items-end")} col2])])

(defn- header
  [{id :title}]
  (r/as-element
   [row
    [:> text {:style (tw "capitalize font-bold")} (i18n/label (keyword :t id))]]))

(defn- item
  [{id :name}]
  (let [name (i18n/label (keyword :t (str "advantage-" id)))]
    (r/as-element
     [row
      [:> text {:style (tw "capitalize")} name]
      ;; TODO: needs to be a button
      [:> text {:style (tw "capitalize")} ">"]])))

;; {:physical [...], :mental [...], ...}
;; => #js [{title: "Physical", data: #js [{name: "Acute Hearing", level: "1", cost: "2"}]}, ...]
(def ^:private sections
  (->> advantages-by-type
       (map (fn [[type advantages]]
              {:title type
               :data advantages}))
       ->js))

(defn advantage-list-page
  []
  [:> view {:style (tw "flex flex-col bg-white flex-1 px-2")}

   (let [advantages (some-> (rf/subscribe [:advantages]) deref)]
     [section-list
      {:sections sections

       :render-section-header
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :section} item-info]
           (header data)))

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
           (item data)))}])])

;; TODO: probably need to move this to the first advantage-tabbed page
(rf/reg-sub
 :advantages
 (fn [db]
   (get-in db [:advantages] {})))
