(defproject noob2pro "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [expectations "2.2.0-beta1"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :plugins [[lein-autoexpect "1.9.0"]]
  :main ^:skip-aot noob2pro.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
