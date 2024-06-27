(ns gurps.pages.character.items.melee-edit-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [scroll-view view text]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.underlined-input :refer [underlined-input labelled-underlined-input]]
            [gurps.pages.character.utils.skills :refer [grouped-skills]]
            [gurps.utils.i18n :as i18n]))

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(defn- skill-key
  [k]
  (if (namespace k)
    (namespace k)
    k))

(defn- remove-numbers
  [s]
  (str/replace s #"(\+|-)?\d+" ""))

(defn- keep-numbers
  [s]
  (str/replace s #"[^0-9-+]+" ""))

(defn- skill-dropdown
  [skill]
  (let [skills (-> grouped-skills :combat-melee keys)
        data   (some->> skills (map #(do {:value % :label (i18n/label (str "skill-" (symbol (skill-key %))))})))]
    [dropdown {:style (tw "flex-1")
               :placeholder-style (tw "text-center text-xs")
               :selected-style (tw "text-center")
               :placeholder (i18n/label (str "skill-" (symbol (skill-key skill))))
               :data data}]))

(def reach-data
  (->> (conj (range 1 8) 'c)
       (map keyword)
       (map #(do {:value (keyword %), :label (-> % str str/upper-case)}))))

(def dmg [:sw :thr :spec])
(def dmg-data
  (map #(do {:value % :label (i18n/label (keyword :k (str "dmg-" (symbol %))))}) dmg))
(def dmg-types [:cr :burn :cor :imp :pi- :pi :pi+ :pi++ :tox :aff :fat])
(def dmg-type-data
  (map #(do {:value % :label (i18n/label (keyword :t (str "dmg-type-" %)))}) dmg-types))

(defn melee-edit-page
  [props]
  (let [id (-> ^js props .-route .-params .-id keyword)
        weapons (some-> (rf/subscribe [:items/melee-weapons]) deref)
        weapon  (some->> weapons (filter #(= (:id %) id)) first)
        {:keys [name dmg reach parry cost weight st skill]} weapon]

    [:> view {:style (tw "flex grow")}
     [scroll-view {:style (tw "bg-white")
                   :contentContainerStyle (tw "bg-white p-2 flex flex-col grow gap-2")}

      ;; name
      [labelled-underlined-input
       {:label (i18n/label :t/name)
        :val (if name
               name
               (if (i18n/has-label? id) (i18n/label id) id))}]

      ;; dmg
      [section (i18n/label :t/damage)
       [:> view {:style (tw "flex flex-col gap-1")}
        (map-indexed
         (fn [idx dmg']
           (let [modifier (-> dmg' keys first)
                 dmg-type (-> dmg' modifier)
                 [base mod] (str/split (-> modifier symbol str) #"[+-]")]
             ^{:key (str "dmg-" idx)}
             [:> view {:style (tw "flex flex-row gap-1")}
              [dropdown {:placeholder (i18n/label (keyword :k (str "dmg-" base)))
                         :data dmg-data}]
              [:> text (if (str/includes? (-> modifier symbol str) "-")
                         (str "-" mod)
                         mod)]

              [dropdown {:placeholder (i18n/label (keyword :t (str "dmg-type-" dmg-type)))
                         :data dmg-type-data}]]))
         dmg)]]

      ;; reach
      [section (i18n/label :t/reach)
       [:> view {:style (tw "flex flex-col gap-1")}
        (map-indexed
         (fn [idx reach']
           ^{:key (str "reach-" idx)}
           (let [[lower upper] (str/split (-> reach' symbol str) #"-")]
             [:> view {:style (tw "flex flex-row")}
              [dropdown {:placeholder lower
                         :data reach-data}]
              [:> text "-"]
              [dropdown {:placeholder (or upper lower)
                         :data reach-data}]]))
         reach)]]

      ;; parry
      [section (i18n/label :t/parry)
       [:> view {:style (tw "flex flex-col gap-1")}
        (map-indexed
         (fn [idx parry']
           ^{:key (str "parry-" idx)}
           [:> view {:style (tw "flex flex-row gap-1")}
            [underlined-input {:val (keep-numbers (str parry'))}]
            [dropdown {:placeholder (-> parry' symbol str remove-numbers)
                       :data [{:label "" :value nil}, {:label "Unbalanced" :value :u}, {:label "Fencing" :value :f}, {:label "No" :value :no}]}]])
         parry)]]

      ;; cost
      [labelled-underlined-input
       {:label (i18n/label :t/cost)
        :val cost}]

      ;; weight
      [labelled-underlined-input
       {:label (i18n/label :t/weight)
        :val weight}]

      ;; st
      [labelled-underlined-input
       {:label (i18n/label :t/attr-st)
        :val st}]

      ;; skill
      [section (i18n/label :t/skill)
       [skill-dropdown skill]]]]))

;; TODO
(declare empty-weapon)
(rf/reg-event-fx
 :items.melee/update
 (fn [{:keys [db]} [_ i k v]]
   (let [weapon (merge (get-in db [:items :melee-weapons i] empty-weapon) {k v})
         new-db (update-in db [:items :melee-weapons] (fnil #(do (assoc-in % [i] weapon)) [weapon]))]
     {:db new-db
      :effects.async-storage/set {:k     :items/melee-weapons
                                  :value (get-in new-db [:items :melee-weapons])}})))
