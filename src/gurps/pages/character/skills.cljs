(ns gurps.pages.character.skills
  (:require ["react-native" :as rn]
            ["@react-navigation/native" :as rnn]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [taoensso.timbre :refer [info]]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view text input button]]
            [gurps.utils.helpers :refer [flatten-key]]
            [gurps.pages.character.utils.skills :refer [skills]]
            [gurps.pages.character.widgets.skill-groups :refer [skill-groups]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn- header []
  [:> view {:style (tw "flex flex-row flex-1 gap-1 flex-grow items-center h-10")}
   [:> text {:style (tw "font-bold text-start  w-6/12 capitalize")} "Name"]
   [:> text {:style (tw "font-bold text-center w-2/12 break-normal overflow-visible capitalize")} "Level"]
   [:> text {:style (tw "font-bold text-center w-3/12 capitalize")} "Relative Level"]
   [:> text {:style (tw "w-3/12")} ""]])

(defn- row-cost
  []
  [:> view {:style (tw "w-4 flex flex-row w-3/12 bg-green-200")}
   [:> text "["] [:> input {:style (tw "") :textAlign "center"}] [:> text "]"]])

(defn- row []
  [:> view {:style (tw "flex flex-row gap-1 flex-grow bg-indigo-500")}
   ;; name
   [:> input {:style (tw "border-b-1 border-black w-6/12")}]
   ;; level
   [:> input {:style (tw "border-b-1 border-black w-2/12") :textAlign "center"}]
   ;; relative-level
   [:> input {:style (tw "border-b-1 border-black w-3/12") :textAlign "center"}]
   ;; cost
   [row-cost]])

(defn- add-skill-button
  [^js props]
  (if-let [navigation (rnn/useNavigation)]
    [:> view {:style (tw "")}
     ;; TODO: put this button into a design library and use it here
     [:> button {:style (tw "p-0 w-10 h-10 bg-red-600 rounded-full hover:bg-red-700 active:shadow-lg mouse shadow transition ease-in duration-200 focus:outline-none align-middle justify-center items-center")
                 :onPress (fn [] (-> navigation (.navigate (i18n/label :t/add-skill))))}
      [:> text {:style (tw "text-white")} "+"]]]
    [:> text "else"]))

(defn character-skills-page
  [^js props]
  (r/with-let [a 5] ;; TODO
    ;; (if-let [navigation (rnn/useNavigation)]
    [:> view {:style (tw "flex flex-1 bg-red-200 flex-column px-2")}
     [:> rn/ScrollView {:style (tw "flex flex-1 flex-column flex-grow bg-indigo-200")}
      [header]
      [row]]
     [:> view {:style (tw "absolute bottom-2 right-2")}
      [add-skill-button]]]))

;; TODO: put this in its own file
(defn character-add-skill-page
  [^js props]
  [:> view {:style (tw "flex flex-column px-2")}
   [skill-groups]])

;; register all skill-cost subs
(doseq [skill (keys skills)]
  (when (not (= "sp" (name skill)))
    (let [skill-key (flatten-key skill)]
      ;; (info "registering sub" (str (keyword :skill-costs skill-key)))
      (rf/reg-sub
       (keyword :skill-costs skill-key)
       (fn [db _]
         (get-in db [:skill-costs skill-key] 0))))))
