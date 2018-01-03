(ns to-do-list.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [ajax.core :refer [GET POST]]
            [accountant.core :as accountant]
            [secretary.core :as secretary :include-macros true]))

;; Server address for requests
(def server "http://localhost:3000/")

;; Global get by id
(defn get-by-id [id] (.-value (.getElementById js/document id)))

;; Log it is
(defn log [& msgs]
  (.log js/console (apply str msgs)))

;; Atom to store current page
#_(def pages (r/atom :login))


;; Atom to store todos of a user
(def todos (r/atom {:user "xyz"
                    :todolist [{:title "ATOM TODO" :content "TODO CONTENT"}]}))

;; If error log in console
(defn error-handler [params]
  (log "ERRORS >>>>>" params))

;;;;;;;;;;;;;;;;;;; TODO PAGE COMPONENTS


;; Markup to show the todos from atom
(defn show-todos []
  (log @todos)
  [:div (doall (map (fn [x]
                      [:div.todo
                       [:div (:title x)
                        [:button "Done"
                         {:on-click: (fn [e]
                                       (let [title (:title x)]
                                         (log "DONE TODO  >>>" user pass)
                                         (GET (str server "todo")
                                              {:params {:user user
                                                        :pass pass}
                                               :format :json
                                               :response-format :json
                                               :keywords? true
                                               :handler logged-in?
                                               :error-handler error-handler})))}]]
                       [:div (:content x) [:button "Update"]]])
                    (:todolist @todos)))]
  #_[:table
     [:thead [:tr [:th "Title"] [:th "Content"]]]
     [:tbody (doall (map (fn [x]
                           [:tr [:td (:title x)] [:td (:content x)]])
                         @todos))]])

;; Add Todo handler
(defn added-todo? [response]
  (if (:status response)
    (do (swap! todos assoc-in [:todolist] (:content response))
      (js/alert "Added a New ToDo"))
    (js/alert "Failed to add  a New ToDo")))

;;; Main HTML PAGE
(defn todo-page []
  [:div.container
   [:h2 "Welcome " (:user @todos) " to Your Todo List"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [user (:user @todos)
                              title (get-by-id "todo-title")
                              content (get-by-id "todo-content")]
                          (log "IP FROM TXTBOX >>>" title content)
                          (GET (str server "todo")
                               {:params {:user user
                                         :title title
                                         :content content}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler added-todo?
                                :error-handler error-handler})))}
    [:div [:input {:type "text" :id "todo-title" :placeholder "Todo Title"}]]
    [:div [:input {:type "text" :id "todo-content" :placeholder "Todo Content"}]]
    [:div [:input {:type "submit" :value "Add A New Todo"}]]]
   [:button {:on-click (fn [e]
                         (js/alert (str  "Bye " (:user @todos) " Have a Gr8 Day"))
                         #_(reset! pages :login) #_(session/put! :current-page login-page)
                         (secretary/dispatch! "/login"))} "Logout"]
   [:div [show-todos]]])

;;;;;;;;;;;;;;;;;;;;;;;;;; LOGIN PAGE COMPONENTS
(defn logged-in? [response]
  (if (:login response)
    (do #_(reset! pages :todo)
        #_(secretary/dispatch! "/todo")
        (session/put! :current-page todo-page)
        (swap! todos assoc-in [:user] (:user response))
        (swap! todos assoc-in [:todolist] (:content response)))
    (js/alert "Login failed..!! Plz try again")))

;;; Login Page
(defn login-page []
  [:div.container
   [:h2 "WELCOME TO sam16's TODO APP"]
   [:h2 "Please login to go to your TODO list"]
   [:form {:action "#" :method "get"
           :on-submit (fn [e]
                        (let [user (get-by-id "username")
                              pass (get-by-id "password")]
                          (log "IP FROM LOGIN  >>>" user pass)
                          (GET (str server "user")
                               {:params {:user user
                                         :pass pass}
                                :format :json
                                :response-format :json
                                :keywords? true
                                :handler logged-in?
                                :error-handler error-handler})))}
    [:div [:input {:type "text" :id "username" :placeholder "ENTER USERNAME"}]]
    [:div [:input {:type "text" :id "password" :placeholder "ENTER PASSWORD"}]]
    [:div [:input {:type "submit" :value "LOGIN"}]]]])


;; Secretary Components
(defn page []
  [(session/get :current-page)])

(secretary/set-config! :prefix "#")

(secretary/defroute  "/" []
  (session/put! :current-page login-page))

(secretary/defroute "/todo" []
  (session/put! :current-page todo-page))

(secretary/defroute "/login" []
  (session/put! :current-page login-page))

;;; PARENT COMPONENT TO SWITCH PAGES
#_(defn page-switcher []
  (condp = @pages
    :login [login-page]
    :todo [todo-page]))


;;;;;;;;;;;;;; Initialization
(defn mount-components []
  (session/put! :current-page login-page)
  (r/render [page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (secretary/dispatch! path))
    :path-exists?
    (fn [path]
      (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-components))
