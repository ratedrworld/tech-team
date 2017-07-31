(ns x-o.core
    (:require [reagent.core :as r]))

;; React Atom
(defn blank []
  [["" "" ""] ["" "" ""] ["" "" ""]])

(def board (r/atom (blank)))

;; Functions
(defn x-or-o? []
  (if (odd? (count (filter empty? (flatten @board))))
    "X"
    "O"))

(defn make-move [i j]
  (when (= "" (get-in @board [i j]))
    (let [a (x-or-o?)]
      (swap! board assoc-in [i j] a))))

(defn done-row? [i]
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
           (mapv #(get-in @board [i %]) (range 0 3))))

(defn done-col? [i]
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [% i]) (range 0 3))))

(defn diag1? []
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [%1 %2]) (range 0 3) (range 0 3))))

(defn diag2? []
  (reduce (fn [a x]
            (if (and (= a x) (not= x ""))
              a
              false))
          (mapv #(get-in @board [%1 %2]) (range 0 3) (reverse (range 0 3)))))

(defn won? []
  (or (some #(if (not= % false) %) (map #(done-row? %) (range 3)))
      (some #(if (not= % false) %) (map #(done-col? %) (range 3)))
      (diag1?)
      (diag2?)))



(defn perform [i j]
  (make-move i j)
  (.setTimeout js/window (fn [x]
                           (let [rslt (won?)
                                 c (count (filter empty? (flatten @board)))]
                             (cond
                               rslt (do (js/alert (str "Player " rslt " Won..!!"))
                                        (reset! board (blank)))
                               (zero? c) (do (js/alert (str "GAME OVER..!! Try Again"))
                                             (reset! board (blank))))))
               (* 1 1000)))

;; -------------------------
;; Views

(defn init-board []
  [:table
   (doall
    (map (fn [i]
           ^{:key i} [:tr (doall
                           (map (fn [j]
                                  ^{:key j} [:td {:on-click #(perform i j)}
                                             (get-in @board [i j])])
                                (range 3)))])
         (range 3)))])


(defn home-page []
  [:div [:h2 "LETS PLAY TIC TAC TOE"]
   [init-board]
   #_ [:table
    (for [i (range 3)]
      [:tr
       (for [j (range 3)]
         [:td {} (get-in @board [i j])])])]])



;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
