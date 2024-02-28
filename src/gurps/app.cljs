(ns gurps.app
  (:require
   ;; NOTE: Do NOT sort i18n-resources because it MUST be loaded first.
   [gurps.setup.i18n-resources :as i18n-resources]
   [gurps.events]
   [gurps.subs]
   [gurps.utils.i18n :as i18n]
   [gurps.root :refer [root]]
   [expo.root :as expo-root]
   [re-frame.core :as rf]
   [reagent.core :as r]))

(defn start
  {:dev/after-load true}
  []
  (i18n/set-language "en")
  (i18n-resources/load-language "en")
  (expo-root/render-root (r/as-element [root])))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (start))
