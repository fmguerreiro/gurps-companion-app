;; This page displays the details of a spell, including a description of the spell,
;; its prerequisites, and its effects.

(ns gurps.pages.character.spells.details
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native" :as rnn]
            ["react-native" :as rn]
            [cljs-bean.core :refer [->clj]]
            [gurps.utils.helpers :refer [str->key ->int]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.pages.character.utils.spells :refer [spells-by-name spells-to-colleges]]
            [gurps.pages.character.widgets.helpers :refer [long-attr]]
            [gurps.utils.i18n :as i18n]
            [clojure.string :as str]
            [re-frame.core :as rf]
            [taoensso.timbre :as log]))

(defn- key->i18n-label
  [key]
  (let [name (name key)
        type (namespace key)]
    (cond (= "attributes" type) (str "attr-" (str (symbol (get long-attr (keyword name)))))
          (= "advantages" type) (str "advantage-" name)
          (= "skills" type) (str "skill-" name)
          (= "tl" name) "tech-level"
          :else (str "spell-" (str/join "-" (filter some? [type name])))))) ;; TODO: make clickable

(defn- lvl-prerequisite
  [spell-k prereq]
  (let [[k lvl]         prereq
        prereq-cleared? (some-> (rf/subscribe [:spell/clears-prereq? k lvl]) deref)]
    (rf/dispatch [:spells/update-prerequisites spell-k (keyword (name k)) prereq-cleared?])
    [:> view {:style (tw (str "flex flex-row flex-grow justify-between"
                              (when prereq-cleared? " bg-green-100")))}
     [:> text (i18n/label (keyword :t (key->i18n-label k)))]
     [:> text lvl]]))

(rf/reg-sub
 :spell/clears-prereq?
 :<- [:spells]
 :<- [:advantages]
 :<- [:skills/lvls]
 (fn [[spells advantages skills] [_ k lvl]]
   (let [type (keyword (namespace k))
         name (keyword (name k))]
     (>= (cond (= :advantages type) (get-in advantages [name :lvl])
               (= :skills type) (get-in skills [name :lvl])
               :else (get-in spells [name :lvl]))
         lvl))))

(defn- num-spells-k
  [num college]
  (keyword (str (symbol college) "-" num)))

(defn- num-spells-prerequisite
  [k prereq]
  (let [[num college]   prereq
        spell-count     (some-> (rf/subscribe [:spells/count-per-college]) deref college)
        prereq-cleared? (>= spell-count num)]
    (rf/dispatch [:spells/update-prerequisites k (num-spells-k num college) prereq-cleared?])
    [:> view {:style (tw (str "flex flex-row flex-grow justify-between")
                         (when prereq-cleared? " bg-green-100"))}
     [:> text (i18n/label :t/num-spells {:college college :count num})]])) ;; TODO: add navigation button to college page

