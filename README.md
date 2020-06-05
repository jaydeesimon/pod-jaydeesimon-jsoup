# pod-jaydeesimon-jsoup

A [babashka pod](https://github.com/babashka/babashka.pods) for parsing and selecting HTML using CSS queries. Built on top of [jsoup.](https://jsoup.org)

This project is meant to be an experiment for exposing useful functionality from common libraries I use. In this case, jsoup.
I often write one-off programs to scrape HTML and answer questions about them using jsoup's `select` functionality. With
babashka pods, this can be called from a babashka script.

## Usage

* Build a binary by running `script/compile`. Depends on GraalVM. This will build a binary in the current
working directory named `pod-jaydeesimon-jsoup`.

* Test it out using babashka. I've tested on `v0.1.0`.

```clojure
$ rlwrap bb
Babashka v0.1.0 REPL.
Use :repl/quit or :repl/exit to quit the REPL.
Clojure rocks, Bash reaches.

user=> (require '[babashka.pods :as pods])

user=> (pods/load-pod "./pod-jaydeesimon-jsoup")
#:pod{:id "pod.jaydeesimon.jsoup"}

user=> (require '[pod.jaydeesimon.jsoup :as jsoup])

user=> (-> (curl/get "https://clojure.org")
           :body
           (jsoup/select "div.clj-header-message")
           first
           :text)
"Clojure is a robust, practical, and fast programming language with a set of useful features that together form a simple, coherent, and powerful tool."
```

Alternatively, you can load the pod by using `lein run` or `java -jar` and pass it the uberjar.

```clojure
user=> (pods/load-pod ["lein" "run" "-m" "pod-jaydeesimon-jsoup.core"])

or

;; do `lein uberjar` to make sure the jar is built
user=> (pods/load-pod ["java" "-jar" "target/uberjar/pod-jaydeesimon-jsoup-0.1-standalone.jar"])

```

## Available Vars

This pod exposes just one var.

* `pod.jaydeesimon.jsoup/select`. Given some HTML and a CSS query, calls jsoup's `select` which returns
`org.jsoup.nodes.Element` objects which are then converted into Clojure maps. 

## Credits

* This project is based off of and heavily inspired by [pod-babashka-hsqldb](https://github.com/babashka/pod-babashka-hsqldb). I would have no idea what I'm doing otherwise.

* Thanks to @borkdude and babashka's contributors

* Jsoup for doing the heavy lifting 