(ns whos-first?.core
    (:require [reagent.core :as r]))

;; Global log function
(defn log [& args]
  (.log js/console (apply str args)))

;; DS for game board
(def game-board
  (r/atom {:dir :right
           :current [0 0]
           :count 0
           :a {:dices "PLAY" :first true :started? false}
           :b {:dices "PLAY" :first true :started? false}
           :board []
           :paths {:a-path [] :b-path []}
           :multiplier? false
           :show-toast? false
           :header " WhO's FiRsT? "
           :erro-message ""}))

;; Initialize default values in board
(defn init [n]
  (doall (let [new-board (vec (for [i (range n)]
                                (vec (for [j (range n)]
                                       {:pos [i j]}))))]
           (swap! game-board assoc
                  :dir :right
                  :current [0 0]
                  :count n
                  :board new-board
                  :table new-board))))

;; Function to traverse the board i.e Create the setup on board create
(defn make-move [color]
  (let [[x y] (:current @game-board)
        n (:count @game-board)
        dir (:dir @game-board)]
    (condp = dir
      :right (do
               (let [arr (doall (for [i (range y (+ y n))]
                                  (do (swap! game-board update-in [:board x i] merge
                                             {:val "" :color color})
                                      (get-in @game-board [:board x i :pos]))))]
                 (swap! game-board assoc
                        :current [(inc x) (+ y (dec n))]
                        :dir :down
                        :count (- n 2))
                 arr))
      :down (do
              (let [arr (doall (for [i (range x (+ x n))]
                                 (do (swap! game-board update-in [:board i y] merge
                                            {:val "" :color color})
                                     (get-in @game-board [:board i y :pos]))))]
                (swap! game-board assoc
                       :current [(+ x (dec n)) (dec y)]
                       :dir :left)
                arr))
      :left (do
              #_(reverse (drop (- (inc y) n) (take (inc y) (get-in @game-board [:board x]))))
              (let [arr (doall (for [i (range n)]
                                 (do (swap! game-board update-in [:board x (- y i)] merge
                                            {:val "" :color color})
                                     (get-in @game-board [:board x (- y i) :pos]))))]
                (swap! game-board assoc
                       :current [(dec x) (- y (dec n))]
                       :dir :up
                       :count (- n 2))
                arr))
      :up (do
            (let [arr (doall (for [i (reverse (range (- (inc x)  n) (inc x)))]
                               (do (swap! game-board update-in [:board i y] merge
                                          {:val "" :color color})
                                   (get-in @game-board [:board i y :pos]))))]
              (swap! game-board assoc
                     :current [(- x (dec n)) (inc y)]
                     :dir :right)
              arr)))))

;; Traverse the board to Get paths a & b add colours and set final win colours
(defn traverse []
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :a-path] into (make-move "yellow")))
  (swap! game-board assoc
         :dir :left
         :current [9 9]
         :count 10)
  (while (> (get-in @game-board [:count]) 0)
    (swap! game-board update-in [:paths :b-path] into (make-move "lime")))
  (swap! game-board assoc-in [:board 4 5 :color] "#FF4136")
  (swap! game-board assoc-in [:board 5 4 :color] "#FF4136")
  (get @game-board :paths))


;; -------------------------
;; Views
;; Hiccup to initialize board
(defn init-board [size]
  [:table
   (doall
    (map (fn [i]
           ^{:key i} [:tr (doall
                           (map (fn [j]
                                  ^{:key j} [:td {:style {:background-color
                                                          (get-in @game-board [:board i j :color])}}
                                             (get-in @game-board [:board i j :val])])
                                (range size)))])
         (range size)))])

;; Move Ahead Player A/B by moves
(defn change-pos [player moves path old-color new-color]
  (let [curr-path (doall (get-in @game-board [:paths path]))]
    (if (< moves (count curr-path))
      (let [[i j] (first curr-path)
            new-path (doall (drop moves curr-path))
            [x y] (first new-path)]
        (swap! game-board update-in [:board i j] merge {:val "" :color old-color})
        (swap! game-board update-in [:board x y] merge {:val player :color new-color})
        (swap! game-board assoc-in [:paths path] new-path)
        new-path)
      (swap! game-board assoc
             :header (str "Cant Move : " moves " Try in Next Turn")
             :timeout? true))))

