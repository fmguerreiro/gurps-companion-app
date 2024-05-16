(ns gurps.pages.character.items.ranged-weapons-page
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [->int]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.base :refer [view text]]
            [gurps.utils.debounce :refer [debounce-and-dispatch debounce]]))

(defn ranged-weapons-page
  [])
