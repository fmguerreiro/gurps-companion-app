(ns gurps.pages.character.info.widgets.reaction-modifiers-section
  (:require [gurps.widgets.base :refer [view text]]
            [gurps.widgets.underlined-input :refer [labelled-underlined-input labelled-multiline-underlined-input]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [re-frame.core :as rf]
            [taoensso.timbre :as log]
            [clojure.string :as str]))

(defn appearance-input
  []
  (let [val (some-> (rf/subscribe [:profile/appearance]) deref)]
    [labelled-underlined-input {:label          (i18n/label :t/appearance)
                                :val            val
                                :on-change-text #(debounce-and-dispatch [:profile/update :appearance %] 500)}]))

(defn status-input
  []
  (let [val (some-> (rf/subscribe [:profile/status]) deref)]
    [labelled-underlined-input {:label          (i18n/label :t/status)
                                :val            val
                                :on-change-text #(debounce-and-dispatch [:profile/update :status %] 500)}]))

(def reputation-n-lines 4)

(defn reputation-input
  []
  (let [val (some-> (rf/subscribe [:profile/reputation]) deref)]
    [labelled-multiline-underlined-input {:label          (i18n/label :t/reputation)
                                          :val            val
                                          :on-change-text #(debounce-and-dispatch [:profile.reputation/update %1 %2] 500)
                                          :n-lines        reputation-n-lines}]))
(rf/reg-event-fx
 :profile.reputation/update
 (fn [{:keys [db]} [_ i v]]
   (let [new-db (update-in db
                           [:profile :reputation]
                           #(let [j            (if (nil? v) 0 (inc i)) ;; HACK: should clean up API of multiline-underlined-input instead
                                  val          (if (nil? v) i v)
                                  lines        (str/split-lines %)
                                  filled-lines (vec (concat lines (repeat (- reputation-n-lines (count lines)) "\n")))]
                              (str/join "\n" (assoc-in filled-lines [j] val))))]
     {:db                        new-db
      :effects.async-storage/set {:k     :profile/reputation
                                  :value (get-in new-db [:profile :reputation])}})))

(defn reaction-modifiers-section []
  [:> view {:style (tw "flex flex-col gap-1")}
   [:> text {:style (tw "text-center font-bold capitalize")} (i18n/label :t/reaction-modifiers)]

   [appearance-input]

   [status-input]

   [reputation-input]])
