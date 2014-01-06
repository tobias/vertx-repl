(ns rpq.server
  (:require [rpq.http :as http])
  (:import org.vertx.java.platform.PlatformLocator
           java.io.File))

(defn server []
  {})

(defn start [s]
  (System/setProperty "vertx.langs.clojure" "io.vertx~lang-clojure~0.4.0:io.vertx.lang.clojure.ClojureVerticleFactory")
  (let [cp ["src/clj" "vertx"]
        urlvector (map #(.toURL (.toURI (File. %))) cp)
        urlarray (into-array urlvector)
        pm (.createPlatformManager (PlatformLocator/factory))]
    (.deployVerticle pm "clojure:runner.clj" nil urlarray 1 nil nil)
    (assoc s :pm pm)))

(defn stop [s]
  (when s
    (let [pm (:pm s)]
      (.undeployAll pm nil))
    nil))




