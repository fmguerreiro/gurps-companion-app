(ns gurps.pages.character.widgets.summary-field
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [react-native.async-storage :as async-storage]
            [re-frame.core :as rf]))

(defn- on-change-text
  [fqn key val]
  (let [callback #(rf/dispatch [:profile/update key val])]
    (async-storage/set-item! fqn val callback)))

(defn- summary-field
  [^js {:keys [key max-size val]
        :or   {max-size "max"}}]
  (let [fqn   (keyword "profile" key)
        value (or val @(rf/subscribe [fqn]))]
    [:> view {:className "flex flex-row gap-2 justify-items-start flex-grow"}
     [:> text {:className "font-bold"} (i18n/label (keyword "t" key))]
     (if (some? val)
       [:> text {:className "border-b-2"} value]
       [:> input {:className (str "flex-grow border-b-2 bg-slate-100")
                  :onChangeText (debounce/debounce #(on-change-text fqn key %) 500)
                  ;; :onChangeText #(debounce/debounce-and-dispatch [:profile/update key %] 1000)}]]))
                  }
        value])]))
