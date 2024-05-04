(ns gurps.pages.character.widgets.attribute
  (:require [cljs-bean.core :refer [->clj]]
            [taoensso.timbre :refer [info]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.widgets.base :refer [view text input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            ["twrnc" :refer [style] :rename {style tw}]))

;; TODO: apply modifier functions
(def value-per-lvl
  {;; primary
   :str {:incr 10 :modifier (fn [size] (js/Math.max -0.8 (* -0.1 size)))}
   :dex {:incr 20}
   :int {:incr 20}
   :ht  {:incr 10}
   ;; secondary
   :hp   {:incr 2}
   :will {:incr 5}
   :per  {:incr 5}
   :fp   {:incr 3}})

(defn- calc-cost [label value]
  ;; (info "calc-cost" label value)
  (let [incr (:incr (label value-per-lvl))
        val  (default-to value 10)]
    (* incr (- val 10))))

(defn- box
  [children]
  [:> view {:style (tw "h-14 w-14 items-center justify-center flex-row")}
   children])

(defn- box-border
  [^js {:keys [style key]} & children]
  [:> view {:key key :style #js [(tw "h-14 w-14 align-middle border-2 items-center justify-center"), style]}
   children])

(def long-attr
  {:str :strength
   :dex :dexterity
   :int :intelligence
   :ht :health
   :fp :fatigue
   :hp :hitpoints
   :will :will
   :per :perception})

(defn key->i18n-label [key]
  (keyword :t (str "attr-" (symbol (long-attr key)))))

(defn attribute-input
  [^js {:keys [attr val cost current on-change-text has-current-space? secondary?]
        :or   {has-current-space? false secondary? false}}]
  [:> view {:style (tw "flex flex-row gap-0")}
   (box
    [:> text {:style (tw "text-2xl font-bold")}
     (i18n/label (key->i18n-label attr))])

   (if secondary?
     (box-border {:key attr} [:> text {:key attr :style (tw "text-2xl")} val])
     (box-border {:style (tw "bg-slate-100")}
                 [:> input {:key attr
                            :style (tw "text-2xl")
                            :maxLength 3
                            :keyboardType "numeric"
                            :onChangeText (debounce/debounce #(on-change-text %) 500)
                            :placeholder (str val)}]))

   (when (some? current)
     [:> view
      [:> text {:style (tw "text-xs text-center w-14 capitalize font-bold absolute -top-4")}
       (i18n/label :t/current)]
      (box-border [:> input {:style (tw "text-2xl bg-slate-100")} current])])

   (when (and secondary? has-current-space?)
     (box [:<>]))

   (box [bracketed-numeric-input {:on-change-text on-change-text
                                  :editable? secondary?
                                  :val (if secondary? (str cost) (calc-cost attr val))}])])
