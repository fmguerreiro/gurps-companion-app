(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text button]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt difficulties]]
            ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [taoensso.timbre :as log]))

;; (defn next-cost
;;   [current-cost]
;;   (cond (= 0 current-cost) 1
;;         (= 1 current-cost) 2
;;         (= 2 current-cost) 4
;;         (= 4 current-cost) 8
;;         :else (+ 4 current-cost)))

;; (defn prev-cost
;;   [current-cost]
;;   (cond (= 0 current-cost) 0
;;         (= 1 current-cost) 0
;;         (= 2 current-cost) 1
;;         (= 4 current-cost) 2
;;         :else (- current-cost 4)))

;; (defn- cost->lvl-mod
;;   "Converts a cost to a level modifier
;;   e.g. 1 -> 0, 2 -> 1, 4 -> 2, 8 -> 3, 12 -> 4, etc."
;;   [cost]
;;   (cond (= 0 cost) 0
;;         (= 1 cost) 0
;;         (= 2 cost) 1
;;         (= 4 cost) 2
;;         :else (js/Math.floor (inc (/ cost 4)))))

;; (defn- diff+cost->lvl-mod
;;   "Converts a skill cost to a level modifier based on difficulty"
;;   [skill cost]
;;   (when (some? cost)
;;     (let [difficulty (:diff skill)
;;           modifier (cost->lvl-mod cost)]
;;       (cond (= difficulty :e) modifier
;;             (= difficulty :a) (dec modifier)
;;             (= difficulty :h) (- 2 modifier)
;;             (= difficulty :vh) (- 3 modifier)))))

(defn- row
  [col1 col2 col3]
  [:> view {:style (tw "flex flex-row justify-between")}
    ;; name
   [:> view {:style (tw "w-4/6 my-auto")} col1]
    ;; difficulty
   [:> view {:style (tw "w-1/6 my-auto")} col2]
    ;; default-lvl ;; TODO: explanation on default?
   [:> view {:style (tw "w-1/6 my-auto")} col3]])

(defn- skill-header
  []
  [row
   [:> text {:style (tw "font-bold")} (i18n/label :t/skill)]
   [:> text {:style (tw "font-bold text-center")} (i18n/label :t/difficulty)]
   [:> text {:style (tw "font-bold text-center")} (i18n/label :t/default-lvl)]])

(defn skill-row
  "Add a row for a skill to the skill list"
  [skill-key default-lvl]
  (let [skill         (skill-key skills)]
    (r/as-element
     [:> view {:style (tw "flex flex-col gap-2")}
      [skill-header]

      [row
       [:> text {:style (tw "capitalize")} (skill->txt skill-key)]
       [:> text {:style (tw "text-center")} (i18n/label (keyword :t (str (symbol ((:diff skill) difficulties)) "-full")))]
       [:> text {:style (tw "text-center")} default-lvl]]])))

;; (rf/reg-event-db
;;  :skills/inc-skill-lvl
;;  (fn [db [_ skill]]
;;    (info "inc-skill-lvl" (str skill) (get-in db [:skill-costs skill]))
;;    (update-in db [:skill-costs skill] (fnil next-cost 0))))

;; (rf/reg-event-db
;;  :skills/dec-skill-lvl
;;  (fn [db [_ skill]]
;;    (info "dec-skill-lvl" (str skill) (get-in db [:skill-costs skill]))
;;    (update-in db [:skill-costs skill] (fnil prev-cost 0))))

(defn- spec-header
  [txt]
  [:> text {:style (tw "text-xl font-bold capitalize")}
   txt])

(defn character-add-skill-spec-page
  [props]
  (let [skill-key       (-> props ->clj :route :params :id str->key)
        skill           (skill-key skills)
        specializations (:specializations skill)
        default-lvls    (some-> (rf/subscribe [:skills/defaults]) deref)
        skills          (some->> (rf/subscribe [:skills]) deref (map #(:key %)) set)
        navigation      (rnn/useNavigation)]
    [:> view {:style (tw "p-2 bg-white flex flex-col gap-2 flex-grow")}
     ;; description
     [spec-header
      (i18n/label :t/description)]
     [:> text
      (i18n/label (keyword :t (str "skill-description-" (symbol (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))))))]

     (if (not (= "sp" (name skill-key)))
       ;; pure skill - no specialization
       [skill-row skill-key (get default-lvls skill-key)]

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
                                                     (-> navigation (.navigate (i18n/label :t/skills))))}
                            [:> view {:style (tw (str "flex flex-row grow border-b"
                                                      (when disabled? " py-1 bg-slate-200")
                                                      (when (not= spec last-spec) " border-slate-200")))} ;; TODO: border btw els not working
                             [:> text {:style (tw "capitalize flex-1 text-left")} txt]
                             (when (not disabled?) [:> text {:style (tw "flex-1 text-right")} "+"])]])))))]]))

     ;; dependencies TODO
     [:<>]]))

(defn- ->db
  [skill-key spec]
  {:name (str (skill->txt skill-key) (when spec (str " (" (skill->txt spec) ")")))
   :key  (if spec (keyword (namespace skill-key) spec) skill-key)
   :cost 1})

(rf/reg-event-fx
 :skills/add
 (fn [{:keys [db]} [_ skill-key spec]]
   (let [len    (count (get-in db [:skills]))
         new-db (assoc-in db [:skills len] (->db skill-key spec))]
     {:db new-db
      :effects.async-storage/set {:k     :skills
                                  :value (get-in new-db [:skills])}})))
