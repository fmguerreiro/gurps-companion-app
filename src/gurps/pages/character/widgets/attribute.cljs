(ns gurps.pages.character.widgets.attribute
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.utils.helpers :refer [->int default-to]]
            [gurps.widgets.base :refer [view text input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.widgets.helpers :refer [cost->points]]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]))

(defn- calc-cost [label value]
  ;; (info "calc-cost" label value)
  (let [incr (:incr (label cost->points))
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

(defn key->i18n-label
  [key]
  (keyword :t (str "attr-" (symbol (long-attr key)))))

(defn attribute-input
  [^js {:keys [attr val cost current on-change-text secondary?]
        :or   {secondary? false}}]
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
                            :onChangeText (debounce/debounce #(on-change-text (->int %)) 500)
                            :placeholder (str val)}]))

   (when current
     [:> view
      [:> text {:style (tw "text-xs text-center w-14 capitalize font-bold absolute -top-4")}
       (i18n/label :t/current)]
      (box-border {:style (tw "bg-slate-100")}
                  ^{:key (str attr "-current")}
                  [:> input {:style (tw "text-2xl pb-1")
                             :keyboardType "numeric"
                             :onChangeText (debounce/debounce #(rf/dispatch [:attribute-current/update (keyword :attribute-current attr) (->int %)]) 500)
                             :placeholder (str (if current current val))}])])

   (when (and secondary? (nil? current))
     (box [:<>]))

   (box [bracketed-numeric-input {:on-change-text on-change-text
                                  :editable? secondary?
                                  :val (if secondary? (str cost) (calc-cost attr val))}])])
