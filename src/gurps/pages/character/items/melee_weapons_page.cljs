(ns gurps.pages.character.items.melee-weapons-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [cljs-bean.core :refer [->js ->clj]]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.base :refer [view flat-list button text]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.pages.character.widgets.helpers :refer [generify-key]]
            [gurps.pages.character.utils.skills :refer [grouped-skills]]
            [reagent.core :as r]
            [clojure.string :as str]))

(defn- row
  [col1 col2 col3 col4 col5 col6 col7]
  [:> view {:style (tw "flex flex-row h-6 gap-1")}
   [:> view {:style (tw "items-center justify-center flex-3")} col1]
   [:> view {:style (tw "items-center justify-center flex-1")} col2]
   [:> view {:style (tw "items-center justify-center flex-1")} col3]
   [:> view {:style (tw "items-center justify-center flex-1")} col4]
   [:> view {:style (tw "items-center justify-center flex-1")} col5]
   [:> view {:style (tw "items-center justify-center flex-0.5")} col6]
   [:> view {:style (tw "items-center justify-center flex-0.5")} col7]])

(defn- header
  []
  (r/as-element
   [row
    [:> text {:style (tw "font-bold text-left capitalize")} (i18n/label :t/weapon)]
    [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/dmg)]
    [:> text {:style (tw "font-bold text-xs text-center capitalize")} (i18n/label :t/reach)]
    [:> text {:style (tw "font-bold text-xs text-center capitalize")} (i18n/label :t/parry)]
    [:> text {:style (tw "font-bold text-xs text-center capitalize")} (i18n/label :t/cost)]
    [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/attr-st)]
    [:> text {:style (tw "font-bold text-right capitalize")} (i18n/label :t/wt)]]))

