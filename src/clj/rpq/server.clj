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
    ;; (.deployModuleFromClasspath pm "rpquest~rpq~1.0" nil 1 urlarray nil)
    (.deployVerticle pm "clojure:runner.clj" nil urlarray 1 "io.vertx~mod-mysql-postgresql~0.2.0" nil)
    (assoc s :pm pm)))

(defn stop [s]
  (when s
    (let [pm (:pm s)]
      (.stop pm))
    nil))


