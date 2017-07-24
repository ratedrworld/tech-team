(ns noob2pro.sam16.clock_coordinates
  (:require [clojure.string :as String]))

(defn modify_angle [angle]
  (if (< angle 180) (- 90 angle) (- angle 270)))

(defn get_hand_coords
  [[hr min]]
  (let [hrangle (* 0.5 (+  (* 60 hr) min))
        minangle (* 6 min)]
    (hash-set
     (mapv #(format "%.2f" %)
           (vector
            (+ 10 (* (Math/sin (Math/toRadians hrangle)) 6))
            (+ 10 (* (Math/cos (Math/toRadians hrangle)) 6))))
     (mapv #(format "%.2f" %)
           (vector
            (+ 10 (* (Math/sin (Math/toRadians minangle)) 9))
            (+ 10 (* (Math/cos (Math/toRadians minangle)) 9)))))))

(defn split_lines [fname]
  (String/split (slurp (str "resources/sam16/" fname)) #"\n"))

(defn split_spaces [str]
  (mapv read-string (String/split str #"\s+")))

(defn clock_main [fname]
  (let [inp (split_lines fname)]
    (map #(get_hand_coords (split_spaces %)) (rest inp))))
