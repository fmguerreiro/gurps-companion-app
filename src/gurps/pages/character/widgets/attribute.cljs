(ns gurps.pages.character.widgets.attribute
  (:require [taoensso.timbre :refer [info]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.widgets.base :refer [view text input]]))

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
  (info "calc-cost" label value)
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
  (keyword "t" (str "attr-" (symbol (long-attr key)))))

(defn attribute
  [^js {:keys [attr val cost current on-change-text has-current-space? secondary?]
        :or   {has-current-space? false secondary? false}}]
  (info "attribute" (str attr) val cost)

  [:> view {:className "flex flex-row gap-0"}
   (box
    [:> text {:className "text-2xl font-bold"} (i18n/label (key->i18n-label attr))])

   (if secondary?
     (box-border {:key attr} [:> text {:key attr :className "text-2xl"} val])
     (box-border {:className "bg-slate-100"}
                 [:> input {:key attr
                            :className "text-2xl"
                            :maxLength 3
                            :keyboardType "numeric"
                            :onChangeText (debounce/debounce #(on-change-text %) 500)} val]))

   (when (some? current)
     [:> view
      [:> text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
       (i18n/label :t/current)]
      (box-border [:> input {:className "text-2xl bg-slate-100"} current])])
   (when (and secondary? has-current-space?)
     (box [:<>]))

   (box [:> view {:className "flex flex-row items-center justify-items-center align-items-center"}
         [:> text {:className "text-xl font-bold"} "["]
         (if secondary?
           [:> input {:className "text-xl font-bold bg-slate-200" ;; TODO center
                      :maxLength 3
                      :keyboardType "numeric"
                      :onChangeText (debounce/debounce #(on-change-text %) 500)} cost]
           [:> text {:className "text-xl font-bold"} (calc-cost attr val)])
         [:> text {:className "text-xl font-bold"} "]"]])])