(rf/reg-sub
 :spells/count-per-college
 :<- [:spells]
 (fn [spells]
   (->> spells ;; => {:warmth {:lvl 12}, :golem {:lvl 9}, ...}
        (reduce
         (fn [acc [k _]]
           (assoc-in acc [k] (k spells-to-colleges)))
         {})   ;; => {:warmth #{:fire :protection-and-warning}, :golem #{:enchantment :plant}} TODO: '(:fire ...) instead of set, not sure if problem
        (reduce
         (fn [acc [_ vs]]
           (reduce (fn [acc v]
                     (update-in acc [v] (fnil inc 0)))
                   acc
                   vs))
         {})))) ;; => {:fire 1, :enchantment 1, :plant 1, :protection-and-warning 1}

(declare prerequisite) ;; used by all-prerequisite/or-prerequisite recursively

(defn- all-prerequisite
  [k prereqs nav]
  [:> view {:style (tw "flex flex-col flex-grow gap-2")}
   [:> text {:style (tw "capitalize")} (i18n/label :t/requires-all)]
   [:> view {:style (tw "flex flex-col gap-2 ml-2")}
    (map-indexed (fn [idx prereq]
                   ^{:key (str "prereq-" idx)}
                   [prerequisite k prereq nav])
                 prereqs)]])

(defn- vec-prerequisite
  [k prereq nav]
  (let [[first second] prereq]
    (cond (number? first)   [num-spells-prerequisite k prereq]
          (keyword? second) [all-prerequisite k prereq nav]
          (vector? first)   (all-prerequisite k prereq nav)
          :else             [lvl-prerequisite k prereq])))

(def ^:private spell-from-colleges-pattern #"\d+-spell-from-\d+-colleges")

(defn- spell-count-from-colleges
  [k prereq]
  (let [[spell-count _ _ college-count] (str/split (-> prereq symbol str) #"-")
        passing-college-count           (some->> (rf/subscribe [:spells/count-per-college])
                                                 deref
                                                 (filter #(>= (val %) (->int spell-count)))
                                                 count)
        prereq-cleared?                 (>= passing-college-count (->int college-count))]
    (rf/dispatch [:spells/update-prerequisites k prereq prereq-cleared?])
    [:> text {:style (str ""
                          (when prereq-cleared? " bg-green-100"))}
     (i18n/label :t/num-colleges {:colleges college-count :count (->int spell-count)})]))

(defn- has-spell-prerequisite
  [k prereq nav]
  (let [spell (some-> (rf/subscribe [:spells]) deref prereq)
        ;; e.g. advantages/magery -> advantage, skills/writing -> skill
        type  (or (some-> prereq namespace (str/replace #"s$" "")) "spell")
        name  (name prereq)]
    (rf/dispatch [:spells/update-prerequisites k prereq (some? spell)])
    [:> button {:onPress #(-> nav (.push (i18n/label (keyword :t (str type "-details"))) #js {:id name}))}
     [:> view {:style (tw (str "flex flex-row flex-grow justify-between items-center"
                               (when spell " bg-green-100")))}
      [:> text (i18n/label (keyword :t (key->i18n-label prereq)))]
      [:> text {:style (tw "font-bold mb-0.5")} ">"]]]))

(defn- spell-prerequisite
  [k prereq nav]
  (if (re-matches spell-from-colleges-pattern (-> prereq symbol str))
    [spell-count-from-colleges k prereq]
    ;; else it's one spell
    [has-spell-prerequisite k prereq nav]))

(defn- or-prerequisite
  [k prereqs nav]
  [:> view {:style (tw "flex flex-col flex-grow gap-2")}
   [:> text {:style (tw "capitalize")} (i18n/label :t/requires-either)]
   [:> view {:style (tw "flex flex-col gap-2 ml-2")}
    (map-indexed (fn [idx prereq]
                   ^{:key (str "prereq-" idx)}
                   [prerequisite k prereq nav])
                 prereqs)]])

(defn- prerequisite
  [k prereq nav]
  (cond (keyword? prereq) [spell-prerequisite k prereq nav]
        (vector? prereq)  [vec-prerequisite k prereq nav]
        (set? prereq)     [or-prerequisite k prereq nav]
        :else             [:<>]))

(defn- section
  [label children]
  [:> view {:style (tw "flex flex-col gap-2")}
   [:> text {:style (tw "font-bold capitalize")} label]
   children])

(defn spell-details-page
  [props]
  (let [navigation (rnn/useNavigation)
        k          (-> props ->clj :route :params :id str->key)
        {:keys [ref prerequisites]} (k spells-by-name)
        can-purchase?               (some-> (rf/subscribe [:spells/can-purchase? k]) deref)]
    (log/info "spell-details-page" k)
    [:> rn/ScrollView {:style (tw "bg-white") :contentContainerStyle (tw "grow")}
     [:> view {:style (tw "bg-white p-2 flex flex-col grow gap-2")}
      [section (i18n/label :t/description)
       [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-description")))]]

      [section (i18n/label :t/type)
       [:> text (i18n/label (keyword :t (str "spell-" (symbol k) "-type")))]]

      (let [cost-key (keyword :t (str "spell-" (symbol k) "-cost"))]
        (when (i18n/has-label? cost-key)
          [section (i18n/label :t/cost)
           [:> text (i18n/label cost-key)]]))

      (let [time-key (keyword :t (str "spell-" (symbol k) "-time"))]
        (when (i18n/has-label? time-key)
          [section (i18n/label :t/time-to-cast)
           [:> text (i18n/label time-key)]]))

      (let [duration-key (keyword :t (str "spell-" (symbol k) "-duration"))]
        (when (i18n/has-label? duration-key)
          [section (i18n/label :t/duration)
           [:> text (i18n/label duration-key)]]))

      (when (seq ref)
        [section (i18n/label :t/reference) [:> text ref]])

      (when (seq prerequisites)
        [section (i18n/label :t/dependencies)
         (map-indexed (fn [idx prereq]
                        ^{:key (str "prereq-" idx)}
                        [prerequisite k prereq navigation])
                      prerequisites)])

      (when can-purchase?
        [:> view {:style (tw "absolute bottom-4 right-4")}
         [add-button {:on-click #(rf/dispatch [:spells/add k])}]])]]))

(defn remove-keys
  [key-set data]
  (clojure.walk/prewalk
   (fn [node]
     (if (map? node)
       (apply dissoc node key-set)
       node))
   data))

(rf/reg-event-fx
 :spells/add
 (fn [{:keys [db]} [_ k]]
   (log/info "spells/add" k)
   (let [new-db (assoc-in db [:spell-costs k :cost] 1)]
     {:db new-db
      :effects.async-storage/set {:k     :spell-costs
                                  :value (remove-keys [:prereqs] (get-in new-db [:spell-costs]))}})))

(rf/reg-event-db
 :spells/update-prerequisites
 (fn [db [_ spell-k prereq-k prereq-cleared?]]
   (assoc-in db [:spell-costs spell-k :prereqs prereq-k] prereq-cleared?)))

(defn- meets-prerequisites?
  [prereq->cleared? prereqs]
  (let [ps (if (and (coll? prereqs) (= 1 (count prereqs))) (first prereqs) prereqs)]
    (cond (keyword? ps) (get prereq->cleared? ps false)
          (vector? ps)  (let [[first second] ps]
                          (cond (number? first)       (get prereq->cleared? (num-spells-k first second) false)
                                (or (keyword? second)
                                    (vector? first))  (->> ps
                                                           (map #(meets-prerequisites? prereq->cleared? %))
                                                           (filter false?)
                                                           count
                                                           (= 0))
                                :else                 (get prereq->cleared? (keyword (name first)) false)))
          (set? ps)     (->> ps
                             (map #(meets-prerequisites? prereq->cleared? %))
                             (map true?)
                             count
                             pos?)
          :else             true)))

(rf/reg-sub
 :spells/can-purchase?
 :<- [:spell-costs]
 (fn [spell-costs [_ spell-k]]
   (if (> (get-in spell-costs [spell-k :cost] 0) 0)
     ;; if spell already purchased, dont show add button
     false
     ;; else, do requirement checks
     (let [prereqs (get-in spell-costs [spell-k :prereqs])]
       (or (nil? prereqs) ;; no prereqs
           (meets-prerequisites? prereqs (get-in spells-by-name [spell-k :prerequisites])))))))

(comment
  (def prereqs [#{:keen-vision [5 :light-and-darkness]}])
  (def prereq->cleared? {:heat true,
                         :warmth false,
                         :keen-vision true,
                         :light-and-darkness-5 true})

  {:cook {:prereqs {:test-food true, :create-fire true}},
   :seek-fire {:cost 1},
   :know-recipe {:prereqs {:far-tasting true, :season true}},
   :essential-food {:prereqs {:create-food true, :food-6 true}, :cost 1},
   :seek-water {:cost 1},
   :water-to-wine {:prereqs {:purify-water true, :mature true}},
   :mature {:prereqs {:season true, :decay false}, :cost 1}, :seek-food {:cost 1}, :season {:prereqs {:test-food true}}, :far-tasting {:prereqs {:magery false, :seek-food true, :seek-air false}}, :ignite-fire {:cost 1}, :create-food {:prereqs {:cook true, :seek-food true}}, :test-food {:cost 1}, :create-fire {:prereqs {:seek-fire true, :ignite-fire true}, :cost 1}, :seek-air {:cost 1}, :purify-water {:prereqs {:seek-water true}, :cost 1}}

  (defn- debug
    [exp & tag]
    (println tag exp)
    exp)

  (meets-prerequisites? prereq->cleared? prereqs))
