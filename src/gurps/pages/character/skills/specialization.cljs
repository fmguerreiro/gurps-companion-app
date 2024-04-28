(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [taoensso.timbre :refer [info]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text button]]
            [gurps.utils.helpers :refer [str->key flatten-key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]
            ["twrnc" :refer [style] :rename {style tw}]))

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

(defn character-add-skill-spec-page
  [props]
  (r/with-let [skill-key (-> props ->clj :route :params :id str->key)
               skill (skill-key skills)
               specializations (:specializations skill)
               default-lvls @(rf/subscribe [:skills/defaults])]
    [:> view
     [:> text {:style (tw "")}
      (i18n/label (keyword "t" (str "skill-description-" (symbol (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))))))]

     [add-skill-row skill-key (get default-lvls skill-key)]

     (when (some? specializations)
       [:> text {:style (tw "mt-4")} "Specializations:"]
       (->> specializations
            (map (fn [spec]
                   (let [display-text (skill->txt spec)]
                     [:> button {:key (str spec "-spec")
                                 :onPress #()} ;; TODO
                      [:> text display-text]])))))]))

;; TODO: add list of prerequisites (clickable)
