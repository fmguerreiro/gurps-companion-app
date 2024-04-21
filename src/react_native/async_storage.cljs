(ns react-native.async-storage
  (:require
   ["@react-native-async-storage/async-storage" :default async-storage]
   [cognitect.transit :as transit]
   goog.functions
   [taoensso.timbre :as log]))

;; NOTE: Taken from
;; https://github.com/status-im/status-mobile/blob/33e637ff715a2ca5ef4527ec392861fff32fc672/src/react_native/async_storage.cljs#L4

(def ^:private debounce-ms 250)

(def ^:private reader (transit/reader :json))
(def ^:private writer (transit/writer :json))

(defn clj->transit
  [o]
  (transit/write writer o))

(defn transit->clj
  [o]
  (try
    (transit/read reader o)
    (catch :default e
      (log/error e))))

(defn set-item!
  ([k value] (set-item! k value identity))
  ([k value cb]
   (-> ^js async-storage
       (.setItem (str k)
                 (clj->transit value))
       (.then (fn [_] (cb)))
       (.catch (fn [error]
                 (log/error "[async-storage]" error))))))

(defn set-item-factory
  []
  (let [tmp-storage (atom {})
        debounced   (goog.functions/debounce (fn []
                                               (doseq [[k v] @tmp-storage]
                                                 (swap! tmp-storage dissoc k)
                                                 (set-item! k v)))
                                             debounce-ms)]
    (fn [items]
      (swap! tmp-storage merge items)
      (debounced))))

(defn- deflatten-db
  "Transforms {:attributes/str ...} => {:attributes {:str ...}}"
  [db]
  (reduce-kv
   (fn [acc k v] (assoc-in acc [(keyword (namespace k)) (keyword (name k))] v)) {} db))

(defn get-items
  [ks cb]
  (-> ^js async-storage
      (.multiGet (to-array (map str ks)))
      (.then (fn [^js data]
               (let [res (->> (js->clj data)
                              (map (comp transit->clj second))
                              (zipmap ks)
                              deflatten-db)]
                 ;; (log/info "[async-storage] post-process" res)
                 (cb res))))
      (.catch (fn [error]
                (cb nil)
                (log/error "[async-storage]" error)))))

(defn get-item
  [k cb]
  (-> ^js async-storage
      (.getItem (str k))
      (.then (fn [^js data]
               (-> data
                   js->clj
                   transit->clj
                   cb)))
      (.catch (fn [error]
                (cb nil)
                (log/error "[async-storage]" error)))))
