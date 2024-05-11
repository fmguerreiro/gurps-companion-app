(ns gurps.pages.character.items.defenses-section
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view text]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.utils.i18n :as i18n]
            [taoensso.timbre :as log]))

(defn labelled-box
  [label & children]
  [:> view {:style (tw "flex flex-col gap-1 pb-1 items-center border-2 border-black flex-grow")}
   [:> text {:style (tw "uppercase font-bold")} label]
   children])

(defn defenses-section
  []
  [:> view {:style (tw "flex flex-row gap-1")}
   ;; dr
   ^{:key "defenses-dr"}
   [:> view {:style (tw "w-1/3")}
    [labelled-box (i18n/label :t/dr)
     (let [defenses (some-> (rf/subscribe [:profile/defenses]) deref)]
       ^{:key "defenses-dr-view"}
       [:> view {:style (tw "flex flex-col")}
        (for [kv (seq defenses)]
          ^{:key (str "defense-dr-" (key kv))}
          [:> view {:style (tw "flex flex-row gap-2")}
           ^{:key (str "defense-dr-label-" (key kv))}
           [:> text {:style (tw "w-2/4 text-right")} (i18n/label (keyword :t (key kv)))]
           ^{:key (str "defense-dr-input-" (key kv))}
           [underlined-input {:val         (val kv)
                              :style       (tw "w-2/4")
                              :text-align  "center"
                              :disabled?   true}]])])]]
   ;; parry
   ^{:key "defenses-parry"}
   [:> view {:style (tw "w-1/3")}
    [labelled-box (i18n/label :t/parry)
     (let [parry (some-> (rf/subscribe [:defenses/parry]) deref)]
       ^{:key "defense-parry-label"}
       [:> text {:style (tw "text-3xl font-bold my-auto pb-2")} parry])]]

   ;; block
   ^{:key "defenses-block"}
   [:> view {:style (tw "w-1/3 pr-2")}
    [labelled-box (i18n/label :t/block)
     (let [block (some-> (rf/subscribe [:defenses/block]) deref)]
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

;; TODO (MELEE-skill/2)+3; round down
(rf/reg-sub
 :defenses/parry
 (fn [] 0))

;; TODO: Blocking is an is 3 + half Shield or Cloak skill, dropping all fractions
(rf/reg-sub
 :defenses/block
 (fn [] 0))
