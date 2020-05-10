(defproject pod-jaydeesimon-jsoup "0.1"
  :description "Tiny Babashka pod to select HTML elements using CSS queries (uses JSoup)"
  :url "https://github.com/jaydeesimon/pod-jaydeesimon-jsoup"
  :scm {:name "git"
        :url "https://github.com/jaydeesimon/pod-jaydeesimon-jsoup"}
  :license {:name "Eclipse Public License 1.0"
            :url "http://opensource.org/licenses/eclipse-1.0.php"}
  :source-paths ["src"]
  :resource-paths ["resources"]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.jsoup/jsoup "1.13.1"]
                 [nrepl/bencode "1.1.0"]]
  :profiles {:uberjar {:global-vars {*assert* false}
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"
                                  "-Dclojure.spec.skip-macros=true"]
                       :aot :all
                       :main pod-jaydeesimon-jsoup.core}}
  :target-path "target/%s")
