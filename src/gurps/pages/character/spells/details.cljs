;; This page displays the details of a spell, including a description of the spell,
;; its prerequisites, and its effects.

(ns gurps.pages.character.spells.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            ["react-native" :as rn]
            [cljs-bean.core :refer [->clj]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.pages.character.utils.spells :refer [spells-by-name]]
            [gurps.utils.i18n :as i18n]
            [clojure.string :as str]))

(defn- lvl-prerequisite
  [prereq]
  (let [[skill level] prereq]
    [:> view {:style (tw "flex flex-row flex-grow justify-between")}
     [:> text {:style (tw "capitalize")} (-> skill name (str/replace #"-" " "))]
     [:> text level]]))

(defn- num-spells-prerequisite
  [prereq]
  (let [[num college] prereq]
    [:> view {:style (tw "flex flex-row flex-grow justify-between")}
     [:> text (i18n/label :t/num-spells {:college college :count num})]])) ;; TODO: add navigation button to college page

(defn- vec-prerequisite
  [prereq]
  (let [[first] prereq]
    (if (number? first)
      [num-spells-prerequisite prereq]
      [lvl-prerequisite prereq])))

(defn- spell-prerequisite
  [prereq nav]
  [:> button {:onPress #(-> nav (.push (i18n/label :t/spell-details) #js {:id (str (symbol prereq))}))}
   [:> view {:style (tw "flex flex-row flex-grow justify-between")}
    [:> text (i18n/label (str "spell-" (symbol prereq)))]
    [:> text {:style (tw "font-bold")} ">"]]])

(declare prerequisite) ;; used by or-prerequisite recursively

(defn- or-prerequisite
  [prereqs nav]
  [:> view {:style (tw "flex flex-col flex-grow gap-2")}
   [:> text {:style (tw "capitalize")} "Requires either:"]
   [:> view {:style (tw "flex flex-col gap-2 ml-2")}
    (map-indexed (fn [idx prereq]
                   ^{:key (str "prereq-" idx)}
                   [prerequisite prereq nav])
                 prereqs)]])

(defn- prerequisite
  [prereq nav]
  (cond (keyword? prereq) [spell-prerequisite prereq nav]
        (vector? prereq)  [vec-prerequisite prereq]
        (set? prereq)     [or-prerequisite prereq nav]
        :else             [:<>]))

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
    [:> rn/ScrollView {:style (tw "bg-white")}
     [:> view {:style (tw "bg-white p-2 flex flex-col gap-2 flex-grow")}
      [section (i18n/label :t/description)
       [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-description")))]]

      [section (i18n/label :t/type)
       [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-type")))]]

      (let [cost-key (keyword :t (str "spell-" (symbol k) "-cost"))]
        (when (i18n/has-label? cost-key)
          [section (i18n/label :t/cost)
           [:> text (i18n/label cost-key)]]))

      (let [time-key (keyword :t (str "spell-" (symbol k) "-time"))]
        (when (i18n/has-label? time-key)
          [section (i18n/label :t/time-to-cast)
           [:> text (i18n/label time-key)]]))

      (let [duration-key (keyword :t (str "spell-" (symbol k) "-duration"))]
        (when (i18n/has-label? duration-key)
          [section (i18n/label :t/duration)
           [:> text (i18n/label duration-key)]]))

      (when (seq ref)
        [section (i18n/label :t/reference) [:> text ref]])

      (when (seq prerequisites)
        [section (i18n/label :t/dependencies)
         (map-indexed (fn [idx prereq]
                        ^{:key (str "prereq-" idx)}
                        [prerequisite prereq navigation])
                      prerequisites)])]]))
