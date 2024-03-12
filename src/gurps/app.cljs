(ns gurps.app
  (:require
   ;; NOTE: Do NOT sort i18n-resources because it MUST be loaded first.
   [gurps.setup.i18n-resources :as i18n-resources]
   [gurps.events]
   [gurps.subs]
   [gurps.effects]
   [gurps.utils.i18n :as i18n]
   [gurps.root :refer [root]]
   [expo.root :as expo-root]
   [re-frame.core :as rf]
   [reagent.core :as r]
   ["expo-splash-screen" :as splash-screen]
   ["expo-constants" :default expo-contants]))

;; Keep the splash screen visible while we fetch resources
(splash-screen/preventAutoHideAsync)

(def storybook-enabled? (-> expo-contants
                            .-expoConfig
                            .-extra
                            .-storybookEnabled))

(def real-root (if (= storybook-enabled? "true")
                 nil
                 ;; TODO instead of 'nil, we should load the storybook root
                 ;; (do (require '["./.storybook"] :refer [default] :rename {default storybook})
                 ;;      storybook)
                 root))

(defn start
  {:dev/after-load true}
  []
  (i18n/set-language "en")
  (i18n-resources/load-language "en")
  (expo-root/render-root
   (r/as-element [real-root])))

(defn init []
  (rf/dispatch [:initialize-db])
  (rf/dispatch [:initialize-storage])
  (splash-screen/hideAsync) ;; TODO: This should be done after the resources are loaded
  (start))
