(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text button]]
            [gurps.utils.helpers :refer [str->key flatten-key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]))

(defn next-cost
  [current-cost]
  (cond (= 0 current-cost) 1
        (= 1 current-cost) 1
        (= 2 current-cost) 2
        (= 4 current-cost) 4
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
  (cond (= 1 cost) 0
        (= 2 cost) 1
        (= 4 cost) 2
        :else (js/Math.floor (inc (/ cost 4)))))

(defn- diff+cost->lvl-mod
  "Converts a skill cost to a level modifier based on difficulty"
  [skill cost]
  (let [difficulty (:diff skill)]
    (cond (= difficulty :e) (cost->lvl-mod cost)
          (= difficulty :a) (dec (cost->lvl-mod cost))
          (= difficulty :h) (- 2 (cost->lvl-mod cost))
          (= difficulty :vh) (- 3 (cost->lvl-mod cost)))))

(defn add-skill-row
  [skill-key default-lvl]
  (js/console.log "add-skill-row" (str (symbol skill-key)))
  (let [skill (skill-key skills)
        cost (some-> (rf/subscribe [(keyword :skill-costs (flatten-key skill-key))]) deref)
        lvl  10;; (fnil (diff+cost->lvl-mod skill cost) default-lvl)
        ]
    (r/as-element
     [:> view {:className "flex flex-row justify-between"}
     ;; lvl
      [:> text lvl]

     ;; difficulty
      [:> text (i18n/label (keyword "t" ((:diff skill) difficulties)))]

     ;; cost
      [:> view {:className "w-1/4 flex flex-row bg-slate-100"}
       [:> button {:onPress #(rf/dispatch [:skills/dec-skill-lvl skill-key])}
        [:> text "<"]]
       [:> text {:className ""} cost]
       [:> button {:onPress #(rf/dispatch [:skills/inc-skill-lvl skill-key])}
        [:> text ">"]]]])))

(for [skill (keys skills)]
  (when (not (= "sp" (name skill)))
    (let [skill-key (flatten-key skill)]
      (js/console.log "registering sub" (str (keyword :skill-costs skill-key)))
      (rf/reg-sub
       (keyword :skill-costs skill-key)
       (fn [db _]
         (get-in db [:skill-costs skill-key] 0))))))

(rf/reg-event-db
 :skills/inc-skill-lvl
 (fn [db [_ skill]]
   (update-in db [:skill-costs skill] (fnil prev-cost 0))))

(rf/reg-event-db
 :skills/dec-skill-lvl
 (fn [db [_ skill]]
   (update-in db [:skill-costs skill] (fnil next-cost 0))))

(defn character-add-skill-spec-page
  [props]
  (r/with-let [skill-key (-> props ->clj :route :params :id str->key)
               skill (skill-key skills)
               specializations (:specializations skill)
               default-lvls @(rf/subscribe [:skills/defaults])]
    [:> view
     [:> text {:className ""}
      (i18n/label (keyword "t" (str "skill-description-" (symbol (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))))))]
     [add-skill-row skill-key (get default-lvls skill-key)]
     (->> specializations
          (map (fn [spec]
                 (let [display-text (skill->txt spec)]
                   [:> text {:key (str spec "-spec")} display-text]))))]))

;; TODO: add list of prerequisites (clickable)
