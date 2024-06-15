(ns gurps.pages.character.widgets.helpers
  (:require [re-frame.core :as rf]))

;; TODO: stop using this
(defn update-attribute
  [label value]
  (let [int-val (js/parseInt value)]
    (rf/dispatch [:attrs/update label int-val])))

(defn generify-key
  "Generates a generic keyword from the given keyword.
   If the input keyword has a namespace, it returns a keyword with the same namespace and the symbol :sp.
   Otherwise, it returns the input keyword unchanged."
  [k]
  (if (namespace k) (keyword (namespace k) :sp) k))

;; TODO: apply modifier functions
(def cost->points
  {;; primary
   :str {:incr 10 :modifier (fn [size] (js/Math.max -0.8 (* -0.1 size)))}
   :dex {:incr 20}
   :int {:incr 20}
   :ht  {:incr 10}
   ;; secondary
   :hp   {:incr 2}
   :will {:incr 5}
   :per  {:incr 5}
   :fp   {:incr 3}})

(def long-attr
  {:str :strength
   :dex :dexterity
   :int :intelligence
   :ht :health
   :fp :fatigue
   :hp :hitpoints
   :will :will
   :per :perception})
