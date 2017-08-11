(ns myapp-reframe.subscriptions
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :page
  (fn [db _]
    (:page db)))

(reg-sub
  :docs
  (fn [db _]
    (:docs db)))



(reg-sub
 :count
 (fn [db _]
   (:count db)))

(reg-sub
 :user
 (fn [db _]
   (:user db)))

(reg-sub
 :task
 (fn [db _]
   (get-in db [:task :content])))
