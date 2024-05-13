(ns gurps.utils.helpers)

(defn default-to
  "Returns the default value if the value is nil or empty"
  [v default]
  (if (or (and (seqable? v) (empty? v)) (nil? v))
    default
    v))

(defn ->int
  [n]
  (let [ret (js/parseInt n)]
    (if (js/isNaN ret)
      0
      ret)))

(defn str->key
  [str]
  (keyword str))

(defn key->str
  [key]
  (str (symbol key)))

(defn flatten-key
  [key]
  (symbol
   (if (some? (namespace key))
     (str (namespace key) "-" (name key))
     (str (name key)))))

;; NOTE: because 'positions has vanished from clojure.contrib.seq
(defn positions
  [pred coll]
  (keep-indexed (fn [idx x]
                  (when (pred x)
                    idx))
                coll))
