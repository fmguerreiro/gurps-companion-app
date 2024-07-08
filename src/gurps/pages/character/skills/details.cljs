(ns gurps.pages.character.skills.details
  (:require [cljs-bean.core :refer [->clj]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text button]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]
            ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]))

(defn- row
  [col1 col2 col3 col4]
  [:> view {:style (tw "flex flex-row justify-between")}
    ;; name
   [:> view {:style (tw "flex-3 my-auto")} col1]
    ;; difficulty
   [:> view {:style (tw "flex-1 my-auto")} col2]
    ;; default-lvl ;; TODO: explanation on which skill it's defaulting from?
   [:> view {:style (tw "flex-1 my-auto")} col3]
   [:> view {:style (tw "flex-1 my-auto")} col4]])

(defn- skill-header
  []
  [row
   [:> text {:style (tw "font-bold")} (i18n/label :t/skill)]
   [:> text {:style (tw "font-bold text-center")} (i18n/label :t/difficulty)]
   [:> text {:style (tw "font-bold text-center")} (i18n/label :t/default-lvl)]
   [:> text {:style (tw "font-bold text-center")} (i18n/label :t/learn?)]])

(defn skill-row
  "Add a row for a skill to the skill list"
  [skill-key default-lvl disabled?]
  (let [skill      (skill-key skills)
        navigation (rnn/useNavigation)]
    (r/as-element
     [:> view {:style (tw "flex flex-col gap-2")}
      [skill-header]

      [:> button {:onPress  #(do (rf/dispatch [:skills/add skill-key])
                                 (-> navigation (.navigate (i18n/label :t/skills))))
                  :style    (when disabled? (tw "bg-slate-200 py-1"))
                  :disabled disabled?}
       [row
        [:> text {:style (tw "capitalize")} (skill->txt skill-key)]
        [:> text {:style (tw "text-center")} (i18n/label (keyword :t (str (symbol ((:diff skill) difficulties)) "-full")))]
        [:> text {:style (tw "text-center")} default-lvl]
        (when (not disabled?) [:> text {:style (tw "text-center")} "+"])]]])))

(defn- modifiers
  [skill]
  (when (i18n/has-label? (i18n/label (keyword :t (str "skill-modifiers-" (symbol skill)))))
    [:> view {:style (tw "flex flex-col gap-1")}
     [:> text {:style (tw "font-bold")} (i18n/label :t/modifiers)]
     [:> text (i18n/label (keyword :t (str "skill-modifiers-" (symbol skill))))]]))

(defn- spec-header
  [txt]
  [:> text {:style (tw "text-xl font-bold capitalize")}
   txt])

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
  [:> button {:onPress #(-> nav (.push (key->page k) #js {:id (name k)}))}
   [:> view {:style (tw (str "flex flex-row flex-grow justify-between"))}
                               ;;(when prereq-cleared? " bg-green-100")))}
    [:> text (key->i18n-label k)]

    (when lvl
      [:> text lvl])]])

(defn- map-prerequisite
  [nav k]
  (let [key (-> k first key)
        val (-> k first val)]
    (println "map-prerequisite" key val k)
    (cond (= :and key) [and-prerequisite nav val]
          (= :or key) [or-prerequisite nav val]
          (and (keyword? key) (number? val)) [keyword-prerequisite nav key val]
          ;; TODO other types
          :else [:<>])))

(defn- prerequisite
  [nav k]
  (println "prerequisite" k)
  (cond (map? k) [map-prerequisite nav k]
        (keyword? k) [keyword-prerequisite nav k]
        ;; TODO other types
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
    [:> view {:style (tw "p-2 bg-white flex flex-col gap-2 flex-grow")}
     ;; description
     [spec-header (i18n/label :t/description)]

     [:> text
      (i18n/label (keyword :t (str "skill-description-" (symbol skill-name))))]

     ;; modifiers
     [modifiers (symbol skill-name)]

     (if (not (= "sp" (name skill-key)))
       ;; pure skill - no specialization
       [skill-row skill-key (get default-lvls skill-key) (contains? skills skill-key)]

       ;; specializations
       (when specializations
         [:> view {:style (tw "flex flex-col gap-1")}
          [spec-header (i18n/label :t/specializations)]
          [:> view {:style (tw "flex flex-col gap-1")}
           (let [last-spec (last specializations)]
             (->> specializations
                  (map (fn [spec]
                         (let [txt       (skill->txt spec)
                               disabled? (contains? skills (keyword (namespace skill-key) spec))]
                           ^{:key (str spec "-spec-button")}
                           [:> button {:key (str spec "-spec")
                                       :disabled disabled?
                                       :onPress #(do (rf/dispatch [:skills/add skill-key spec])
                                                     (-> nav (.navigate (i18n/label :t/skills))))}
                            [:> view {:style (tw (str "flex flex-row grow border-b"
                                                      (when disabled? " py-1 bg-slate-200")
                                                      (when (not= spec last-spec) " border-slate-200")))} ;; TODO: border between elems not working
                             [:> text {:style (tw "capitalize flex-1 text-left")} txt]
                             (when (not disabled?) [:> text {:style (tw "flex-1 text-right")} "+"])]])))))]]))

     ;; dependencies TODO
     (when (:prerequisites skill)
       [:> view {:style (tw "flex flex-col gap-2 mt-2")}
        [:> text {:style (tw "font-bold")} (i18n/label :t/dependencies)]

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
