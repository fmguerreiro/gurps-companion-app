(ns gurps.pages.character.widgets.summary-field
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [react-native.async-storage :as async-storage]
            [re-frame.core :as rf]
            ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]))

(defn- on-change-text
  [key val]
  (let [callback #(rf/dispatch [:profile/update key val])]
    (async-storage/set-item! (keyword :profile key) val callback)))

(defn summary-field
  [{:keys [key editable?]
    :or   {editable? true}}]
  (let [val (some-> (rf/subscribe [(keyword :profile key)]) deref)]
    [:> view {:key key :style (tw (str/join " " ["flex-row gap-1 bg-green-100" (if editable? "flex-1" "grow-0")]))}

     [:> text {:key (str key "-label")
               :style (tw "font-bold bg-red-100")}
      (i18n/label (keyword :t key))]

     [:> input {:key (str key "-value")
                :style (tw "border-b-2 flex-1")
                :onChangeText (debounce/debounce #(on-change-text key %) 500)
                :placeholder (str val)}]]))

;; (defn summary-field
;;   [{:keys [key val editable? rows]
;;     :or   {editable? true, rows 1}}]
;;   (let [fqn   (keyword :profile key)
;;         value (or val (some-> (rf/subscribe [fqn]) deref))]
;;     [:> view {:style (tw )(str "flex flex-row gap-1 justify-items-start bg-blue-100"
;;                               (if editable? "flex-grow" "flex-none"))}
;;      ;; label
;;      [:> text {:style (tw )"font-bold"} (i18n/label (keyword :t key))]

;;      ;; value
;;      (if (not editable?)
;;        [:> text {:style (tw )"border-b-2 flex-none"} value]
;;        [:> input {:style (tw )(str "border-b-2 flex-1 bg-slate-100")
;;                   :editable editable?
;;                   :rows rows
;;                   :multiline (> rows 1)
;;                   :onChangeText (debounce/debounce #(on-change-text fqn key %) 500)
;;                   :placeholder value}])]))
