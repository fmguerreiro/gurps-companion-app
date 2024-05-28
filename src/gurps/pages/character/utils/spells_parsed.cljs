(ns gurps.pages.character.utils.spells-parsed
  (:require [gurps.pages.character.utils.spells :refer [spells kebab-case]]
            [clojure.string :as s]))

(+ 1 2)

(defn- parse-spell-count
  [e]
  (if (and (string? e) (re-matches #"^\d+ .* spells?$" e))
    (let [[n college _] (clojure.string/split e #" ")]
      [(js/parseInt n) (keyword (clojure.string/lower-case college))])
    e))

(defn- parse-spell-lvl
  [e]
  (if (and (string? e) (re-matches #".*-\d+\+?$" e))
    (let [[spell lvl] (clojure.string/split e #"-")]
      [(-> spell kebab-case keyword) (js/parseInt lvl)])
    e))

;; (parse-spell-lvl "Body of Air-16+")
;; (parse-spell-lvl "Magery 2")
;; (parse-spell-lvl [4 :air])

;; (defn- parse-this-mess-and-hope-they-use-the-same-format-in-other-same-types-of-prerequisite-text
;;   "Takes '1 spell from each of 5 different colleges besides Air' as input
;;   => {:fire 1, :air 1, :water 1, :earth 1}"
;;   [e]
;;   (if (string? e)
;;     (let [[spell-from-each besides college] (clojure.string/split e #"besides")]
;;       [])
;;     e))

;; (clojure.string/split "1 spell from each of 5 different colleges besides Air" #"besides")

;; (parse-this-mess-and-hope-they-use-the-same-format-in-other-same-types-of-prerequisite-text "1 spell from each of 5 different colleges besides Air")

(->> gurps.pages.character.utils.spells/spells
     (map :prerequisites)
     (take 20)
     (map #(clojure.string/split % #"[,]|and|including|at least"))
     (map #(map clojure.string/trim %))
     (map #(filter (fn [e] (not (clojure.string/blank? e))) %))
     ;; catch "10 Air spells" sort of dependencies and codify it
     (map #(map parse-spell-count %))
     ;; codify "Body of Air-16+" type of dependencies
     (map #(map parse-spell-lvl %))
     ;; codify rest of dependencies
     (map #(map (fn [e] (if (vector? e) e (-> e kebab-case keyword))) %)))

(->> gurps.pages.character.utils.spells/spells
     (map #(merge % {:prerequisites (clojure.string/split (:prerequisites %) #"[,]|and|including|at least")}))
     (map #(merge % {:prerequisites (map clojure.string/trim (:prerequisites %))}))
     (map #(merge % {:prerequisites (filter (fn [e] (not (clojure.string/blank? e))) (:prerequisites %))}))
     ;; catch "10 Air spells" sort of dependencies and codify it
     (map #(merge % {:prerequisites (map parse-spell-count (:prerequisites %))}))
     ;; codify "Body of Air-16+" type of dependencies
     (map #(merge % {:prerequisites (map parse-spell-lvl (:prerequisites %))}))
     ;; codify rest of dependencies
     (map #(merge % {:prerequisites (map (fn [e] (if (vector? e) e (-> e kebab-case keyword))) (:prerequisites %))}))
     (map #(merge % {:prerequisites (vec (:prerequisites %))}))
     (map #(merge % {:name (-> (:name %) kebab-case keyword)})))



;; TODO (re-matches #"^\d+ .* spells?$" "1 spell from each of 5 different colleges besides Air")

(let [[spell lvl] (clojure.string/split (re-matches #".*-\d+\+?$" "Body of Air-16+") #"-")]
  [spell (js/parseInt lvl)])

(->> parsed-spells
     (map #(str "(def " (kebab-case (get % :name)) " " % ")")))
     ;; (map cljs.reader/read-string)

(->> spells
     (map #(merge % {:college (keyword (kebab-case (get % :college)))})))

(def colleges [:air :animal :body-control :communication-and-empathy :earth :enchantment :fire :gate :healing :illusion-and-creation :knowledge :light-and-darkness :making-and-breaking :meta-spell :mind-control :movement :necromantic :plant :protection-and-warning :sound :technological :water :weather :food])

(cljs.reader/read-string "(def air-jet {:name \"Air Jet\", :prerequisites \"Shape Air\", :prerequisite_count 3, :college \"Air\", :ref \"Magic p. 24\"})")

(count parsed-spells)