(defn- str-addition
  "1d+2+2 => 1d+4
   1d+2-1 => 1d+1"
  [s]
  (let [dice  (re-seq #"-?\d+d" s)
        dice' (->> dice (map #(str/replace % #"d" "")) (map ->int) (reduce + 0))
        nums  (reduce + 0 (map ->int (re-seq #"-?(?!\d+d)\d+" s)))]
    (str (str dice' "d") (if (pos? nums) "+" "") (when (not= 0 nums) nums))))

;; TODO: a weapons ST caps the damage to 3xST in the damage-table for sw/thr
(defn- get-dmg
  [dmg swg thr]
  (let [dmg' (str (symbol (first (keys dmg))))]
    (-> dmg'
        (str/replace #"sw" swg)
        (str/replace #"thr" thr)
        str-addition)))

(str-addition "1d-2-2d")

(defn- get-dmg-type
  [dmg]
  (let [d       (-> dmg keys first symbol str)
        motion  (str/replace d #"(\+|-).*" "")
        motion' (if (str/blank? motion) "spec" motion)]
    (str "(" motion' ")")))

(defn- number-str?
  [s]
  (re-matches #"^\-?\d+$" s))

;; (get-parry "0u", :staff, {:staff 7})
(defn- get-parry
  "'0u', :staff {:staff 7} => 7u
   '+2', :staff {:staff 7} => 9
   '0no',:staff {:staff 7} => no"
  [parry skill skills]
  (if (str/includes? parry "no")
    "no"
    (let [lvl (get skills skill)]
      (if (and lvl (re-find #"\d+" (str (symbol parry))))
        (let [added-lvl (+ lvl (first (map ->int (filter number-str? (str/split parry #"\+?(-?\d+)")))))]
          (str/replace (str/replace parry #"\d+" (str added-lvl)) #"(\+|-)" ""))
        parry))))

(defn- item-row
  [{:keys [id name dmg reach parry cost st weight skill i]} swg thr parry-skills]
  (let [dmg'     (get-dmg dmg swg thr)
        dmg-type (get-dmg-type dmg)
        name'   (or name (if (i18n/has-label? id) (i18n/label id) id))
        skills (flatten [skill])
        parry'  (->> skills (map #(get-parry parry (keyword %) parry-skills)) (map ->int) (map-indexed vector) (apply max-key second) second)
        parry'' (get-parry parry :skill {:skill parry'})]
    [:> view {:style (tw (if (even? i) "bg-white" "bg-slate-100"))}
     [row
      [:> view {:style (tw "flex flex-row justify-between flex-1 items-center justify-center")}
       [:> text {:style (tw "flex-1 capitalize") :numberOfLines 1} name']
       [:> text {:style (tw "italic")} dmg-type]]
      [:> text {:style (tw "text-center")} dmg']
      [:> text {:style (tw "text-center")} (str/join "-" (map str/upper-case (distinct (re-seq #"[\dc]" reach))))]
      [:> text {:style (tw "text-center uppercase")} parry'']
      [:> text {:style (tw "text-center")} (str cost)]
      [:> text {:style (tw "text-center")} (str st)]
      [:> text {:style (tw "text-right")} (str weight)]]]))

(defn- item
  [{:keys [dmg reach parry], :as data} swg thr parry-skills nav]
  (r/as-element
   (map-indexed
    (fn [i d]
      (let [cost   (if (= 0 i) (:cost data) "")
            st     (if (= 0 i) (:st data) "")
            weight (if (= 0 i) (:weight data) "")
            id     (if (= 0 i) (:id data) "")]
        ^{:key (str "item-" (:id data) "-" i)}
        [:> button {:onPress #(-> nav (.push (i18n/label :t/melee-weapons-edit) (->js {:id (:id data)})))}
         [item-row
          (merge data
                 {:i i, :dmg d, :reach (get reach i (last reach)), :parry (get parry i (last parry))}
                 {:cost cost, :st st, :weight weight, :id id})
          swg
          thr
          parry-skills]]))

    dmg)))

(defn melee-weapons-page
  []
  (let [nav     (rnn/useNavigation)
        weapons (some-> (rf/subscribe [:items/melee-weapons]) deref)
        swg     (some-> (rf/subscribe [:attributes/damage-swing])  deref)
        thr     (some-> (rf/subscribe [:attributes/damage-thrust]) deref)
        parry-skills (some-> (rf/subscribe [:defenses/parries]) deref)]
    [:> view {:style (tw "bg-white flex flex-col grow p-2")}

     [flat-list
      {:data (->js weapons)

       :key-extractor
       (fn [item]
         (:id (->clj item :keywordize-keys true)))

       :render-item
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data :item} item-info]
           (item data swg thr parry-skills nav)))

       :ListHeaderComponent header}]

     [:> view {:style (tw "absolute bottom-4 right-4")}
      [add-button {:on-click #(-> nav (.push (i18n/label :t/melee-weapons-list)))}]]]))

(rf/reg-sub
 :items/melee-weapons
 (fn [db]
   (get-in db [:items :melee-weapons] [])))

(rf/reg-sub
 :skills/shields
 :<- [:skills/weapons]
 (fn [skills]
   (filter #(or (= :cloak (:k %))
                (= :shield (keyword (namespace (:k %)))))
           skills)))

(rf/reg-sub
 :skills/weapons
 :<- [:skills]
 (fn [skills]
   (filter #(some? ((generify-key (:k %)) (:combat-melee grouped-skills))) skills)))

(rf/reg-sub
 :skills/parriable-weapons
 :<- [:skills/weapons]
 (fn [weapons]
   (->> weapons
        (filter #(not (or (= :cloak (:k %)) (= :shield (keyword (namespace (:k %))))))))))

;; NOTE (MELEE/2)+3; round down
(defn- lvl->parry
  [lvl]
  (let [parry (quot (+ lvl 2) 3)]
    (if (pos? parry) parry 0)))

;; TODO: base parry should be the highest parry in the weapons list
(rf/reg-sub
 :defenses/parries
 :<- [:skills/weapons]
 :<- [:skills/lvls]
 :<- [:attributes/dex]
 (fn [[skills skill-lvls dx]]
   (some->> (merge skills {:name "DX", :k :dx, :cost 1})
            (map #(:k %))
            (map #(do {% (lvl->parry (:lvl (% (merge skill-lvls {:dx {:lvl dx}}))))}))
            (into {}))))
