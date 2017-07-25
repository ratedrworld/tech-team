(ns learn-cljs.core)






(defn encrypt-decrypt
  "returns cipher when passes plain text key and sorted key, from encypt funciton
   returns plain text when passed cipher sorted key and key in order from decrypt function."
  [text key sort-key]
  (let [text-p (partition (/ (count text)
                             (count key))
                          text)
        zmap (zipmap sort-key text-p)]
    (apply str (map #(apply str
                            (get zmap %)) key))))



(defn encrypt
  [plain key]
  (encrypt-decrypt plain key (sort key)))

(defn decrypt
  [cipher key]
  (encrypt-decrypt cipher (sort key) key))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [input (.-value (.getElementById js/document "input"))
        key (.-value (.getElementById js/document "key"))
        option (.-value (.getElementById js/document "select" ))]
    (if (= option "1")
      (set! (.-value (.getElementById js/document "output"))
            (encrypt input key))
      (set! (.-value (.getElementById js/document "output"))
            (decrypt input key)))))
