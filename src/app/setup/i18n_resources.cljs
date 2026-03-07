(ns app.setup.i18n-resources
  (:require [clojure.string :as string]
            [cljs-bean.core :refer [->js]]
            [app.utils.i18n :as i18n]))

;; original code from
;; https://github.com/status-im/status-mobile/blob/4469717cc13b5c23ba687e085319e36e640e8b2d/src/status_im/setup/i18n_resources.cljs

(def default-device-language :en)

(def languages
  #{:en})

(defonce loaded-languages
  (atom
   (conj #{:en} default-device-language)))

(defn valid-language
  [lang]
  (if (contains? languages lang)
    (keyword lang)
    (let [parts         (string/split (name lang) #"[\-\_]")
          short-lang    (keyword (str (first parts) "_" (second parts)))
          shortest-lang (keyword (first parts))]
      (if (and (> (count parts) 2) (contains? languages short-lang))
        short-lang
        (when (contains? languages shortest-lang)
          shortest-lang)))))

(defn require-translation
  [lang-key]
  (when-let [lang (valid-language (keyword lang-key))]
    (case lang
      :en (js/require "../translations/en.json"))))

(def translations-by-locale
  (cond-> {:en (require-translation :en)}
    (not= :en default-device-language)
    (assoc default-device-language
           (require-translation (-> (name default-device-language)
                                    (string/replace "-" "_")
                                    keyword)))))

(i18n/setup (name default-device-language) (->js translations-by-locale))

(defn load-language
  [lang]
  (when-let [lang-key (valid-language (keyword lang))]
    (when-not (contains? @loaded-languages lang-key)
      (aset (i18n/get-translations)
            lang
            (require-translation lang-key))
      (swap! loaded-languages conj lang-key))))
