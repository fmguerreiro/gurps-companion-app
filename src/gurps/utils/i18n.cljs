(ns gurps.utils.i18n
  (:require ["i18n-js" :as i18n]
            [clojure.string :as string]))

;; original source:
;; https://github.com/status-im/status-mobile/blob/4469717cc13b5c23ba687e085319e36e640e8b2d/src/utils/i18n.cljs

(defn setup
  [default-device-language translations-by-locale]
  (set! (.-fallbacks i18n) true)
  (set! (.-defaultSeparator i18n) "/")
  (set! (.-locale i18n) default-device-language)
  (set! (.-translations i18n) translations-by-locale))

(.-translations i18n)

(defn get-translations [] (.-translations i18n))

(defn set-language [lang] (set! (.-locale i18n) lang))

(def delimeters
  "This function is a hack: mobile Safari doesn't support toLocaleString(), so we need to pass
  this map to WKWebView to make number formatting work."
  (let [n (.toLocaleString ^js (js/Number 1000.1))
        delimiter? (= (count n) 7)]
    (if delimiter?
      {:delimiter (subs n 1 2), :separator (subs n 5 6)}
      {:delimiter "", :separator (subs n 4 5)})))

(defn label-number
  [number]
  (when number
    (let [{:keys [delimiter separator]} delimeters]
      (.toNumber i18n
                 (string/replace number #"," ".")
                 (clj->js {:precision 10,
                           :strip_insignificant_zeros true,
                           :delimiter delimiter,
                           :separator separator})))))

(def default-option-value "<no value>")

(defn label-options
  [options]
  ;; i18n ignores nil value, leading to misleading messages
  (into {} (for [[k v] options] [k (or v default-option-value)])))

(defn label-fn
  "Returns the translation for the given path.
  If options are provided, they are used to interpolate the translation."
  ([path] (label-fn path {}))
  ([path options]
   (if (exists? (.t i18n))
     (let [options (update options :amount label-number)]
       (.t i18n (name path) (clj->js (label-options options))))
     (name path))))

(def label (memoize label-fn))

(defn label-pluralize
  [amount path & options]
  (if (exists? (.t i18n))
    (.p i18n amount (name path) (clj->js options))
    (name path)))

(def locale (.-locale i18n))
