(ns app.app
  (:require
   ;; NOTE: Do NOT sort i18n-resources because it MUST be loaded first.
   [app.setup.i18n-resources :as i18n-resources]
   [app.common.async-storage.effects]
   [app.events]
   [app.subs]
   [app.effects]
   [app.utils.i18n :as i18n]
   [app.root :refer [root]]
   [expo.root :as expo-root]
   [re-frame.core :as rf]
   [reagent.core :as r]
   ["expo-splash-screen" :as splash-screen]
   ["expo-constants" :default expo-constants]))

;; Keep the splash screen visible while we fetch resources
(splash-screen/preventAutoHideAsync)

;; Make reagent create functional react components by default
(defonce functional-compiler (reagent.core/create-compiler {:function-components true}))
(reagent.core/set-default-compiler! functional-compiler)

(defn start
  {:dev/after-load true}
  []
  (i18n/set-language "en")
  (i18n-resources/load-language "en")
  (expo-root/render-root
   (r/as-element [root])))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (rf/dispatch-sync [:initialize-storage])
  (splash-screen/hideAsync) ;; TODO: This should be done after the resources are loaded
  (start))
