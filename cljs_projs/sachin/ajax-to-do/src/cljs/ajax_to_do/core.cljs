(ns ajax-to-do.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]]))

(def task-atom (r/atom []))

(def server "http://localhost:3000/")

(defn log
  [& msgs]
  (.log js/console (apply str msgs)))

(defn get-input
  [id]
  (.-value (.getElementById js/document id)))


(defn c-todo
  []
  [:div
   [:h2 "TASK-LIST"]
   (doall  (for [i (range (count @task-atom))]
             [:input {:type "button" :value (get @task-atom i)}]))])

(defn add-todo
  [[response]]
  (let [body (:content response)
        tasks (mapv #(:task %) body)]
    (reset! task-atom tasks)
    (log "@@@@@@@@@@@@@@@@@@@@@@@@@@2" @task-atom)))

(defn error-handler
  [response]
  (log "@@@@@@@@@@@@" response))
(defn home-page []
  [:div.container
   [:h2 "HELLO AJAX TO DO"]
   [:form {:action "#"
           :on-submit (fn [e]
                        (let [t (get-input "task")]
                          (GET (str server "todo")
                                {:params {:task t}
                                 :format :json
                                 :response-format :json
                                 :keywords? true
                                 :handler add-todo
                                 :error-handler error-handler})))}
    [:input {:type "text" :id "task"}]
    [:input {:type "submit" :value "Add"}]]
    [c-todo]])

;; -------------------------
;; Initialize app



(defn mount-components []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-components))
