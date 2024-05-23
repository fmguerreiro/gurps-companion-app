(ns gurps.widgets.add-button
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [gurps.widgets.base :refer [button text]]))

(defn add-button
  [{:keys [txt on-click]
    :or   {txt "+"}}]
  [:> button {:style (tw "p-0 w-14 h-14 bg-red-600 rounded-full hover:bg-red-700 active:shadow-lg shadow focus:outline-none align-middle justify-center items-center")
              :onPress on-click}
   [:> text {:style (tw "text-white font-bold text-xl")} txt]])
