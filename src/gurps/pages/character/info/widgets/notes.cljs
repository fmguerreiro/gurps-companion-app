(ns gurps.pages.character.info.widgets.notes
  (:require [gurps.widgets.base :refer [view text]]
            [gurps.widgets.underlined-input :refer [multiline-underlined-input]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [clojure.string :as str]))

(def ^:private n-lines 6)

(defn notes-section []
  (let [notes (some-> (rf/subscribe [:profile/notes]) deref)]
    [:> view {:style (tw "flex flex-col gap-1")}
     [:> text {:style (tw "uppercase font-bold")} "NOTES"] ;; TODO: replace by heading widget ?
     [multiline-underlined-input {:val notes
                                  :on-change-text #(debounce-and-dispatch [:profile.notes/update, %1, %2] 500)
                                  :n-lines n-lines}]]))

(rf/reg-event-fx
 :profile.notes/update
 (fn [{:keys [db]} [_ i v]]
   (let [new-db (update-in db
                           [:profile :notes]
                           #(let [lines        (str/split-lines %)
                                  filled-lines (vec (concat lines (repeat (- n-lines (count lines)) "\n")))]
                              (str/join "\n" (assoc-in filled-lines [i] v))))]
     {:db                        new-db
      :effects.async-storage/set {:k     :profile/notes
                                  :value (get-in new-db [:profile :notes])}})))
