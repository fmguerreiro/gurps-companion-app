(ns gurps.pages.character.widgets.summary-field
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.underlined-input :refer [underlined-input labelled-underlined-input]]
            [re-frame.core :as rf]))

(defn summary-field
  [{:keys [key editable? style input-style text-align on-change-text]
    :or   {editable? true, on-change-text identity}}]
  (let [val (some-> (rf/subscribe [(keyword :profile key)]) deref)]
    [labelled-underlined-input {:label (i18n/label (keyword :t key))
                                :val val
                                :on-change-text #(debounce/debounce-and-dispatch [:profile/update key (on-change-text %)] 800)
                                :text-align text-align
                                :disabled? (not editable?)
                                :style style}]))
    ;; [:> view {:key key
    ;;           :style #js [style, (tw (str/join " " ["flex-row gap-1" (if editable? "flex-1" "flex-initial")]))]}

    ;;  ;; label
    ;;  [:> text {:key (str key "-label")
    ;;            :style (tw "font-bold")}
    ;;   (i18n/label (keyword :t key))]

    ;;  ;; input
    ;;  (if editable?
    ;;    [underlined-input {:val val
    ;;                       :on-change-text #(debounce/debounce-and-dispatch [:profile/update key (on-change-text %)] 800)
    ;;                       :style input-style
    ;;                       :text-align text-align}]
    ;;    [:> text val])]
