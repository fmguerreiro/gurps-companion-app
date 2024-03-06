(ns gurps.events.profile)

(defmacro generate-profile-sub [param]
  `(rf/reg-sub
    ~(keyword "profile" param)
    :<- [(keyword "profile")]
    (fn [db _]
      (~(keyword param) db))))
