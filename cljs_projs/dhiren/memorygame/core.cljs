(ns memorygame.core
  (:require [clojure.string :as string]))





(def xyz (shuffle (apply concat (repeat 2 (range 1 9)))))

(def my-board
  (zipmap (range 1 17) (map #(hash-map :value % :Locked false :Life false) xyz)))

(def my-atom (atom my-board))

(def firstval (atom -1))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn get-element
  [id]
  (get @my-atom id))


(defn set-element-life
  [id lock life value]
  ;(js/alert (str @my-atom))
  (set!
   (.-value (.getElementById js/document (str "" id)))
   (str id " " (str value) " " (str "Locked:" lock) " " (str "Life:" life)))
  (swap! my-atom assoc-in  [id :Locked] lock)
 (swap! my-atom assoc-in [id :Life] life))

(defn game-over?
  []

  (let [x (mapv #(get-element %) (range 1 17))
        y (filter (fn [c]
                        (= false (get-in @my-atom [c :Locked]))) (range 1 17))]
    (if (zero? (count y))
      true
      false)))



(defn createboard
  []
  (reset! my-atom my-board)
  (js/alert (str @my-atom))
  (loop [i 16]
    (if-not (= i 0)

      (do
        (set!
         (.-value (.getElementById js/document (str "" i)))
         (set-element-life i false false (get-in @my-atom [i :value]))
         (js/alert (str (get-in @my-atom [i :value]))))
        #_(swap! my-atom assoc i (str i "_Unlocked_" (first x) "_Dead"))

        (recur (dec i))))))




(defn getfirstvalue
  [id]
  (if-not (= true (get-in @my-atom [id :Locked]))
    (if (= false (get-in @my-atom [id :Life]))
      (do
       #_ (js/alert "heks")
        (reset! firstval id)
        (set-element-life id false true (get-in @my-atom [id :value]))
        #_(swap! my-atom assoc-in [id :Life] true)
        (js/alert (str @my-atom)))
      (do
        (js/alert "Element is alive")))
    (js/alert "Bhai kuch aur choon")))

(defn getsecondvalue
  [id]
  (if-not (= true (get-in @my-atom [id :Locked]))
    (if (= false (get-in @my-atom [id :Life]))
      (do
        #_(js/alert "keks")
        (set-element-life id false true (get-in @my-atom [id :value]))
        #_(swap! my-atom update-in [id :Life] true)
        (if (= (get-in @my-atom  [id :value]) (get-in @my-atom [@firstval :value]))
          (do
            (set-element-life id true false (get-in @my-atom [id :value]))
            (set-element-life @firstval true false (get-in @my-atom [@firstval :value])))
          (do
            (set-element-life id false false (get-in @my-atom [id :value]))
            (set-element-life @firstval false false (get-in @my-atom [@firstval :value]))))
        #_(js/alert (str @my-atom))
        (reset! firstval -1))
      (do
        (js/alert "Element is alive")))
    (js/alert "Bhai kuch aur choon")))

#_(defn getsecondvalue
  [id]
  (if-not (= true (get-in @my-atom [id :Locked]))
    (if (= false (get-in @my-atom [id :Life]))
      (do
        (js/alert "das keks")

        (reset! firstval -1)
        (swap! my-atom assoc-in [id :Life] true)
        (js/alert (str @firstval)))
      (do
        (js/alert "Element is alive")))
    (js/alert "Bhai kuch aur choon")))

#_(defn getsecondvalue
  [id]
  (do
    (def b (.-value (.getElementById js/document (str "" id))))
    (let [c (clojure.string/split b #"_")
          d (clojure.string/split a #"_")]
      (if (= "Locked" (second c))
        (def b nil)
        (if-not (= "Live" (last c))
          (do
            (set-element-life (first c) "_Unlocked_" "_Live")
            (if (= (nth c 2) (nth d 2))
              (do
                (set-element-life (first c) "_Locked_" "_Dead")
                (set-element-life (first d) "_Locked_" "_Dead"))
              (do
                (set-element-life (first c) "_Unlocked_" "_Dead")
                (set-element-life (first d) "_Unlocked_" "_Dead")))))))
    (def a nil)))

#_(def a nil)

(defn getValue
  [id]
  (if (game-over?)
    (do
      (js/alert "Game Over")
      (createboard))
    (if (= @firstval -1)
      (getfirstvalue id)
      (getsecondvalue id))))
