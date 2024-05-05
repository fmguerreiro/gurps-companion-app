(ns gurps.pages.character.info.widgets.portrait
  (:require [gurps.widgets.base :refer [view button image]]
            ["twrnc" :refer [style] :rename {style tw}]
            ["expo-image-picker" :as picker]
            [re-frame.core :as rf]))

;; TODO: need to remove this, by annotating the js types in pick-image as recommended in:
;; https://cljs.github.io/api/cljs.core/STARwarn-on-inferSTAR
(set! *warn-on-infer* false)

(defn- pick-image []
  (-> (picker/requestMediaLibraryPermissionsAsync)
      (.then #(picker/launchImageLibraryAsync #js {:mediaTypes (.-Images picker/MediaTypeOptions)
                                                   :allowsEditing true
                                                   :aspect #js [4, 4]
                                                   :quality 1}))
      (.then #(when (not (.-canceled ^js %))
                (-> ^js % .-assets first .-uri)))
      (.then #(when % (rf/dispatch [:profile/update :portrait ^js/String %])))))

(defn portrait []
  (let [uri (some-> (rf/subscribe [:profile/portrait]) deref)]
    [:> view {:style (tw "flex items-center justify-center")}
     [:> button {:style (tw "w-50 h-50")
                 :onPress pick-image}
      [:> image {:style  (tw "w-50 h-50 bg-slate-200 border-2 border-slate-400 rounded-sm")
                 :source {:uri uri}}]]]))
