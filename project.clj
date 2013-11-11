(defproject rpq "0.1.0-SNAPSHOT"
  :source-paths ["src/clj"]
  :main rpq.rpq
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [io.vertx/clojure-api "0.3.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :source-paths ["dev"]
                   :main user}})

