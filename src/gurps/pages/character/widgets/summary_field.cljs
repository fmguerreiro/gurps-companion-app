(ns gurps.pages.character.widgets.summary-field
  (:require [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.underlined-input :refer [labelled-underlined-input]]))

(defn summary-field
  [{:keys [key editable? style input-style text-align on-change-text input-mode max-length]
    :or   {editable? true, on-change-text identity}}]
  (let [val (some-> (rf/subscribe [(keyword :profile key)]) deref)]
    [labelled-underlined-input {:label (i18n/label (keyword :t key))
                                :val val
                                :on-change-text #(debounce/debounce-and-dispatch [:profile/update key (on-change-text %)] 800)
                                :text-align text-align
                                :max-length max-length
                                :input-mode input-mode
                                :disabled? (not editable?)
                                :input-style input-style
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
