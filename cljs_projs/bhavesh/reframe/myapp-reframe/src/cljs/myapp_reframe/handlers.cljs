(ns myapp-reframe.handlers
  (:require [myapp-reframe.db :as db]
            [re-frame.core :refer [dispatch reg-event-db]]))

(reg-event-db
  :initialize-db
  (fn [_ _]
    db/default-db))

(reg-event-db
  :set-active-page
  (fn [db [_ page]]
    (assoc db :page page)))

(reg-event-db
  :set-docs
  (fn [db [_ docs]]
    (assoc db :docs docs)))

(reg-event-db
 :inc-count
 (fn [db _]
   (or (update db :count inc) 0)))

(reg-event-db
 :reset-count
 (fn [db _]
   (assoc db :count 0)))

(reg-event-db
 :set-user
 (fn [db [_ user]]
   (assoc db :user user)))


(reg-event-db
 :update-task
 (fn [db [_ task]]
   (assoc db :task task)))
