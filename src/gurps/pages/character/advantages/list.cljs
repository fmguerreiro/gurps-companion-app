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
  [{id :title} expanded?]
  (r/as-element
   [:> button {:onPress #(rf/dispatch [:advantage-list/toggle-section id])}
    [row
     [:> text {:style (tw "capitalize font-bold")} (i18n/label (keyword :t id))]
     [:> text (if expanded? "▲" "▼")]]]))

(defn- item
  [{id :name} visible?]
  (let [name (i18n/label (keyword :t (str "advantage-" id)))
        nav  (rnn/useNavigation)]
    (r/as-element
     (if visible?
       [:<>]
       ;; else
       [:> button {:onPress #(-> nav (.navigate (i18n/label :t/advantage-details) #js {:id id}))}
        [row
         [:> text {:style (tw "capitalize")} name]
         [:> text {:style (tw "capitalize")} ">"]]]))))

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

   (let [advantages        (some-> (rf/subscribe [:advantages]) deref)
         expanded-sections (some-> (rf/subscribe [:advantage-list/expanded]) deref)]
     [section-list
      {:sections sections

       :render-section-header
       (fn [item-info-js]
         (let [item-info       (->clj item-info-js :keywordize-keys true)
               {data :section} item-info
               expanded?       (get-in expanded-sections [(:title data) :expanded?] false)]
           (header data expanded?)))

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
               visible?     (get-in expanded-sections [(:type-1 data) :expanded?] false)]
           (item data visible?)))}])])

;; TODO: probably need to move this to the first advantage-tabbed page
(rf/reg-sub
 :advantages
 (fn [db]
   (get-in db [:advantages] {})))

(rf/reg-sub
 :advantage-list/expanded
 (fn [db]
   (get-in db [:advantage-list] {})))

(rf/reg-event-db
 :advantage-list/toggle-section
 (fn [db [_ advantage]]
   (update-in db [:advantage-list advantage :expanded?] not)))
