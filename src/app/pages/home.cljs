(ns app.pages.home
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["twrnc" :refer [style] :rename {style tw}]
            [app.utils.i18n :as i18n]
            [app.widgets.base :refer [view text]]
            [app.widgets.button :refer [button]]))

(defn home-page
  []
  (r/with-let [counter (rf/subscribe [:counter/value])]
    [:> view {:style (tw "flex-1 items-center justify-center bg-white")}
     [:> text {:style (tw "text-2xl font-bold mb-4")}
      (i18n/label :t/welcome)]
     [:> text {:style (tw "text-lg mb-8")}
      (str (i18n/label :t/counter) ": " @counter)]
     [button {:on-press #(rf/dispatch [:counter/increment])}
      (i18n/label :t/increment)]]))
