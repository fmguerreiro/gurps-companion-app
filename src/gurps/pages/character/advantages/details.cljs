(ns gurps.pages.character.advantages.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->clj]]
            [gurps.pages.character.utils.advantages :refer [advantages-by-name]]
            [gurps.pages.character.utils.disadvantages :refer [disadvantages-by-name]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.base :refer [view text scroll-view]]
            [gurps.utils.helpers :refer [str->key singularize-key]]
            [gurps.utils.i18n :as i18n]
            [re-frame.core :as rf]))

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(:reprogrammable disadvantages-by-name)

(defn advantage-details-page
  [props type]
  (let [id         (-> props ->clj :route :params :id str->key)
        by-name    (if (= type :advantages) advantages-by-name disadvantages-by-name)
        advantages (some-> (rf/subscribe [type]) deref)]
    [:> view {:style (tw "bg-white flex flex-col grow")}
     [scroll-view {:style (tw "bg-white")
                   :contentContainerStyle (tw "bg-white p-2 flex flex-col grow gap-2")}

      [section (i18n/label :t/type)
       [:> text (i18n/label (keyword :t (str (singularize-key type) "-" (symbol id) "-type")))]]

      [section (i18n/label :t/cost)
       [:> text (i18n/label (keyword :t (str (singularize-key type) "-" (symbol id) "-cost")))]]

      [section (i18n/label :t/description)
       [:> text (i18n/label (keyword :t (str (singularize-key type) "-" (symbol id) "-description")))]]]

     (when (not (id advantages))
       [:> view {:style (tw "absolute bottom-4 right-4")}
        [add-button {:on-click #(rf/dispatch [(keyword type :add) id (id by-name)])}]])]))
