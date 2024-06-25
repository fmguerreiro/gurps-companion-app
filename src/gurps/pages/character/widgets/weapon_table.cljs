(ns gurps.pages.character.widgets.weapon-table)

(def weapons
  [{:id :axe :dmg [{:sw+2 :cut}] :reach 1 :parry :0u :cost 50 :weight 4 :st 11 :tl 0 :skill :axe-or-mace}
   {:id :hatchet :dmg [{:sw :cut}] :reach 1 :parry :0 :cost 40 :weight 2 :st 8 :tl 0 :skill :axe-or-mace}
   {:id :throwing-axe :dmg [{:sw+2 :cut}] :reach 1 :parry :0u :cost 60 :weight 4 :st 11 :tl 0 :skill :axe-or-mace}
   {:id :mace :dmg [{:sw+3 :cr}] :reach 1 :parry :0u :cost 50 :weight 5 :st 12 :tl 2 :skill :axe-or-mace}
   {:id :small-mace :dmg [{:sw+2 :cr}] :reach 1 :parry :0u :cost 35 :weight 3 :st 10 :tl 2 :skill :axe-or-mace}
   {:id :pick :dmg [{:sw+1 :imp}] :reach 1 :parry :0u :cost 70 :weight 3 :st 10 :tl 3 :skill :axe-or-mace}

   {:id :punch :dmg [{:thr-1 :cr}] :reach :c :parry :0 :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing, :brawling, :karate, :dx]}
   {:id :brass-knuckles :dmg [{:thr :cr}] :reach :c :parry :0 :cost 10 :weight 0.25 :st 0 :tl 0 :skill [:boxing, :brawling, :karate, :dx]}

   {:id :kick :dmg [{:thr :cr}] :reach :c-1 :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing-2, :karate-2, :dx-2]}
   {:id :kick-w-boots :dmg [{:thr+1 :cr}] :reach :c-1 :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing-2, :karate-2, :dx-2]}

   {:id :blunt-teeth :dmg [{:thr-1 :cr}] :reach :c :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing, :dx]}
   {:id :fangs :dmg [{:thr-1 :imp}] :reach :c :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing, :dx]}
   {:id :sharp-beak :dmg [{:thr-1 :pi+}] :reach :c :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing, :dx]}
   {:id :sharp-teeth :dmg [{:thr-1 :cut}] :reach :c :parry :no :cost 0 :weight 0 :st 0 :tl 0 :skill [:boxing, :dx]}
   {:id :blackjack :dmg [{:thr :cr}] :reach :c :parry :0 :cost 20 :weight 1 :st 7 :tl 1 :skill [:boxing, :dx]}
   {:id :sap :dmg [{:thr :cr}] :reach :c :parry :0 :cost 20 :weight 1 :st 7 :tl 1 :skill [:boxing, :dx]}
   {:id :stun-gun :dmg [{:ht-3 :cr}] :reach :c-1 :parry :no :cost 100 :weight 1 :st 2 :tl 8 :skill [:boxing, :dx]}

   {:id :light-club :dmg [{:sw+1 :cr}, {:thr+1 :cr}] :reach :1 :parry :0 :cost 5 :weight 3 :st 10 :tl 0 :skill :broadsword}
   {:id :broadsword :dmg [{:sw+1 :cut}, {:thr+1 :cr}] :reach :1 :parry :0 :cost 500 :weight 3 :st 10 :tl 2 :skill :broadsword}
   {:id :thrusting-broadsword :dmg [{:sw+1 :cr}, {:thr+2 :imp}] :reach :1 :parry :0 :cost 600 :weight 3 :st 10 :tl 2 :skill :broadsword}
   {:id :bastard-sword :dmg [{:sw+1 :cut}, {:thr+1 :cr}] :reach [:1-2, :2] :parry :0u :cost 650 :weight 5 :st 11 :tl 3 :skill :broadsword}
   {:id :katana :dmg [{:sw+1 :cut}, {:thr+1 :imp}] :reach [:1-2, :1] :parry :0 :cost 650 :weight 5 :st 11 :tl 3 :skill :broadsword}
   {:id :thrusting-bastard-sword :dmg [{:sw+1 :cut}, {:thr+2 :imp}] :reach [:1-2, :2] :parry :0u :cost 750 :weight 5 :st 11 :tl 3 :skill :broadsword}
   {:id :cavalry-saber :dmg [{:sw+1 :cut}, {:thr+1 :imp}] :reach :1 :parry :0 :cost 500 :weight 3 :st 10 :tl 4 :skill :broadsword}

   {:id :morningstar :dmg [{:sw+3 :cr}] :reach :1 :parry :0u :cost 80 :weight 6 :st 12 :tl 3 :skill :flail}
   {:id :nunchaku :dmg [{:sw+1 :cr}] :reach :1 :parry :0u :cost 20 :weight 2 :st 7 :tl 3 :skill :flail}

   {:id :force-sword :dmg [{:8d :burn}] :reach :1-2 :parry :0 :cost 10000 :weight 2 :st 3 :tl 10 :skill :force-sword}

   {:id :garrote :dmg [:spec] :reach :c :parry :no :cost 2 :weight 0 :st 0 :tl 0 :skill :garrote}

   {:id :large-knife :dmg [{:sw-2 :cut}, {:thr :imp}] :reach [:c-1, :c] :parry :-1 :cost 40 :weight 1 :st 6 :tl 0 :skill :knife}
   {:id :small-knife :dmg [{:sw-3 :cut}, {:thr-1 :imp}] :reach [:c-1, :c] :parry :-1 :cost 30 :weight 0.5 :st 5 :tl 0 :skill :knife}
   {:id :wooden-stake :dmg [{:thr :imp}] :reach :c :parry :-1 :cost 4 :weight 0.5 :st 5 :tl 0 :skill :knife}
   {:id :dagger :dmg [{:thr-1 :imp}] :reach :c :parry :-1 :cost 20 :weight 0.25 :st 5 :tl 1 :skill :knife}

   {:id :kusari :dmg [{:sw+2 :cr}] :reach :1-4 :parry :-2u :cost 70 :weight 5 :st 11 :tl 3 :skill :kusari}

   {:id :lance :dmg [{:thr+3 :imp}] :reach :4 :parry :no :cost 60 :weight 6 :st 12 :tl 2 :skill :lance}

   {:id :monowire-whip :dmg [{:sw+1d-2 :cut}] :reach :1-7 :parry :-2u :cost 900 :weight 0.5 :st 5 :tl 13 :skill :monowire-whip}

   {:id :glaive :dmg [{:sw+3 :cut}, {:thr+3 :imp}] :reach [:2-3, :1-3] :parry :0u :cost 100 :weight 8 :st 11 :tl 1 :skill :polearm}
   {:id :naginata :dmg [{:sw+2 :cut}, {:thr+3 :imp}] :reach [:1-2, :2] :parry [:0u, :0] :cost 100 :weight 6 :st 9 :tl 2 :skill :polearm}
   {:id :halberd :dmg [{:sw+5 :cut}, {:sw+4 :imp}, {:thr+4 :imp}] :reach [:2-3, :2-3, :1-3] :parry :0u :cost 150 :weight 12 :st 13 :tl 3 :skill :polearm}
   {:id :poleaxe :dmg [{:sw+4 :cut}, {:sw+4 :cr}] :reach [:2-3, :2-3] :parry [:0u, :0u] :cost 120 :weight 10 :st 12 :tl 3 :skill :polearm}

   {:id :rapier :dmg [{:thr+1 :imp}] :reach [:1-2] :parry [:0f] :cost 500 :weight 2.75 :st 9 :tl 4 :skill :rapier}

   {:id :saber :dmg [{:sw-1 :imp}, {:thr+1 :imp}] :reach [:1, :1] :parry [:0f, :0f] :cost 700 :weight 2 :st 8 :tl 4 :skill :saber}

   {:id :shield-bash :dmg [{:thr :cr}] :reach [:1] :parry [:no] :cost :var :weight :var :st 0 :tl 0 :skill :shield}
   {:id :shield-bash-w-spike :dmg [{:thr+1 :cr}] :reach [:1] :parry [:no] :cost :var :weight :var :st 0 :tl 1 :skill :shield}

   {:id :baton :dmg [{:sw :cr}, {:thr :cr}] :reach [:1] :parry [:0] :cost 20 :weight 1 :st 6 :tl 0 :skill :shortsword}
   {:id :shortsword :dmg [{:sw :cut}, {:thr :cr}] :reach [:1] :parry [:0] :cost 400 :weight 2 :st 8 :tl 2 :skill :shortsword}
   {:id :cutlass :dmg [{:sw :cut}, {:thr :cr}] :reach [:1] :parry [:0] :cost 300 :weight 2 :st 8 :tl 4 :skill :shortsword}
   {:id :cattle-prod :dmg [{:1d-3 :burn}, {:ht-3 :aff}] :reach [:1] :parry [:0] :cost 50 :weight 2 :st 3 :tl 7 :skill :shortsword}

   {:id :short-staff :dmg [{:sw :cr}, {:thr :cr}] :reach [:1] :parry [:0f] :cost 20 :weight 1 :st 6 :tl 0 :skill :smallsword}
   {:id :smallsword :dmg [{:thr+1 :imp}] :reach [:1] :parry [:0f] :cost 400 :weight 1.5 :st 5 :tl 4 :skill :smallsword}

   {:id :spear :dmg [{:thr+2 :imp}, {:thr+3 :imp}] :reach [:1, :1-2] :parry [:0] :cost 40 :weight 4 :st 9 :tl 0 :skill :spear}
   {:id :javelin :dmg [{:thr+1 :imp}] :reach [:1] :parry [:0] :cost 30 :weight 2 :st 6 :tl 1 :skill :spear}
   {:id :long-spear :dmg [{:thr+2 :imp}, {:thr+3 :imp}] :reach [:2-3, :2-3] :parry [:0u, :0] :cost 60 :weight 5 :st 10 :tl 2 :skill :spear}

   {:id :quarterstaff :dmg [{:sw+2 :cr}, {:thr+2 :cr}] :reach [:1-2] :parry [:+2] :cost 10 :weight 4 :st 7 :tl 0 :skill :staff}
   {:id :naginata :dmg [{:sw+2 :cr}, {:thr+2 :cr}] :reach [:1-2] :parry [:0u, :0] :cost 100 :weight 6 :st 9 :tl 2 :skill :staff}

   {:id :maul :dmg [{:sw+4 :cr}] :reach [:1-2] :parry [:0u] :cost 80 :weight 12 :st 13 :tl 0 :skill :two-handed-axe-or-mace}
   {:id :great-axe :dmg [{:sw+3 :cut}] :reach [:1-2] :parry [:0u] :cost 100 :weight 8 :st 12 :tl 1 :skill :two-handed-axe-or-mace}
   {:id :scythe :dmg [{:sw+2 :cut}, {:sw :imp}] :reach [:1] :parry [:0u] :cost 15 :weight 5 :st 11 :tl 1 :skill :two-handed-axe-or-mace}
   {:id :warhammer :dmg [{:sw+3 :imp}] :reach [:1-2] :parry [:0u] :cost 100 :weight 7 :st 12 :tl 3 :skill :two-handed-axe-or-mace}
   {:id :chainsaw :dmg [{:sw+1d :cut}] :reach [:1] :parry [:no] :cost 150 :weight 13 :st 10 :tl 6 :skill :two-handed-axe-or-mace}

   {:id :flail :dmg [{:sw+4 :cr}] :reach [:1-2] :parry [:0u] :cost 100 :weight 8 :st 13 :tl 2 :skill :two-handed-flail}

   {:id :quarterstaff :dmg [{:sw+2 :cr}, {:thr+1 :cr}] :reach [:1-2, :2] :parry [:0] :cost 10 :weight 4 :st 9 :tl 0 :skill :two-handed-sword}
   {:id :naginata :dmg [{:sw+3 :cut}, {:thr+3 :imp}] :reach [:2] :parry [:0u, :0] :cost 100 :weight 6 :st 9 :tl 2 :skill :two-handed-sword}
   {:id :bastard-sword :dmg [{:sw+2 :cut}, {:thr+2 :cr}] :reach [:1-2, :2] :parry [:0] :cost 650 :weight 5 :st 10 :tl 3 :skill :two-handed-sword}
   {:id :greatsword :dmg [{:sw+3 :cut}, {:thr+2 :cr}] :reach [:1-2, :2] :parry [:0] :cost 800 :weight 7 :st 12 :tl 3 :skill :two-handed-sword}
   {:id :katana :dmg [{:sw+2 :cut}, {:thr+1 :imp}] :reach [:1-2, :1] :parry [:0] :cost 650 :weight 5 :st 10 :tl 3 :skill :two-handed-sword}
   {:id :thrusting-bastard-sword :dmg [{:sw+2 :cut}, {:thr+3 :imp}] :reach [:1-2, :2] :parry [:0] :cost 750 :weight 5 :st 10 :tl 3 :skill :two-handed-sword}
   {:id :thrusting-greatsword :dmg [{:sw+3 :cut}, {:thr+3 :imp}] :reach [:1-2, :2] :parry [:0] :cost 900 :weight 7 :st 12 :tl 3 :skill :two-handed-sword}

   {:id :whip :dmg [{:sw-3 :cr}] :reach [:1-7] :parry [:-2u] :cost 20 :weight 2 :st :var :tl 1 :skill :whip}])

(def weapons-by-id
  (reduce (fn [acc kv] (assoc acc (:id kv) (dissoc kv :id))) {} weapons))

(def weapons-by-skill
  (->> weapons
       (group-by :skill)))
