(ns gurps.pages.character.items.melee-weapons-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.base :refer [view text]]
            [gurps.pages.character.widgets.helpers :refer [generify-key]]
            [gurps.pages.character.utils.skills :refer [grouped-skills]]
            [gurps.utils.debounce :refer [debounce-and-dispatch debounce]]
            [taoensso.timbre :as log]))

(defn- row
  [col1 col2 col3 col4 col5 col6]
  [:> view {:style (tw "flex flex-row h-6 gap-2")}
   [:> view {:style (tw "w-3/12")} col1]
   [:> view {:style (tw "w-2/12")} col2]
   [:> view {:style (tw "w-2/12")} col3]
   [:> view {:style (tw "w-2/12")} col4]
   [:> view {:style (tw "w-2/12")} col5]
   [:> view {:style (tw "w-1/12 pr-4")} col6]])

(defn- header
  []
  [row
   [:> text {:style (tw "font-bold capitalize")} (i18n/label :t/weapon)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/dmg-thrust)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/dmg-swing)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/reach)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/parry)]
   [:> text {:style (tw "font-bold capitalize")} (i18n/label :t/weight)]])

;; TODO: AI generated. has an off-by one error somewhere
;; +3 -> 1d
;; +4 -> 1d+1
;; +5 -> 1d+2
;; +6 -> 2d
(defn dice-addition
  [dice-roll n]
  (let [roll-parts (re-find #"(\d+)d\+?(\d*)" dice-roll)
        roll-dices (js/parseInt (nth roll-parts 1))
        roll-addition (js/parseInt (nth roll-parts 2 0))
        abs-n (abs n)]
    (cond
      (neg? n)
      (let [dices (max 0 (- roll-dices (quot abs-n 3)))
            remaining-addition (max 0 (- roll-addition (rem abs-n 3)))]
        (str dices (when (pos? dices) "d") (when (pos? remaining-addition) (str "+" remaining-addition))))

      (pos? n)
      (loop [dices roll-dices
             remaining n
             addition roll-addition]
        (cond
          (>= remaining 7) (recur (+ dices 2) (- remaining 7) addition)
          (>= remaining 4) (recur (+ dices 1) (- remaining 4) addition)
          :else (let [total-dices (+ dices (quot (+ remaining 2) 3))
                      remaining-addition (rem (+ remaining 2) 3)]
                  (str total-dices "d" (when (pos? remaining-addition) (str "+" remaining-addition))))))

      :else (str (when (pos? roll-dices) (str roll-dices "d")) (when (pos? roll-addition) (str "+" roll-addition))))))

(def empty-weapon {:name "" :weight 0 :thr-mod 0 :swg-mod 0 :reach "" :parry nil})

;; NOTE (MELEE/2)+3; round down
(defn lvl->parry
  [lvl]
  (let [parry (quot (+ lvl 2) 3)]
    (if (pos? parry) parry 0)))

(defn melee-weapons-page
  []
  [:> view {:style (tw "flex flex-col gap-2 bg-white flex-grow p-2")}
   [header]

   (let [weapons (some-> (rf/subscribe [:items/melee-weapons]) deref)
         thr     (some-> (rf/subscribe [:attributes/damage-thrust]) deref)
         swg     (some-> (rf/subscribe [:attributes/damage-swing])  deref)
         weapon-skills  (some-> (rf/subscribe [:skills/weapons]) deref)
         weapon-parries (some-> (rf/subscribe [:defenses/parries]) deref)]
     ;; (log/info "melee-weapons-page" weapon-parries)
     (map-indexed
      (fn [i {:keys [name thr-mod swg-mod weight reach parry]}]
        (let [thr-ref (atom nil)
              swg-ref (atom nil)]
          ^{:key (str "weapon-" i)}
          [row
           ;; name
           [underlined-input {:val name
                              :on-change-text #(debounce-and-dispatch [:items.melee/update, i, :name, %] 500)}]
           ;; damage-thr
           [underlined-input {:val (dice-addition thr thr-mod)
                              :on-change-text (debounce (fn [e]
                                                          (rf/dispatch [:items.melee/update, i, :thr-mod, (->int e)])
                                                          (.clear ^js @thr-ref))
                                                        1000)
                              :get-ref    #(reset! thr-ref %)
                              :input-mode "numeric"
                              :max-length 3
                              :text-align "center"
                              :clear-on-input? true}]
           ;; damage-swg
           [underlined-input {:val (dice-addition swg swg-mod)
                              :on-change-text (debounce (fn [e]
                                                          (rf/dispatch [:items.melee/update, i, :swg-mod, (->int e)])
                                                          (.clear ^js swg-ref))
                                                        1000)
                              :get-ref    #(reset! swg-ref %)
                              :input-mode "numeric"
                              :max-length 3
                              :text-align "center"
                              :clear-on-input? true}]
           ;; reach
           [underlined-input {:val reach
                              :text-align "center"
                              :on-change-text #(rf/dispatch [:items.melee/update, i, :reach, %])}]

           ;; parry
           [dropdown {:val parry
                      :placeholder (when parry (str ((keyword parry) weapon-parries)))
                      :placeholder-style (tw "text-center text-xs")
                      :item-style (tw "capitalize")
                      :selected-style (tw "capitalize text-center")
                      :on-change #(rf/dispatch [:items.melee/update, i, :parry, %])
                      :data (->> weapon-skills (map #(do {:label (:name %) :value (:k %)})))}]

           ;; weight
           [underlined-input {:val weight
                              :input-mode "numeric"
                              :max-length 3
                              :text-align "center"
                              :on-change-text #(debounce-and-dispatch [:items.melee/update, i, :weight, (->int %)] 500)}]]))

      (conj weapons empty-weapon)))])

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
 :defenses/parries
 :<- [:skills/weapons]
 :<- [:skills/lvls]
 (fn [[skills skill-lvls]]
   (some->> skills
            (map #(:k %))
            (map #(do {% (lvl->parry (:lvl (% skill-lvls)))}))
            (into {}))))

(rf/reg-event-fx
 :items.melee/update
 (fn [{:keys [db]} [_ i k v]]
   (let [weapon (merge (get-in db [:items :melee-weapons i] empty-weapon) {k v})
         new-db (update-in db [:items :melee-weapons] (fnil #(do (assoc-in % [i] weapon)) [weapon]))]
     {:db new-db
      :effects.async-storage/set {:k     :items/melee-weapons
                                  :value (get-in new-db [:items :melee-weapons])}})))
