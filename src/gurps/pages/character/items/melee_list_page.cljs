(ns gurps.pages.character.items.melee-list-page
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->clj ->js]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.widgets.weapon-table :refer [weapons-by-skill]]
            [gurps.widgets.base :refer [view text button section-list]]
            [clojure.string :as str]))

(defn- row
  [col1 col2]
  [:> view {:style (tw "flex flex-row gap-2 p-2 bg-inherit")}
   [:> view {:style (tw "flex-3 justify-center items-start")} col1]
   (when col2
     [:> view {:style (tw "flex-1 justify-center items-end")} col2])])

(defn- header
  [{title :title}]
  (r/as-element
   [:> button {:style   (tw "bg-white")
               :onPress #()}
    [row
     [:> text {:style (tw "font-bold")} title]
     [:<>]]]))

(defn- item
  [{id :id group :skill} owned?]
  (let [name  (i18n/label (keyword :t id))
        nav   (rnn/useNavigation)]
    (r/as-element
     [:> button {:style (tw (if owned? "bg-green-100" ""))
                 :onPress #(do
                             (rf/dispatch [:items.melee/add (keyword id) (if (coll? group) (map keyword group) (keyword group))])
                             (-> nav (.navigate (i18n/label (keyword :t/melee-weapons-owned)))))}
      [row
       [:> text name]
       [:> text {:style (tw "font-bold")} "+"]]])))

(defn- header-title
  [k]
  (let [k'     (str/replace (str (symbol k)) #"-\d$" "")
        skill? (i18n/has-label? (keyword (str "skill-" k')))]
    (i18n/label (keyword :t (str (if skill? "skill-" "attr-") k')))))

(def ^:private sections
  (->> weapons-by-skill
       (map (fn [[skill weapons]]
              {:title (->> skill list flatten (map header-title) (str/join ", "))
               :data weapons}))
       ->js))

(defn melee-list-page
  []
  (let [weapons (some->> (rf/subscribe [:items/melee-weapons]) deref (group-by :skill))
        weapons-by-skill-and-id (some->> weapons (map (fn [[k v]] [k (group-by :id v)])) (into {}))]

    [:> view {:style (tw "flex flex-col bg-white flex-1 px-2")}
     [section-list
      {:sections sections

       :render-section-header
       (fn [item-info-js]
         (let [item-info       (->clj item-info-js :keywordize-keys true)
               {data :section} item-info]
           (header data)))

       :key-extractor
       (fn [item-js idx]
         (-> item-js
             (->clj :keywordize-keys true)
             :id
             (str "-" idx "-row")))

       :render-item
       (fn [item-info-js]
         (let [item-info    (->clj item-info-js :keywordize-keys true)
               {data :item} item-info
               owned?       (not (nil? (get-in weapons-by-skill-and-id [(keyword (:skill data)) (keyword (:id data))])))]
           (item data owned?)))}]]))

(rf/reg-event-fx
 :items.melee/add
 (fn [{:keys [db]} [_ id skill]]
   (let [weapon (first (filter #(= id (:id %)) (get weapons-by-skill skill)))
         i      (count (get-in db [:items :melee-weapons] []))
         new-db (update-in db [:items :melee-weapons] (fnil #(do (assoc-in % [i] weapon)) [weapon]))]
     {:db new-db
      :effects.async-storage/set {:k     :items/melee-weapons
                                  :value (get-in new-db [:items :melee-weapons])}})))