;; Setup function to setup the board in web with initial values
(defn setup []
  (init 10)
  (traverse))

;; Check for multipler and return moves x 2 if yes
(defn multiplier? [moves]
  (if (:multiplier @game-board)
    (do (swap! game-board assoc-in [:multiplier] false)
      (* moves 2))
    moves))

;; Switch player chances
(defn switch-player [x]
  (condp = x
    :a (do (set! (.-disabled (.getElementById js/document "a-btn")) true)
           (set! (.-disabled (.getElementById js/document "b-btn")) false))
    :b (do (set! (.-disabled (.getElementById js/document "a-btn")) false)
           (set! (.-disabled (.getElementById js/document "b-btn")) true))))

;; Check if First move
(defn first-move? [x moves]
  (if (get-in @game-board [x :first])
    (do (swap! game-board assoc-in [x :first] false)
        (- moves 1))
    moves))

;; Main game logic (Crude function :()
(defn play [player]
  (let [moves (rand-nth [0 1 2 3 4 5 6 "X2"])]
    (swap! game-board assoc-in [player :dices] moves)
    (if (get-in @game-board [player :started?])
      (condp = moves
        0 (do (swap! game-board assoc-in [player :dices] "SKIP")
              (switch-player player))
        "X2" (do (swap! game-board assoc-in [:multiplier] true)
                 (swap! game-board assoc
                        :header (str "X2 Multiplier!! Play Again")
                        :timeout? true))
        (let [path (condp = player
                     :a (do (switch-player player)
                            (change-pos "A" (first-move? player (multiplier? moves)) :a-path "yellow" "gold"))
                     :b (do (switch-player player)
                            (change-pos "B" (first-move? player (multiplier? moves)) :b-path "lime" "Chartreuse")))]
          (when (= 1 (count path))
            (swap! game-board assoc
                   :header (str "YoU WoN!! GAMEOVER..!!")
                   :timeout? true)
            (js/alert "YOU WON!! GAMEOVER..!!")
            (.reload js/location true))))
      (if (= 6 moves)
        (swap! game-board assoc-in [player :started?] true)
        (do (swap! game-board assoc
                   :header (str "Cant Play Until U Get A 6")
                   :timeout? true)
            (switch-player player))))))

;; Customizable Toast to display on demand
(defn toast [props]
  (fn [{:keys [class text after-n show? timeout]}]
    (js/setTimeout after-n timeout)
    (if show?
      [:div {:className class} text]
      [:div])))

;; Custom Header to Show Error on Demand
(defn header-or-error [{:keys [text after-n timeout?]}]
  (when timeout?
    (js/setTimeout after-n 1000) )
  [:h1 text])

;; Default home page Component which has dices and board
(defn home-page []
  (log ">>>>>> board" (:board @game-board))
  [:div
   [header-or-error {:text (:header @game-board)
                     :timeout? (:timeout? @game-board)
                     :after-n #(swap! game-board assoc
                                      :header "WhO's FiRsT?"
                                      :timeout? false)}]
   [:div.display
    [:div.item [:button {:id "a-btn" :on-click #(play :a)} (get-in @game-board [:a :dices])]
     [:h2 " A "]]
    [init-board 10]
    [:div.item.b [:h2 " B "]
     [:button {:id "b-btn" :on-click #(play :b)} (get-in @game-board [:b :dices])]]]
   #_[toast {:show? (:show-toast? @game-board)
             :after-n #(swap! game-board assoc :show-toast? false)
             :text (:error-message @game-board)
             :class "toast"
             :timeout 1000}]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

;; Call setup on page loading
(setup)


(defn init! []
  (mount-root))
