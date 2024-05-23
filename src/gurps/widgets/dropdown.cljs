(ns gurps.widgets.dropdown
  (:require ["react-native-element-dropdown" :refer [Dropdown]]
            ["twrnc" :refer [style] :rename {style tw}]
            ["@expo/vector-icons/Entypo" :default icon]
            [reagent.core :as r]))

(defn dropdown
  "Receives data in the format {:value 'hello' :label 'Hello', ...}"
  [{:keys [data placeholder style list-style item-style selected-style placeholder-style on-change disabled?]
    :or   {disabled? false, placeholder (some-> data first :label)}}]
  [:> Dropdown {:style #js [(tw "bg-white") style]
                :containerStyle #js [list-style]
                :search false
                :placeholder placeholder
                :placeholderStyle #js [(tw "text-slate-400"), placeholder-style]
                :itemTextStyle #js [(tw "text-xs"), item-style]
                :selectedTextStyle #js [selected-style]
                :renderRightIcon (fn [] (r/as-element [:> icon {:name "chevron-small-down" :size 20 :color (.-color (tw (if disabled? "text-slate-400" "text-black")))}]))
                :onChange #(on-change (.-value %))
                :labelField "label"
                :valueField "value"
                :disable disabled?
                :data data}])
