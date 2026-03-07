(ns stories.helper
  (:require [cljs-bean.core :refer [->js ->clj]]
            [reagent.core :as reagent]))

(defn ->params [^js args]
  (->clj args :keywordize-keys true))

(defn ->reactified [options path]
  (if (get-in options path)
    (update-in options path reagent/reactify-component)
    options))

(defn ->default [options]
  (-> options
      (->reactified [:component])
      (->reactified [:parameters :docs :page])
      ->js))
