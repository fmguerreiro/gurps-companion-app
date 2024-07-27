(ns gurps.pages.character.items.defenses-section
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.utils.i18n :as i18n]))

(defn labelled-box
  [label & children]
  [:> view {:style (tw "flex flex-col gap-1 pb-1 items-center border-2 border-black flex-grow")}
   [:> text {:style (tw "uppercase font-bold")} label]
   children])

(defn- dr-box
  []
  [labelled-box (i18n/label :t/dr)
   (let [defenses (some-> (rf/subscribe [:profile/defenses]) deref)]
     ^{:key "defenses-dr-view"}
     [:> view {:style (tw "flex flex-col")}
      (for [kv (seq defenses)]
        ^{:key (str "defense-dr-" (key kv))}
        [:> view {:style (tw "flex flex-row w-full gap-1 justify-center h-5")}
         ^{:key (str "defense-dr-label-" (key kv))}
         [:> text {:style (tw "flex-1 text-right justify-end")}
          (i18n/label (keyword :t (key kv)))]
         ^{:key (str "defense-dr-input-" (key kv))}
         [:> view {:style (tw "flex-1")}
          [underlined-input {:val         (val kv)
                             :style       (tw "w-1/2 justify-start")
                             :text-align  "center"
                             :disabled?   true}]]])])])

(defn defenses-section
  []
  [:> view {:style (tw "flex flex-row gap-1")}
   ;; dr
   ^{:key "defenses-dr"}
   [:> view {:style (tw "flex-1")}
    [dr-box]]

   ;; parry
   ^{:key "defenses-parry"}
   [:> view {:style (tw "flex-1")}
    [labelled-box (i18n/label :t/parry)
     (let [parry (some-> (rf/subscribe [:defenses/highest-parry]) deref)]
       ^{:key "defense-parry-label"}
       [:> text {:style (tw "text-3xl font-bold my-auto pb-2")} parry])]]

   ;; block
   ^{:key "defenses-block"}
   [:> view {:style (tw "flex-1")}
    [labelled-box (i18n/label :t/block)
     (let [block (some-> (rf/subscribe [:defenses/highest-block]) deref)]
       ^{:key "defense-block-label"}
       [:> text {:style (tw "text-3xl font-bold my-auto pb-2")} block])]]])

(defn- sum-dr
  [items location]
  (reduce (fn [acc item] (+ acc (:dr item))) 0 (filter #(= (:location %) location) items)))

(rf/reg-sub
 :profile/defenses
 :<- [:items/possessions]
 (fn [possessions]
   {:head (sum-dr possessions "head")
    :torso (sum-dr possessions "torso")
    :arm (sum-dr possessions "arm")
    :hand (sum-dr possessions "hand")
    :leg (sum-dr possessions "leg")
    :foot (sum-dr possessions "foot")}))

(rf/reg-sub
 :defenses/highest-parry
 :<- [:defenses/parries]
 (fn [parries]
   (or (apply max (vals parries)) 0)))

(defn lvl->block
  "Blocking is an is 3 + half Shield or Cloak skill, dropping all fractions"
  [lvl]
  (-> lvl
      (/ 2)
      (Math/floor)
      (+ 3)))

(rf/reg-sub
 :defenses/blocks
 :<- [:skills/shields]
 :<- [:skills/lvls]
 (fn [[skills skill-lvls]]
   (some->> skills
            (map #(:k %))
            (map #(do {% (lvl->block (:lvl (% skill-lvls)))}))
            (into {}))))

(rf/reg-sub
 :defenses/highest-block
 :<- [:defenses/blocks]
 (fn [blocks]
   (or (apply max (vals blocks)) 0)))
