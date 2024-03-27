(ns gurps.pages.character.skills
  (:require ["react-native" :as rn]
            ["@react-navigation/native" :as rnn]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view text input button]]
            [gurps.pages.character.widgets.skill-groups :refer [skill-groups]]))

(defn- header []
  [:> view {:className "flex flex-row gap-1 flex-grow items-center h-10"}
   [:> text {:className "font-bold text-start  w-6/12 capitalize"} "Name"]
   [:> text {:className "font-bold text-center w-2/12 break-normal overflow-visible capitalize"} "Level"]
   [:> text {:className "font-bold text-center w-3/12 capitalize"} "Relative Level"]
   [:> text {:className "w-3/12"} ""]])

(defn- row []
  [:> view {:className "flex flex-row gap-1 flex-grow bg-indigo-100"}
   ;; name
   [:> input {:className "border-b-1 border-black w-6/12"}]
   ;; level
   [:> input {:className "border-b-1 border-black w-2/12" :textAlign "center"}]
   ;; relative-level
   [:> input {:className "border-b-1 border-black w-3/12" :textAlign "center"}]
   ;; cost
   [:> view {:className "w-4 flex flex-row w-3/12 bg-green-200"}
    [:> text "["]
    [:> input {:className "" :textAlign "center"}]
    [:> text "]"]]])

(defn- add-skill-button
  [^js props]
  (js/console.log "add-skill-button")
  (if-let [navigation (rnn/useNavigation)]
    [:> view {:className ""}
     ;; TODO: put this button into a design library and use it here
     [:> button {:className "p-0 w-10 h-10 bg-red-600 rounded-full hover:bg-red-700 active:shadow-lg mouse shadow transition ease-in duration-200 focus:outline-none align-middle justify-center items-center"
                 :onPress (fn [] (-> navigation (.navigate (i18n/label :t/add-skill))))}
      [:> text {:className "text-white"} "+"]]]
    [:> text "else"]))

(defn character-skills-page
  [^js props]
  (r/with-let [a 5]
    ;; (if-let [navigation (rnn/useNavigation)]
    [:> rn/ScrollView
     [:> view {:className "flex bg-red-200 flex-column px-2"}
      [header]
      [row]
      [:> view {:className "absolute bottom-1 right-1"}
       [add-skill-button]]
      ;; [row]
      ;; [row]
      ]]))

;; TODO: put this in its own file
(defn character-add-skill-page
  [^js props]
  [:> view {:className "flex flex-column px-2"}
   [skill-groups]])
