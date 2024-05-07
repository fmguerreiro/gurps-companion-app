(ns gurps.pages.character.widgets.summary-field
  (:require [taoensso.timbre :refer [info]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [react-native.async-storage :as async-storage]
            [re-frame.core :as rf]
            ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]))

(defn- on-change-text
  [key val]
  (let [callback #(rf/dispatch [:profile/update key val])]
    (async-storage/set-item! (keyword :profile key) val callback)))

(defn summary-field
  [{:keys [key editable? style]
    :or   {editable? true}}]
  (let [val (some-> (rf/subscribe [(keyword :profile key)]) deref)]
    [:> view {:key key
              :style #js [style, (tw (str/join " " ["flex-row gap-1 bg-green-100" (if editable? "flex-1" "flex-initial")]))]}

     ;; label
     [:> text {:key (str key "-label")
               :style (tw "font-bold bg-red-100")}
      (i18n/label (keyword :t key))]

     ;; input
     (if editable?
       [underlined-input {:val val :on-change-text (debounce/debounce #(on-change-text key %) 800)}]
       [:> text {:style (tw "")} val])]))
