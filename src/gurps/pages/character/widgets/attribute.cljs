(ns gurps.pages.character.widgets.attribute
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.utils.helpers :refer [->int default-to]]
            [gurps.widgets.base :refer [view text input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.widgets.helpers :refer [cost->points long-attr]]
            ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]))

(defn- calc-cost [label value]
  ;; (info "calc-cost" label value)
  (let [incr (:incr (label cost->points))
        val  (default-to value 10)]
    (* incr (- val 10))))

(defn- box
  [{:keys [style]} children]
  [:> view {:style #js [(tw "h-12 items-center justify-center flex-row"), (if style style (tw "w-12"))]}
   children])

(defn- box-border
  [^js {:keys [style key]} & children]
  [:> view {:key key :style #js [(tw "h-12 w-12 align-middle border-2 items-center justify-center"), style]}
   children])

(defn key->t
  [key]
  (->> key
       list
       flatten
       (map #(i18n/label (keyword :t (str "attr-" (some-> % long-attr symbol)))))
       (str/join "/")))

(defn attribute-input
  [^js {:keys [attr val cost current on-change-text secondary? style]
        :or   {secondary? false}}]
  [:> view {:style #js [(tw "flex flex-row flex-grow gap-1"), style]}
   (box {:style (tw (str "justify-start ") (if secondary? "w-10" "w-8"))}
        [:> text {:style (tw "text-xl font-bold")}
         (key->t attr)])

   (if secondary?
     (box-border {:key attr} [:> text {:key attr :style (tw "text-xl")} val])
     (box-border {:style (tw "bg-slate-100")}
                 [:> input {:key attr
                            :style (tw "text-xl")
                            :maxLength 3
                            :keyboardType "numeric"
                            :onChangeText (debounce/debounce #(on-change-text (->int %)) 500)
                            :placeholder (str val)}]))

   (when current
     [:> view
      [:> text {:style (tw "text-xs text-center w-12 capitalize font-bold absolute -top-4")}
       (i18n/label :t/current)]
      (box-border {:style (tw "bg-slate-100")}
                  ^{:key (str attr "-current")}
                  [:> input {:style (tw "text-xl pb-1")
                             :keyboardType "numeric"
                             :textAlign "center"
                             :onChangeText #(debounce/debounce-and-dispatch [:attribute-current/update (keyword :attribute-current attr) (->int %)] 500)
                             :placeholder (str (if current current val))}])])

   (when (and secondary? (nil? current))
     (box {:style (tw "w-12")}
          [:<>]))

   (box (when secondary? {:style (tw "w-12")})
        [bracketed-numeric-input {:on-change-text on-change-text
                                  :editable? secondary?
                                  :val (if secondary? (str cost) (calc-cost attr val))}])])
