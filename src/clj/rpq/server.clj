(ns rpq.server
  (:require [rpq.http :as http]
            [vertx.embed.platform :as platform]
            [clojure.java.io :as io])
  (:import org.vertx.java.platform.PlatformLocator
           java.io.File))

(defn server []
  {})

(defn start [s]
  (let [cp ["src/clj" "vertx"]
        urlvector (map #(.toURL (.toURI (File. %))) cp)
        urlarray (into-array urlvector)
        pm (.createPlatformManager (PlatformLocator/factory))]
    (.deployModuleFromClasspath pm "rpquest~rpq~1.0" nil 1 urlarray nil)
    (assoc s :pm pm)))

(defn stop [s]
  (when s
    (let [pm (:pm s)]
      (.undeployAll pm nil))
    nil))


(defn start2 [s]
  (let [platform-manager (platform/platform-manager)
        urls (map #(io/as-url (io/as-file %)) ["src/clj" "vertx"])]
    (platform/deploy-module-from-classpath platform-manager "rpquest~rpq~0.1" :classpath urls :config {:port 9999} :handler println)
    (assoc s :pm platform-manager)))

(defn stop2 [s]
  (when s
    (let [pm (:pm s)]
      (platform/undeploy-all pm))
    nil))
