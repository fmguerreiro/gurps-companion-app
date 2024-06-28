(ns gurps.pages.character.items.melee-edit-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [scroll-view view text]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.underlined-input :refer [underlined-input labelled-underlined-input]]
            [gurps.pages.character.utils.skills :refer [grouped-skills]]
            [gurps.utils.helpers :refer [->int]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            [gurps.utils.i18n :as i18n]))

(defn- debug
  [exp & tag]
  (println tag exp)
  exp)

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(defn- prepend-addition
  [s]
  (cond (str/starts-with? s "-") s
        (not (str/starts-with? s "+")) (str "+" s)
        :else s))

(def dmg [:sw :thr :spec])
(def dmg-data
  (map #(do {:value % :label (i18n/label (keyword :k (str "dmg-" (symbol %))))}) dmg))
(def dmg-types [:cr :burn :cor :imp :pi- :pi :pi+ :pi++ :tox :aff :fat])
(def dmg-type-data
  (map #(do {:value % :label (i18n/label (keyword :t (str "dmg-type-" (symbol %))))}) dmg-types))
(defn- dmg-section
  [dmg idx]
  [section (i18n/label :t/damage)
   [:> view {:style (tw "flex flex-col gap-1")}
    (map-indexed
     (fn [i dmg']
       (let [modifier (-> dmg' keys first)
             dmg-type (-> dmg' modifier)
             [base mod] (str/split (-> modifier symbol str) #"[+-]")]
         ^{:key (str "dmg-" i)}
         [:> view {:style (tw "flex flex-row gap-1 items-center")}
          [dropdown {:placeholder (i18n/label (keyword :k (str "dmg-" base)))
                     :data dmg-data
                     :style (tw "flex-1")
                     :placeholder-style (tw "text-center text-xs")
                     :selected-style (tw "text-right")}]
          [underlined-input {:val (if (str/includes? (-> modifier symbol str) "-")
                                    (str "-" mod)
                                    mod)
                             :on-change-text #(debounce-and-dispatch
                                               [:items.melee/update
                                                idx
                                                :dmg
                                                (assoc-in dmg [i] {(keyword (str base (prepend-addition %))) dmg-type})] 500)
                             :style (tw "flex-1")
                             :text-align "center"
                             :max-length 5
                             :input-mode "numeric"}]

          [dropdown {:placeholder (i18n/label (keyword :t (str "dmg-type-" (symbol dmg-type))))
                     :data dmg-type-data
                     :style (tw "flex-1")
                     :placeholder-style (tw "text-center text-xs")
                     :selected-style (tw "text-right")}]]))
     dmg)]])

(defn- remove-numbers
  [s]
  (str/replace s #"(\+|-)?\d+" ""))

(defn- keep-numbers
  [s]
  (str/replace s #"[^0-9-+]+" ""))

(defn- parry-section
  [parry]
  [section (i18n/label :t/parry)
   [:> view {:style (tw "flex flex-col gap-1")}
    (map-indexed
     (fn [idx parry']
       ^{:key (str "parry-" idx)}
       [:> view {:style (tw "flex flex-row gap-1 items-center")}
        [underlined-input {:val (keep-numbers (str parry'))
                           :style (tw "flex-1")
                           :text-align "center"
                           :input-mode "numeric"}]
        [dropdown {:placeholder (-> parry' symbol str remove-numbers)
                   :data [{:label "" :value nil}, {:label (i18n/label :t/parry-unbalanced) :value :u}, {:label (i18n/label :t/parry-fencing) :value :f}, {:label (i18n/label :t/parry-no) :value :no}]
                   :style (tw "flex-2")
                   :placeholder-style (tw "text-center capitalize text-xs")
                   :selected-style (tw "text-center capitalize")}]])
     parry)]])

(defn- skill-key
  [k]
  (if (namespace k)
    (namespace k)
    k))
(defn- skill-dropdown
  [skill]
  (let [skills (-> grouped-skills :combat-melee keys)
        data   (some->> skills (map #(do {:value % :label (i18n/label (str "skill-" (symbol (skill-key %))))})))]
    [dropdown {:placeholder (i18n/label (str "skill-" (symbol (skill-key skill))))
               :data data
               :style (tw "flex-1")
               :placeholder-style (tw "text-xs")
               :selected-style (tw "text-center")}]))

(def val->int (comp ->int symbol :value))
(def reach-data
  (->> (conj (range 1 8) 'c)
       (map (comp keyword str))
       (map #(do {:value %, :label (-> % symbol str str/upper-case)}))))
(defn- reach-section
  [reach idx]
  [section (i18n/label :t/reach)
   [:> view {:style (tw "flex flex-col gap-1")}
    (map-indexed
     (fn [i reach']
       (let [[lower upper] (str/split (-> reach' symbol str) #"-")]
         ^{:key (str "reach-" i)}
         [:> view {:style (tw "flex flex-row items-center")}
          [dropdown {:placeholder lower
                     :data reach-data
                     :on-change #(rf/dispatch [:items.melee/update idx :reach (assoc-in reach [i] (keyword (str (symbol %) "-" (if (> (->int (symbol %)) upper) (symbol %) upper))))])
                     :style (tw "flex-1")
                     :placeholder-style (tw "text-center text-xs")
                     :selected-style (tw "text-center text-xs")}]
          [:> text {:style (tw "text-xl font-bold")} "-"]
          [dropdown {:placeholder (or upper lower)
                     :data (filter #(>= (val->int %) (->int (symbol lower))) reach-data)
                     :on-change #(rf/dispatch [:items.melee/update idx :reach (assoc-in reach [i] (keyword (str lower "-" (symbol %))))])
                     :style (tw "flex-1")
                     :placeholder-style (tw "text-center uppercase text-xs")
                     :selected-style (tw "text-center uppercase text-xs")}]]))
     reach)]])

(defn melee-edit-page
  [props]
  (let [id           (-> ^js props .-route .-params .-id keyword)
        weapons      (some-> (rf/subscribe [:items/melee-weapons]) deref)
        [idx weapon] (some->> weapons (map-indexed vector) (filter #(= (:id (second %)) id)) first)
        {:keys [name dmg reach parry cost weight st skill]} weapon]

    [:> view {:style (tw "flex grow")}
     [scroll-view {:style (tw "bg-white")
                   :contentContainerStyle (tw "bg-white p-2 pt-4 flex flex-col grow gap-3")}

      ;; name
      [labelled-underlined-input
       {:label (i18n/label :t/name)
        :val (if name
               name
               (if (i18n/has-label? id) (i18n/label id) id))}]

      [:> view {:style (tw "flex flex-row gap-2")}
       [:> view {:style (tw "flex-2")}
        [dmg-section dmg idx]]
       [:> view {:style (tw "flex-1")}
        [reach-section reach idx]]]

      [:> view {:style (tw "flex flex-row gap-2")}
       [:> view {:style (tw "flex-1")}
        [section (i18n/label :t/skill)
         [skill-dropdown skill]]]
       [:> view {:style (tw "flex-1")}
        [parry-section parry]]]

      [:> view {:style (tw "flex flex-row gap-2")}
       [:> view {:style (tw "flex-1")}
        ;; cost
        [labelled-underlined-input
         {:label (i18n/label :t/cost)
          :val cost
          :text-align "center"
          :input-mode "numeric"}]]

       [:> view {:style (tw "flex-1")}
        ;; weight
        [labelled-underlined-input
         {:label (i18n/label :t/weight)
          :val weight
          :text-align "center"
          :input-mode "numeric"}]]

       [:> view {:style (tw "flex-1")}
        ;; st
        [labelled-underlined-input
         {:label (i18n/label :t/attr-st)
          :val st
          :text-align "center"
          :input-mode "numeric"}]]]]]))

(def empty-weapon {:id nil :dmg [] :reach [] :parry [] :cost 0 :weight 0 :st 0 :skill nil})
(rf/reg-event-fx
 :items.melee/update
 (fn [{:keys [db]} [_ i k v]]
   (let [weapon (merge (get-in db [:items :melee-weapons i] empty-weapon) {k v})
         new-db (update-in db [:items :melee-weapons] (fnil #(do (assoc-in % [i] weapon)) [weapon]))]
     {:db new-db
      :effects.async-storage/set {:k     :items/melee-weapons
                                  :value (get-in new-db [:items :melee-weapons])}})))
