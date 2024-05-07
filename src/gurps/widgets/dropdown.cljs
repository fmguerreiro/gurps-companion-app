(ns gurps.widgets.dropdown
  (:require ["react-native-element-dropdown" :refer [Dropdown]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn dropdown
  "Receives data in the format {:value 'hello' :label 'Hello', ...}"
  [{:keys [data placeholder style selected-style placeholder-style on-change disabled?]
    :or   {disabled? false, placeholder (some-> data first :label)}}]
  [:> Dropdown {:style #js [(tw "bg-white") style]
                :search false
                :placeholder placeholder
                :placeholderStyle #js [(tw "text-slate-400"), placeholder-style]
                :itemTextStyle #js [(tw "text-xs")]
                :selectedTextStyle #js [selected-style]
                :renderRightIcon (fn [] nil) ;; TODO
                :onChange #(on-change (.-value %))
                :labelField "label"
                :valueField "value"
                :disable (not disabled?)
                :data data}])
