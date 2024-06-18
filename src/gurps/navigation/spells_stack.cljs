(ns gurps.navigation.spells-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view]]
            [gurps.widgets.character-icon :refer [character-icon]]
            [gurps.pages.character.spells.groups :refer [spell-groups-page]]
            [gurps.pages.character.spells.details :refer [spell-details-page]]
            [taoensso.timbre :as log]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(def header-title-style (tw "text-xl font-bold text-center capitalize"))

(defn- header-icon
  []
  (fn [] (r/as-element [:> view [character-icon]])))

(def options
  {:headerRight (header-icon)
   :headerTitleStyle header-title-style
   :headerTitleAlign "center"})

(defn spells-stack
  []
  (r/with-let [spell-group-component   (fn [props] (r/as-element [spell-groups-page props]))
               spell-details-component (fn [props] (r/as-element [spell-details-page props]))]
               ;; character-add-skill-spec-component (fn [props] (r/as-element [character-add-skill-spec-page props])

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/spells)
                       :component spell-group-component
                       :options   options}]

     [:> Stack.Screen {:name      (i18n/label :t/spell-details)
                       :component spell-details-component
                       :options   (fn [props]
                                    (let [id (-> ^js props .-route .-params .-id)]
                                      (->js
                                       (merge options
                                              {:title (i18n/label (keyword :t (str "spell-" id)))}))))}]]))

     ;; [:> Stack.Screen {:name      (i18n/label :t/add-skill-specialization)
     ;;                        :component character-add-skill-spec-component
     ;;                        :options    {:headerRight (header-icon)
     ;;                                    :headerTitleStyle header-title-style
     ;;                                    :headerTitleAlign "center"}}]
