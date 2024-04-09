(ns gurps.pages.character.skills.specialization
  (:require [cljs-bean.core :refer [->clj]]
            [reagent.core :as r]
            [gurps.widgets.base :refer [view text]]
            [gurps.utils.helpers :refer [str->key]]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.utils.skills :refer [skills skill->txt]]))

(defn character-add-skill-spec-page
  [props]
  (r/with-let [skill-key (-> props ->clj :route :params :id str->key)
               skill (skill-key skills)
               specializations (:specializations skill)]
    [:> view
     [:> text (i18n/label (keyword "t" (str "skill-description-" (symbol (if (some? (namespace skill-key)) (namespace skill-key) (name skill-key))))))]
     (->> specializations
          (map (fn [spec]
                 (let [display-text (skill->txt spec)]
                   [:> text {:key (str spec "-spec")} display-text]))))]))
