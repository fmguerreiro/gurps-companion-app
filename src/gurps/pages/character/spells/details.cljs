;; This page displays the details of a spell, including a description of the spell,
;; its prerequisites, and its effects.

(ns gurps.pages.character.spells.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            [cljs-bean.core :refer [->clj]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.pages.character.utils.spells :refer [spells-by-name]]
            [gurps.utils.i18n :as i18n]))

(defn- prerequisite
  [prereq nav]
  (cond (keyword? prereq) [:> button {:onPress #(-> nav (.navigate (i18n/label :t/spell-details) #js {:id (str prereq)}))}
                           [:> text (i18n/label (str "spell-" (symbol prereq)))]]
        :else [:<>]))

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(defn spell-details-page
  [props]
  (let [navigation (rnn/useNavigation)
        k          (-> props ->clj :route :params :id str->key)
        {:keys [ref prerequisites]} (k spells-by-name)]
    [:> view {:style (tw "bg-white p-2 flex flex-col gap-2 flex-grow")}
     [section (i18n/label :t/description)
      [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-description")))]]
     [section (i18n/label :t/cost)
      [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-base-cost")))]]
     [section (i18n/label :t/time-to-cast)
      [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-time-to-cast")))]]
     (when (seq ref)
       [section (i18n/label :t/reference) [:> text ref]])
     (when (seq prerequisites)
       [section (i18n/label :t/dependencies)
        (map-indexed (fn [idx prereq]
                       ^{:key (str "prereq-" idx)}
                       [prerequisite prereq navigation])
                     prerequisites)])]))
