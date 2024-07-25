(ns gurps.pages.character.skills.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [cljs-bean.core :refer [->clj ->js]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view flat-list-old text button]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]))

(defn- row
  [col1 col2 col3 col4]
  [:> view {:style (tw "flex flex-row justify-between")}
   ;; name
   [:> view {:style (tw "flex-2 my-auto")} col1]
   ;; difficulty
   [:> view {:style (tw "flex-1 my-auto")} col2]
   ;; default-lvl ;; TODO: explanation on which skill it's defaulting from?
   [:> view {:style (tw "flex-1 my-auto")} col3]
   [:> view {:style (tw "flex-1 my-auto")} col4]])

(defn- header
  []
  [row
   [:> text {:style (tw "font-bold")} (i18n/label :t/name)]
   [:> text {:style (tw "font-bold justify-center text-center")} (i18n/label :t/difficulty)]
   [:> text {:style (tw "font-bold justify-center text-center")} (i18n/label :t/default-lvl)]
   [:> text {:style (tw "font-bold justify-center text-center")} (i18n/label :t/learn?)]])

(defn skill-row
  "Add a row for a skill to the skill list"
  [skill-key default-lvl]
  (let [skill (skill-key skills)
        purchased?    (some-> (rf/subscribe [:skills/lvls]) deref skill-key some?)
        can-purchase? (some-> (rf/subscribe [:skills/can-purchase? skill-key]) deref)]
    (r/as-element
     [:> view {:style (tw "flex flex-col gap-2")}

      [header]

      [:> button {:onPress  #(rf/dispatch [:skills/add skill-key])
                  :style    (when purchased? (tw "bg-green-100"))
                  :disabled (not can-purchase?)}
       [row
        [:> text {:style (tw "capitalize"), :numberOfLines 1} (skill->txt skill-key)]
        [:> text {:style (tw "text-center")} (i18n/label (keyword :t (str (symbol ((:diff skill) difficulties)) "-full")))]
        [:> text {:style (tw "text-center")} default-lvl]
        (when can-purchase? [:> text {:style (tw "text-center")} "+"])]]])))

(defn- section-header
  [txt]
  [:> text {:style (tw "text-xl font-bold capitalize")}
   txt])

