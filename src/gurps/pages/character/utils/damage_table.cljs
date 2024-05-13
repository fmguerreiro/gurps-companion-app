(ns gurps.pages.character.utils.damage-table)

;; TODO: rest of values from: https://gurps.fandom.com/wiki/Damage
(def damage-table
  {1 {:thr "1d-6" :sw "1d-5"}
   2 {:thr "1d-6" :sw "1d-5"}
   3 {:thr "1d-5" :sw "1d-4"}
   4 {:thr "1d-5" :sw "1d-4"}
   5 {:thr "1d-4" :sw "1d-3"}
   6 {:thr "1d-4" :sw "1d-3"}
   7 {:thr "1d-3" :sw "1d-2"}
   8 {:thr "1d-3" :sw "1d-2"}
   9 {:thr "1d-2" :sw "1d-1"}
   10 {:thr "1d-2" :sw "1d"}
   11 {:thr "1d-1" :sw "1d+1"}
   12 {:thr "1d-1" :sw "1d+2"}
   13 {:thr "1d" :sw "2d-1"}
   14 {:thr "1d" :sw "2d"}
   15 {:thr "1d+1" :sw "2d+1"}
   16 {:thr "1d+1" :sw "2d+2"}
   17 {:thr "1d+2" :sw "3d-1"}
   18 {:thr "1d+2" :sw "3d"}
   19 {:thr "2d-1" :sw "3d+1"}
   20 {:thr "2d-1" :sw "3d+2"}
   21 {:thr "2d" :sw "4d-1"}
   22 {:thr "2d" :sw "4d"}
   23 {:thr "2d+1" :sw "4d+1"}
   24 {:thr "2d+1" :sw "4d+2"}
   25 {:thr "2d+2" :sw "5d-1"}
   26 {:thr "2d+2" :sw "5d"}
   27 {:thr "3d-1" :sw "5d+1"}
   28 {:thr "3d-1" :sw "5d+1"}
   29 {:thr "3d" :sw "5d+2"}
   30 {:thr "3d" :sw "5d+2"}
   31 {:thr "3d+1" :sw "6d-1"}
   32 {:thr "3d+1" :sw "6d-1"}
   33 {:thr "3d+2" :sw "6d"}
   34 {:thr "3d+2" :sw "6d"}
   35 {:thr "4d-1" :sw "6d+1"}
   36 {:thr "4d-1" :sw "6d+1"}
   37 {:thr "4d" :sw "6d+2"}
   38 {:thr "4d" :sw "6d+2"}
   39 {:thr "4d+1" :sw "7d-1"}
   40 {:thr "4d+1" :sw "7d-1"}})
