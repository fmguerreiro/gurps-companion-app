(ns gurps.pages.character.advantages.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->clj]]
            [gurps.pages.character.utils.advantages :refer [advantages-by-name]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.base :refer [view text scroll-view]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.utils.i18n :as i18n]
            [re-frame.core :as rf]))

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(defn advantage-details-page
  [props]
  (let [id  (-> props ->clj :route :params :id str->key)
        adv (id advantages-by-name)
        advantages (some-> (rf/subscribe [:advantages]) deref)]
    [:> view {:style (tw "bg-white flex flex-col grow")}
     [scroll-view {:style (tw "bg-white")
                   :contentContainerStyle (tw "bg-white p-2 flex flex-col grow gap-2")}

      [section (i18n/label :t/type)
       [:> text (i18n/label (keyword :t (str "advantage-" (symbol id) "-type")))]]

      [section (i18n/label :t/cost)
       [:> text (i18n/label (keyword :t (str "advantage-" (symbol id) "-cost")))]]

      [section (i18n/label :t/description)
       [:> text (i18n/label (keyword :t (str "advantage-" (symbol id) "-description")))]]]

     (when (not (id advantages))
       [:> view {:style (tw "absolute bottom-4 right-4")}
        [add-button {:on-click #(rf/dispatch [:advantages/add id adv])}]])]))

(rf/reg-event-fx
 :advantages/add
 (fn [{:keys [db]} [_ id {cost :cost}]]
   (let [cost'  (cond (coll? cost) (first cost), (= :variable cost) 0, :else cost)
         new-db (update-in db [:advantages id] (fnil #(conj % {:cost cost' :lvl 1}) {}))]
     {:db new-db
      :effects.async-storage/set {:k     :advantages
                                  :value (get-in new-db [:advantages])}})))
