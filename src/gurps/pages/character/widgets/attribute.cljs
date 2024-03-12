(ns gurps.pages.character.widgets.attribute
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.widgets.base :refer [view text input]]))

;; TODO: apply modifier functions
(def value-per-lvl
  {;; primary
   :t/attr-strength     {:incr 10 :modifier (fn [size]
                                              (js/Math.max -0.8 (* -0.1 size)))}
   :t/attr-dexterity    {:incr 20}
   :t/attr-intelligence {:incr 20}
   :t/attr-health       {:incr 10}
   ;; secondary
   :t/attr-hitpoints    {:incr 2}
   :t/attr-will         {:incr 5}
   :t/attr-perception   {:incr 5}
   :t/attr-fatigue      {:incr 3}})

(defn- calc-cost [label value]
  (let [incr (:incr (label value-per-lvl))
        val  (default-to value 10)]
    (* incr (- val 10))))

(defn- box
  [children]
  [:> view {:className "h-14 w-14 items-center justify-center flex-row"} children])

(defn- box-border
  [^js {:keys [className key]} & children]
  [:> view {:key key :className (str "box-border h-14 w-14 align-middle border-2 items-center justify-center " className)}
   children])

(defn attribute
  [^js {:keys [label val cost current on-change-text has-current-space? secondary?]
        :or   {has-current-space? false secondary? false}}]
  (js/console.log (str label) val cost)
  [:> view {:className "flex flex-row gap-0"}
   (box
    [:> text {:className "text-2xl font-bold"} (i18n/label label)])

   (if (not secondary?)
     (box-border {:className "bg-slate-100"}
                 [:> input {:key label
                            :className "text-2xl"
                            :maxLength 3
                            :keyboardType "numeric"
                            :onChangeText (debounce/debounce #(on-change-text %) 500)} val])
     (box-border {:key label} [:> text {:key label :className "text-2xl"} val]))

   (when (some? current)
     [:> view
      [:> text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
       (i18n/label :t/current)]
      (box-border [:> input {:className "text-2xl bg-slate-100"} current])])
   (when (and secondary? has-current-space?)
     (box [:<>]))

   (box [:> view {:className "flex flex-row items-center justify-items-center align-items-center"}
         [:> text {:className "text-xl font-bold"} "["]
         (if (not secondary?)
           [:> text {:className "text-xl font-bold"} (calc-cost label val)]
           [:> input {:className "text-xl font-bold bg-slate-200" ;; TODO center
                      :maxLength 3
                      :keyboardType "numeric"
                      :onChangeText (debounce/debounce #(on-change-text %) 500)}
            cost])
         [:> text {:className "text-xl font-bold"} "]"]])])
