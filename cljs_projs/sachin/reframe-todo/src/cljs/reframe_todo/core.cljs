(ns reframe-todo.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [ajax.core :refer [GET POST]]
            [reframe-todo.ajax :refer [load-interceptors!]]
            [re-frisk.core :refer [enable-re-frisk!]]
            [reframe-todo.events]
            [reframe-todo.subscriptions]
            [soda-ash.core :as sa])
  (:import goog.History))



(defn log
  [& msgs]
  (.log js/console (apply str msgs)))



(defn get-input
  [id]
  (.-value (.getElementById js/document id)))


#_(defn error-handler
  [response]
  (log "ERROR @@@" response))

#_(defn add-todo
  [response]
  (log response)
  (let [body (:content response)
        tasks (mapv #(:task %) body)]
    (rf/dispatch  [:set-tasks tasks])))





(defn update-status-done
  [id]
  (let [u @(rf/subscribe [:current-user])
        t (.-innerText (.getElementById js/document id))]
    (rf/dispatch [:mark-complete {:user u :task t}])))

(defn updated-todo
  [id]
  (let [orig (.-innerText (.getElementById js/document id))]
    (set! (.-value (.getElementById js/document "original-task"))
          orig)))

(defn c-todo
  []
  [:div.flex-container
   (doall  (for [i (range (count @(rf/subscribe [:tasks])))]
             ^{:key i} [sa/Card {:className "todo-card"}
                        [sa/CardContent
                         [sa/CardDescription [:p {:id i} (get @(rf/subscribe [:tasks]) i)]]]
                        [:div.ui.buttons
                         [sa/Button {:on-click #(update-status-done i)} "Completed?"]
                         [:div.or]
                         [sa/Button {:on-click #(updated-todo i)} "Update?"]]]))])

(defn todo-page []
  [:div.container
       [:div.row
        [:div.col-md-6
         [:form {:action "#" :method "get"
                 :on-submit (fn [e]
                              (let [u @(rf/subscribe [:current-user])
                                    t (get-input "task")]
                                (rf/dispatch [:add-todo {:user u :task t}])))}
          [:h2.text-center "Add Task"]
          [:div.form-group [:input.form-control {:type "text" :id "task" :placeholder "Enter Task"}]]
          [:div.form-group [:input.form-control.btn.btn-block.btn-success {:type "submit" :value "Add"}]]
          [:div.form-group [:input.form-control.btn.btn-block.btn-warning {:defaultValue "Log Out" :on-click #(rf/dispatch [:set-active-page :home])}]]]]
        [:div.col-md-6
           [:h2.text-center "Update Task"]
           [:form {:action "#"
                   :on-submit (fn [e]
                                (let [user @(rf/subscribe [:current-user])
                                      orig (get-input "original-task")
                                      upd (get-input "updated-task")]
                                  (rf/dispatch [:update-todo {:user user :orig orig :upd upd}])))}
            [:div.form-group [:input.form-control {:type "text" :id "original-task" :placeholder "Enter Original Task"}]]
            [:div.form-group [:input.form-control {:type "text" :id "updated-task" :placeholder "Enter Updated Task"}]]
            [:div.form-group [:input.form-control.btn.btm-block.btn-success {:type "submit" :value "Update" }]]]]]
       [:div.row
        [c-todo]]])

(defn nav-link [uri title page collapsed?]
  (let [selected-page (rf/subscribe [:page])]
    [:li.nav-item
     {:class (when (= page @selected-page) "active")}
     [:a.nav-link
      {:href uri
       :on-click #(reset! collapsed? true)} title]]))

(defn navbar []
  (r/with-let [collapsed? (r/atom true)]
    [:nav.navbar.navbar-dark.bg-primary
     [:button.navbar-toggler.hidden-sm-up
      {:on-click #(swap! collapsed? not)} "☰"]
     [:div.collapse.navbar-toggleable-xs
      (when-not @collapsed? {:class "in"})
      [:a.navbar-brand {:href "#/"} "TO-DO App"]
      [:ul.nav.navbar-nav
       [nav-link "#/" "Home" :home collapsed?]
       [nav-link "#/about" "About" :about collapsed?]
       [nav-link "#/semantic" "Semantic" :semantic collapsed?]]]]))

(defn about-page []
  [:div.container
   [:div.row
    [:div.col-md-12
     [:img {:src (str js/context "/img/warning_clojure.png")}]]]])


(defn home-page []
  [:div.container
   [:form.form-signin  {:action "#"
                        :on-submit (fn [e]
                                     (let [u (get-input "username")
                                           p (get-input "password")]
                                       (rf/dispatch [:validate-login {:username u :password p}])))}
    [:h2.form-signin-heading "Please sign in"]
    [:div.form-group [:input.form-control {:type "text" :id "username" :placeholder "Enter Username" }]]
    [:div.form-group [:input.form-control {:type "password" :id "password" :placeholder "Enter Password"}]]
    [:div.form-group [:input.form-control.btn.btn-primary {:type "submit" :value "Submit"}]]]])




#_(defn semantic-page1 []
  (let [visible (r/atom false)
        on-click (fn []
                   (reset! visible (not @visible)))]
    (fn []
      (log @visible)
      [:div
       [sa/Button {:onClick on-click} "Toggle Visibility"]
       [sa/SidebarPushable {:as (aget js/semanticUIReact "Segment")}
        [sa/Sidebar {:as (aget js/semanticUIReact "Menu")
                     :animation "overlay"
                     :width "thin"
                     :visible @visible
                     :icon "labeled"
                     :vertical true
                     :inverted true
                     }
         [sa/MenuItem {:name "home"}
          [sa/Icon {:name "home"}]
          "Home"]]
        [sa/SidebarPusher
         [sa/Segment {:basic true}]
         [sa/Header "Application Content"]]]])))

(defn semantic-page []
  (let [visible (r/atom false)
        on-click (fn []
                   (reset! visible (not @visible)))]
    (fn []
      [:div
       [sa/Button {:onClick on-click} "Toggle"]
       [sa/SidebarPushable {:as (aget js/semanticUIReact "Segment")}
        [sa/Sidebar {:as (aget js/semanticUIReact "Menu")
                     :animation "push"
                     :width "thin"
                     :visible @visible
                     :icon "labeled"
                     :vertical true
                     :inverted true}
         [sa/MenuItem {:name "home"}
          [sa/Icon {:name "home"}]
          "Home"]]
        [sa/SidebarPusher
         [sa/Segment {:basic true}]
         [sa/Header "Application Content"]]]])))


(def pages
  {:home #'home-page
   :about #'about-page
   :todos #'todo-page
   :semantic #'semantic-page})

(defn page []
  [:div
   [navbar]
   [(pages @(rf/subscribe [:page]))]])

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (rf/dispatch [:set-active-page :home]))

(secretary/defroute "/about" []
  (rf/dispatch [:set-active-page :about]))

(secretary/defroute "/todos" []
  (rf/dispatch [:set-active-page :todos]))

(secretary/defroute "/semantic" []
  (rf/dispatch [:set-active-page :semantic]))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
      HistoryEventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize app
#_(defn fetch-docs! []
  (GET "/docs" {:handler #(rf/dispatch [:set-docs %])}))

(defn mount-components []
  (rf/clear-subscription-cache!)
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (rf/dispatch-sync [:initialize-db])
  (enable-re-frisk!)
  (load-interceptors!)
  #_(fetch-docs!)
  (hook-browser-navigation!)
  (mount-components))
