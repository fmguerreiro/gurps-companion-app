(ns gurps.utils.helpers)

(defn default-to [v default]
  "Returns the default value if the value is nil or empty"
  (if (or (and (seqable? v) (empty? v)) (nil? v))
    default
    v))
