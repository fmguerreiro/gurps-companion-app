(ns gurps.pages.character.widgets.skill-groups
  (:require [reagent.core :as r]
            [gurps.widgets.base :refer [view text button]]))

(def difficulties {:e :easy :a :average :h :hard :v :very-hard})

(def groups [:animal :arts :athletics :business :combat-melee :combat-ranged :craft :criminal :invention :esoteric :everyman :knowledge :medical :military :science :occult :outdoors :plant :police :repair :scholar :social :humanities :spy :technical :transportation])

;; TODO: specializations
;; TODO: techlevel
(def skills {:animal {:animal-handling {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                      :falconry {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                              (fn [char]
                                                                (if-let [raptor-skill (get-in char [:skills :animal :animal-handling-raptor])]
                                                                  (- raptor-skill 3)))]} ;; TODO: raptor sub-skill
                      :mimicry {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]} ;; TODO animal sounds, bird calls, etc
                      :mount {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                      :naturalist {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)), (fn [char] (- (get-in char [:skills :science :biology]) 3))]}
                      :packing {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)), (fn [char] (- (get-in char [:skills :animal :animal-handling-equine]) 5))]}
                      :riding {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)), (fn [char] (- (get-in char [:skills :animal :animal-handling-equine]) 3))]}
                      :teamster {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:skills :animal :animal-handling]) 4)), (fn [char] (- (get-in char [:skills :animal :riding]) 2))]}
                      :veterinary {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:skills :animal :animal-handling]) 6)),
                                                                (fn [char] (- (get-in char [:skills :medical :physician]) 5)),
                                                                (fn [char] (- (get-in char [:skills :medical :surgery]) 5))]}}

             :arts {:artist {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                    :connoisseur {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                    :current-affairs {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)), (fn [char] (- (get-in char [:skills :scholar :research]) 4))]}
                    :dancing {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                    :electronics-op {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :invention :engineer :electrical]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :military :electronics-repair]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :invention :engineer :electronics]) 5))]}
                    :fire-eating {:diff :a :attr :dx :default []}
                    :group-performance {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                    :makeup {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)),
                                                          (fn [char] (- (get-in char [:skills :criminal :disguise]) 2))]}
                    :mimicry {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                    :musical-composition {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:skills :arts :musical-instrument]) 2)),
                                                                       (fn [char] (- (get-in char [:skills :arts :poetry]) 2))]}
                    :musical-instrument {:diff :h :attr :iq :default []}
                    :performance {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                               (fn [char] (- (get-in char [:skills :social :acting]) 2)),
                                                               (fn [char] (- (get-in char [:skills :business :public-speaking]) 2))]}
                    :photography {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                               (fn [char] (- (get-in char [:skills :arts :electronics-op]) 2))]}
                    :poetry {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                          (fn [char] (- (get-in char [:skills :arts :writing]) 2))]}
                    :singing {:diff :e :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 4))]}
                    :sleight-of-hand {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :criminal :filch]) 5))]}
                    :stage-combat {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :athletic :combat-art]) 2)),
                                                                (fn [char] (- (get-in char [:skills :athletic :sports]) 2)),
                                                                (fn [char] (- (get-in char [:skills :arts :performance]) 3))]}
                    :ventriloquism {:diff :h :attr :iq :default []}
                    :writing {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}}

             :athletic {:acrobatics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :aeronautics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :aquabatics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :bicycling {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :vehicle :driving :motorcycle]) 4))]}
                        :body-sense {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6)),
                                                                  (fn [char] (- (get-in char [:skills :athletic :acrobatics]) 3))]}
                        :breath-control {:diff :h :attr :ht :default []}
                        :climbing {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                        ;; :combat-art :: TODO: fukin varies?
                        :flight {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :free-fall {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)),
                                                                 (fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :hiking {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :jumping {:diff :e :attr :dx :default []}
                        :lifting {:diff :a :attr :ht :default []}
                        :mount {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                        :parachuting {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))]}
                        :running {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :scuba {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                             (fn [char] (- (get-in char [:skills :technical :diving-suit]) 2))]}
                        :sports {:diff :a :attr :dx :default []} ;; TODO: fuking special?
                        :swimming {:diff :e :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 4))]}
                        :throwing {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 3))
                                                                (fn [char] (- (get-in char [:skills :combat-ranged :dropping]) 2))]}}

             :business {:accounting {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                  (fn [char] (- (get-in char [:skills :business :finance]) 4)),
                                                                  (fn [char] (- (get-in char [:skills :business :mathematics-statistics]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :business :merchant]) 5))]}
                        :administration {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                      (fn [char] (- (get-in char [:skills :business :merchant]) 3))]}
                        :current-affairs-business {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)),
                                                                                (fn [char] (- (get-in char [:skills :scholarly :research]) 4))]}
                        :diplomacy {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                 (fn [char] (- (get-in char [:skills :business :politics]) 6))]}
                        :economics {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                 (fn [char] (- (get-in char [:skills :business :finance]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :business :market-analysis]) 5)),
                                                                 (fn [char] (- (get-in char [:skills :business :merchant]) 6))]}
                        :finance {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:skills :business :merchant]) 6)),
                                                               (fn [char] (- (get-in char [:skills :business :accounting]) 4)),
                                                               (fn [char] (- (get-in char [:skills :business :economics]) 3))]}
                        :law {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                        :market-analysis {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                       (fn [char] (- (get-in char [:skills :business :economics]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :business :merchant]) 4))]}
                        :mathematics-statistics {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                        :merchant {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                (fn [char] (- (get-in char [:skills :business :finance]) 6)),
                                                                (fn [char] (- (get-in char [:skills :business :market-analysis]) 4))]}
                        :politics {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                (fn [char] (- (get-in char [:skills :business :diplomacy]) 5))]}
                        :public-speaking {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :business :politics]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :social :acting]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :arts :performance]) 2))]}
                        :savoir-faire-high-society {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4))]} ;; TODO: and others?
                        }})
(defn- keyword->str
  [keyword]
  (clojure.string/replace (str (name keyword)) #"-" " "))

(defn skill-groups []
  [:> view {:className "w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-white"}
   (for [group groups]
     [:> view {:key (str group "-view")}
      [:> text {:key group
                :className "font-bold capitalize"}
       (keyword->str group)]
      (for [skill (-> skills group keys)]
        [:> button {:key (str skill "-btn")
                    :className "w-full px-4 py-2 font-medium text-left rtl:text-right border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"}
         [:> text {:key skill :className "capitalize"}
          (keyword->str skill)]])])])
