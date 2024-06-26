(ns gurps.utils.debounce
  (:require
   [goog.functions]
   [re-frame.core :as re-frame]))

;; NOTE: Taken from
;; https://github.com/status-im/status-mobile/blob/c02cc5d3915bd69fb416cf3a669bffbca97ded51/src/utils/debounce.cljs#L2

(def timeout (atom {}))

(defn clear
  [event-key]
  (when-let [event-timeout (get @timeout event-key)]
    (js/clearTimeout event-timeout)))

(defn clear-all
  []
  (doseq [[_ v] @timeout]
    (js/clearTimeout v)))

(defn debounce-and-dispatch
  "Dispatches `event` if it was not dispatched for the duration of `duration-ms`."
  [event duration-ms]
  (let [event-key (first event)]
    (clear event-key)
    (swap! timeout assoc event-key (js/setTimeout #(re-frame/dispatch event) duration-ms))))

(def throttle (atom {}))

(defn throttle-and-dispatch
  "Dispatches event and ignores subsequent calls for the duration of `duration-ms`."
  [event duration-ms]
  (let [event-key (first event)]
    (when-not (get @throttle event-key)
      (swap! throttle assoc event-key true)
      (js/setTimeout #(swap! throttle dissoc event-key) duration-ms)
      (re-frame/dispatch event))))

(defn debounce
  [f duration-ms]
  (goog.functions/debounce f duration-ms))
