(ns reframe-todo.events
  (:require [re-frame.core :refer [dispatch reg-event-db reg-event-fx]]
            [reframe-todo.db :as db]
            [reframe-todo.effects]))

(reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db) )


(reg-event-db
 :set-active-page
 (fn [db [_ page]]
   (assoc db :page page)))



(reg-event-db
 :set-current-user
 (fn [db [_ user]]
   (assoc db :current-user user)))

(reg-event-db
 :set-tasks
 (fn [db [_ task]]
   (assoc db :tasks task)))

(reg-event-fx
 :validate-login
 (fn [cofx [_ credentials]]
   {:process-login credentials}))

(reg-event-fx
 :show-alert
 (fn [cofx [_ message]]
   {:show-alert message}))

(reg-event-fx
 :valid-user
 (fn [cofx [_ {:keys [auth user]}]]
   (if auth
     {:dispatch-n [[:set-current-user user] [:set-active-page :todos]]
      :get-todos user}
     {:show-alert "Invalid Username/ Password. Please try again "})))


(reg-event-fx
 :add-todos
 (fn [cofx [_ {:keys [content]}]]
   (let [tasks (mapv #(:task %) content)]
     {:dispatch [:set-tasks tasks]})))

(reg-event-fx
 :add-todo
 (fn [cofx [_ opts]]
   {:add-todo opts}))

(reg-event-fx
 :mark-complete
 (fn [cofx [_ opts]]
   {:update-status-todo opts}))

(reg-event-fx
 :update-todo
 (fn [cofx [_ opts]]
   {:update-todo opts}))
