(ns noob2pro.sam16.test_clock
  (:require [noob2pro.sam16.clock_coordinates :refer :all]
            [expectations :as exlib]))


;; MODIFY ANGLE
(exlib/expect 30 (modify_angle 60))
(exlib/expect -60 (modify_angle 210))

;; GET HAND COORDS
(exlib/expect #{["16.00" "10.00"] ["10.00" "19.00"]} (get_hand_coords [3 00]))
(exlib/expect #{["5.09" "13.44"] ["17.79" "14.50"]} (get_hand_coords [10 10]))
(exlib/expect #{["11.04" "4.09"] ["2.21" "5.50"]} (get_hand_coords [5 40]))

;; SPLIT LINES
(exlib/expect ["3" "3 00" "10 10" "5 40"] (split_lines "clock.txt"))

;; SPLIT SPACES
(exlib/expect [7 88 95] (split_spaces "7 88 95"))

;; CLOCK MAIN
(exlib/expect
 '(#{["16.00" "10.00"] ["10.00" "19.00"]} #{["5.09" "13.44"] ["17.79" "14.50"]} #{["11.04" "4.09"] ["2.21" "5.50"]})
 (clock_main "clock.txt"))
