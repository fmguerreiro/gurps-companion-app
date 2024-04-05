(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [reagent.core :as r]
            [gurps.widgets.base :refer [view text]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.pages.character.utils.skills :refer [skills]]))

(defn character-add-skill-spec-page
  [props]
  (r/with-let [skill-key (-> props ->clj :route :params :id str->key)
               skill (skill-key skills)
               specializations (:specializations skill)]
    [:> view
     (->> specializations
          (map (fn [spec]
                 [:> text {:key (str spec "-spec")} spec])))]))
