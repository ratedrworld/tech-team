(defproject tic_tac_toe "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.671"]]
  :plugins [[lein-cljsbuild "1.1.2"]]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/cljs"]
                :compiler {:main tic_tac_toe.core
                           :asset-path "js/app"
                           :output-to "resources/public/js/app/app.js"
                           :output-dir "resources/public/js/app"
                           :optimizations :none
                           :pretty-print true}}
               {:id "new_xo"
                :source-paths ["src/cljs"]
                :compiler {:main tic_tac_toe.new_xo
                           :asset-path "js/app_new"
                           :output-to "resources/public/js/app_new/app_new.js"
                           :output-dir "resources/public/js/app_new"
                           :optimizations :none
                           :pretty-print true}}
               {:id "min"
                :source-paths ["src/cljs"]
                :compiler {:main tic_tac_toe.core
                           :asset-path "js/app"
                           :output-to "resources/public/js/app/app.js"
                           :optimizations :whitespace
                           :pretty-print false}}]}
  :main ^:skip-aot tic-tac-toe.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
