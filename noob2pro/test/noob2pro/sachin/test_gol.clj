(ns noob2pro.sachin.test_gol
  (:require #_[clojure.test :refer :all]
            [noob2pro.sachin.game_of_life :refer :all]
            [expectations :as expect]))


;;;Create board
#_(expect/expect [[1 0 1] [1 0 0] [1 0 0]] (create_board 3))

;;;Get ALIVE NEIGHBOURS
(expect/expect 2 (get_alive_neigh (demo) 0 0))
(expect/expect 1 (get_alive_neigh (demo) 4 4))
(expect/expect 4 (get_alive_neigh (demo) 3 2))

;;;CHeck RULES

(expect/expect 0 (check_rules 0))
(expect/expect 0 (check_rules 1))
(expect/expect 1 (check_rules 2))
(expect/expect 1 (check_rules 3))
(expect/expect 0 (check_rules 4))

;;;GAME OF LIFE

(expect/expect [[1 1 1 0 0] [0 0 0 1 1] [1 0 1 1 0] [0 0 0 1 1] [1 1 1 0 0]] (game_of_life (demo) 5))

;;;GOL MAIN

(expect/expect [[1 1 1 0 0] [0 0 0 1 1] [1 0 1 1 0] [0 0 0 1 1] [1 1 1 0 0]] (gol_main_test 5 1))
(expect/expect [[0 1 1 1 1] [1 0 0 0 1] [0 1 1 0 0] [1 0 0 0 1] [0 1 1 1 1]] (gol_main_test 5 2))
