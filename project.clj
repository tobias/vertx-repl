(defproject rpq "0.1.0-SNAPSHOT"
  :source-paths ["src/clj"]
  :repositories [["sonatype snapshots" "https://oss.sonatype.org/content/repositories/snapshots/"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [io.vertx/clojure-api "1.0.0.Beta1"]
                 [io.vertx/vertx-platform "2.1M3"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :source-paths ["dev"]
                   :main user}})
