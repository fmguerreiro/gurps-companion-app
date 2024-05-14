(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [taoensso.timbre :refer [info]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text button]]
            [gurps.utils.helpers :refer [str->key flatten-key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]
            ["twrnc" :refer [style] :rename {style tw}]
            [taoensso.timbre :as log]))

(defn next-cost
  [current-cost]
  (cond (= 0 current-cost) 1
        (= 1 current-cost) 2
        (= 2 current-cost) 4
        (= 4 current-cost) 8
        :else (+ 4 current-cost)))

(defn prev-cost
  [current-cost]
  (cond (= 0 current-cost) 0
        (= 1 current-cost) 0
        (= 2 current-cost) 1
        (= 4 current-cost) 2
        :else (- current-cost 4)))

(defn- cost->lvl-mod
  "Converts a cost to a level modifier
  e.g. 1 -> 0, 2 -> 1, 4 -> 2, 8 -> 3, 12 -> 4, etc."
  [cost]
  (cond (= 0 cost) 0
        (= 1 cost) 0
        (= 2 cost) 1
        (= 4 cost) 2
        :else (js/Math.floor (inc (/ cost 4)))))

(defn- diff+cost->lvl-mod
  "Converts a skill cost to a level modifier based on difficulty"
  [skill cost]
  (when (some? cost)
    (let [difficulty (:diff skill)
          modifier (cost->lvl-mod cost)]
      (cond (= difficulty :e) modifier
            (= difficulty :a) (dec modifier)
            (= difficulty :h) (- 2 modifier)
            (= difficulty :vh) (- 3 modifier)))))

(defn add-skill-row
  "Add a row for a skill to the skill list"
  [skill-key default-lvl]
  (when (not (= "sp" (name skill-key))) ;; ignore specializations
    (let [skill (skill-key skills)
          flattened-key (flatten-key skill-key)
          cost (some-> (rf/subscribe [(keyword :skill-costs flattened-key)]) deref)
          lvl  (or (some-> (diff+cost->lvl-mod skill cost) (+ default-lvl)) ;; TODO: putting a single point gets the character to 10 - difficulty-modifier, instead of default-lvl (from defaults calculation)
                   default-lvl)]
      (info "add-skill-row" (str skill-key) cost lvl default-lvl)
      (r/as-element
       [:> view {:style (tw "flex flex-row justify-between")}
        ;; lvl
        [:> text lvl]

        ;; difficulty
        [:> text (i18n/label (keyword "t" ((:diff skill) difficulties)))]

        ;; cost
        [:> view {:style (tw "w-1/4 flex flex-row bg-slate-100")}
         (when (> cost 0)
           [:> button {:onPress #(rf/dispatch [:skills/dec-skill-lvl flattened-key])}
            [:> text "-"]])
         [:> text {:style (tw "")} cost]
         [:> button {:onPress #(rf/dispatch [:skills/inc-skill-lvl flattened-key])}
          [:> text "+"]]]]))))

(rf/reg-event-db
 :skills/inc-skill-lvl
 (fn [db [_ skill]]
   (info "inc-skill-lvl" (str skill) (get-in db [:skill-costs skill]))
   (update-in db [:skill-costs skill] (fnil next-cost 0))))

(rf/reg-event-db
 :skills/dec-skill-lvl
 (fn [db [_ skill]]
   (info "dec-skill-lvl" (str skill) (get-in db [:skill-costs skill]))
   (update-in db [:skill-costs skill] (fnil prev-cost 0))))

(defn- header
  [txt]
  [:> text {:style (tw "text-xl font-bold capitalize")}
   txt])

(defn character-add-skill-spec-page
  [props]
  (let [skill-key       (-> props ->clj :route :params :id str->key)
        skill           (skill-key skills)
        specializations (:specializations skill)
        default-lvls    (some-> (rf/subscribe [:skills/defaults]) deref)
        skills          (some->> (rf/subscribe [:skills]) deref (map #(:key %)) set)]
    [:> view {:style (tw "p-2 bg-white flex flex-col flex-grow")}
     ;; description
     [header (i18n/label :t/description)]
     [:> text {:style (tw "")}
      (i18n/label (keyword :t (str "skill-description-" (symbol (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))))))]

     ;; TODO? this is main skill? should be either specializations or main skill i guess
     [add-skill-row skill-key (get default-lvls skill-key)]

     ;; specializations
     (when specializations
       [:> view {:style (tw "flex flex-col gap-1")}
        [header (i18n/label :t/specializations)]
        [:> view {:style (tw "flex flex-col gap-1")}
         (let [last-spec (last specializations)]
           (->> specializations
                (map (fn [spec]
                       (let [txt       (skill->txt spec)
                             disabled? (contains? skills (keyword (namespace skill-key) spec))]
                         ^{:key (str spec "-spec-button")}
                         [:> button {:key (str spec "-spec")
                                     :disabled disabled?
                                     :onPress #(rf/dispatch [:skills/add skill-key spec])} ;; TODO: navigate back to skill-list page
                          [:> view {:style (tw (str "flex flex-row grow border-b"
                                                    (when disabled? " py-1 bg-slate-200")
                                                    (when (not= spec last-spec) " border-slate-200")))} ;; TODO: border btw els not working
                           [:> text {:style (tw "capitalize flex-1 text-left")} txt]
                           (when (not disabled?) [:> text {:style (tw "flex-1 text-right")} "+"])]])))))]])]))

;; TODO: add list of prerequisites (clickable)

(defn- ->db
  [skill spec]
  {:name (str (skill->txt skill) (when spec (str " (" (skill->txt spec) ")")))
   :key  (if spec (keyword (namespace skill) spec) skill)
   :cost 1
   :lvl 10
   :rel-lvl 10}) ;; TODO: lvl, rel-lvl calculations

(rf/reg-event-fx
 :skills/add
 (fn [{:keys [db]} [_ skill spec]]
   (let [len    (count (get-in db [:skills]))
         new-db (assoc-in db [:skills len] (->db skill spec))]
     {:db new-db
      :effects.async-storage/set {:k     :skills
                                  :value (get-in new-db [:skills])}})))