(defn- specializations-section
  [skill-key specializations]
  (let [skills (some-> (rf/subscribe [:skills/lvls]) deref)
        can-purchase? (some-> (rf/subscribe [:skills/can-purchase? skill-key]) deref)]
    [:> view
     [flat-list-old
      {:data (->js specializations)

       :key-extractor identity

       :scroll-enabled false

       :render-item
       (fn [item-info-js]
         (let [item-info (->clj item-info-js :keywordize-keys true)
               {data' :item} item-info
               data      (keyword data')
               txt       (skill->txt data)
               disabled? (contains? skills (keyword (namespace skill-key) data))]
           (r/as-element
            [:> button {:disabled (and (not can-purchase?) disabled?)
                        :onPress #(rf/dispatch [:skills/add skill-key data])}

             [:> view {:style (tw (str "flex flex-row grow border-b py-1"
                                       (when disabled? " bg-green-100")))}

              [:> text {:style (tw "capitalize flex-1 text-left")} txt]
              (when (and can-purchase? (not disabled?))
                [:> text {:style (tw "flex-1 text-right")} "+"])]])))

       :ListHeaderComponent (r/as-element [section-header (i18n/label :t/specializations)])}]]))

(defn- modifiers
  [skill]
  (when (i18n/has-label? (i18n/label (keyword :t (str "skill-modifiers-" (symbol skill)))))
    [:> view {:style (tw "flex flex-col gap-1")}
     [:> text {:style (tw "font-bold")} (i18n/label :t/modifiers)]
     [:> text (i18n/label (keyword :t (str "skill-modifiers-" (symbol skill))))]]))

(declare prerequisite)

(defn- and-prerequisite
  [nav prereqs]
  [:> view {:style (tw "flex flex-col flex-grow gap-2")}
   [:> text {:style (tw "capitalize")} (i18n/label :t/requires-all)]
   [:> view {:style (tw "flex flex-col gap-2 ml-2")}
    (map-indexed (fn [idx prereq]
                   ^{:key (str "and-prereq-" idx)}
                   [prerequisite nav prereq])
                 prereqs)]])

(defn- or-prerequisite
  [nav prereqs]
  [:> view {:style (tw "flex flex-col flex-grow gap-2")}
   [:> text {:style (tw "capitalize")} (i18n/label :t/requires-either)]
   [:> view {:style (tw "flex flex-col gap-2 ml-2")}
    (map-indexed (fn [idx prereq]
                   ^{:key (str "or-prereq-" idx)}
                   [prerequisite nav prereq])
                 prereqs)]])

(defn- key->i18n-label
  [k]
  (let [type   (namespace k)
        name   (name k)
        prefix (cond (= "advantages" type) "advantage"
                     (= "talents" type) "talent"
                     :else "skill")]
    (i18n/label (keyword :t (str prefix "-" name)))))

(defn- key->page
  [k]
  (let [type (namespace k)
        page (cond (= "advantages" type) :t/advantage-details
                   ;; (= "talents" type) :t/talent-details ;; TODO: implement talents
                   ;; TODO: musical instrument?? see ":musical-influence"
                   :else :t/add-skill-specialization)]
    (i18n/label page)))

(defn- keyword-prerequisite
  [nav k lvl]
  (let [cleared? (some-> (rf/subscribe [:skill/clears-prereq? k (or lvl 1)]) deref)]
    (rf/dispatch [:skills/update-prerequisites k cleared?])
    [:> button {:onPress #(-> nav (.push (key->page k) #js {:id (name k)}))}
     [:> view {:style (tw (str "flex flex-row flex-grow justify-between"
                               (when cleared? " bg-green-100")))}
      [:> text (key->i18n-label k)]

      (when lvl
        [:> text lvl])]]))

(rf/reg-sub
 :skill/clears-prereq?
 :<- [:advantages]
 :<- [:skills/lvls]
 ;; TODO :<- [:talents]
 (fn [[advantages skills] [_ k lvl]]
   (let [type (keyword (namespace k))
         name (keyword (name k))]
     (>= (cond (= :advantages type) (get-in advantages [name :lvl])
               :else (get-in skills [name :lvl]))
         lvl))))

(defn- map-prerequisite
  [nav k]
  (let [key (-> k first key)
        val (-> k first val)]
    (cond (= :and key) [and-prerequisite nav val]
          (= :or key) [or-prerequisite nav val]
          (and (keyword? key) (number? val)) [keyword-prerequisite nav key val]
          ;; TODO other types?
          :else [:<>])))

(defn- prerequisite
  [nav k]
  (cond (map? k) [map-prerequisite nav k]
        (keyword? k) [keyword-prerequisite nav k]
        ;; TODO other types?
        :else [:<>]))

(defn skill-details-page
  [props]
  (let [skill-key       (-> props ->clj :route :params :id str->key)
        skill-name      (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))
        skill           (skill-key skills)
        specializations (:specializations skill)
        default-lvls    (some-> (rf/subscribe [:skills/defaults]) deref)
        skills          (some-> (rf/subscribe [:skill-map]) deref)
        nav             (rnn/useNavigation)]
    (rf/dispatch [:details-page/key skill-key])
    [:> view {:style (tw "p-2 bg-white flex flex-col gap-2 flex-grow")}

     ;; description
     [:> view {:style "flex flex-col gap-1"}
      [section-header (i18n/label :t/description)]
      [:> text
       (i18n/label (keyword :t (str "skill-description-" (symbol skill-name))))]]

     ;; modifiers
     [modifiers (symbol skill-name)]

     (if (not (= "sp" (name skill-key)))
       ;; pure skill - no specialization
       [skill-row skill-key (get default-lvls skill-key) (contains? skills skill-key)]

       ;; specializations
       (when specializations
         [specializations-section skill-key specializations]))

     ;; dependencies
     (when (:prerequisites skill)
       [:> view {:style (tw "flex flex-col gap-1")}
        [section-header (i18n/label :t/dependencies)]

        (map-indexed (fn [i prereq]
                       ^{:key (str "prereq-" i)}
                       [prerequisite nav (apply hash-map prereq)])
                     (:prerequisites skill))])]))

(defn- ->db
  [skill-key spec]
  {:name (str (skill->txt skill-key) (when spec (str "(" (skill->txt spec) ")")))
   :k    (if spec (keyword (namespace skill-key) spec) skill-key)
   :cost 1})

(rf/reg-event-fx
 :skills/add
 (fn [{:keys [db]} [_ skill-key spec]]
   (let [len    (count (get-in db [:skills]))
         new-db (assoc-in db [:skills len] (->db skill-key spec))]
     {:db new-db
      :fx [[:dispatch [:profile.update/unspent-points 1]]]
      :effects.async-storage/set {:k     :skills
                                  :value (get-in new-db [:skills])}})))

(rf/reg-event-db
 :details-page/key
 (fn [db [_ k]]
   (assoc-in db [:details-page/key] k)))

(rf/reg-event-db
 :skills/update-prerequisites
 (fn [db [_ prereq-k cleared?]]
   (let [skill-k (get-in db [:details-page/key])]
     (assoc-in db [:skill-prereqs skill-k :prereqs prereq-k] cleared?))))

(defn- meets-prerequisites?
  [prereq->cleared? prereqs]
  (if (keyword? prereqs)
    (prereq->cleared? prereqs)

    (let [ps (->> prereqs
                  first second
                  ;; {:and [:light-walk, ...]} => [:light-walk, ...]
                  ;; {:or [:light-walk, ...]} => #{:light-walk, ...}
                  (map #(if (keyword? %) %
                            (let [cnd (first (keys %))] (if (= :or cnd) (into #{} (first (vals %))) (first (vals %)))))))]
      (->> ps
           (map #(cond (keyword? %) (prereq->cleared? %)

                       (vector? %)  (->> %
                                         (map (fn [xs] (meets-prerequisites? prereq->cleared? xs)))
                                         (filter false?)
                                         count
                                         (= 0))
                       (set? %)     (->> %
                                         (map (fn [xs] (meets-prerequisites? prereq->cleared? xs)))
                                         (map true?)
                                         count
                                         pos?)
                       :else             true))
           (filter false?)
           count
           (= 0)))))

(rf/reg-sub
 :skill/prerequisites
 (fn [db]
   (let [skill-k (get-in db [:details-page/key])]
     (get-in db [:skill-prereqs skill-k :prereqs]))))

(rf/reg-sub
 :skills/can-purchase?
 :<- [:skills/lvls]
 :<- [:skill/prerequisites]
 (fn [[skills prereqs] [_ k]]
   (if (> (get-in skills [k :lvl] 0) 0)
     ;; if skill already purchased, dont show add button
     false
     ;; else, do requirement checks
     (or (nil? prereqs) ;; no prereqs
         (meets-prerequisites? prereqs
                               (get-in gurps.pages.character.utils.skills/skills [k :prerequisites]))))))

(comment)
  ;; (def prereqs {:and [{:or [:advantages/trained-by-a-master :advantages/weapon-master]} :jumping :power-blow]})
  ;; (def and-or (first (keys prereqs)))
  ;; (def ps (if (= :or and-or) (into #{} (-> prereqs first second (map #(let [cnd (key %)] (if (= :or cnd) (into #{} (val %)) (val %)))) )) (second prereqs))
