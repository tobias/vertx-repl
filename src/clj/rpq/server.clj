(ns rpq.server
  (:require [rpq.http :as http])
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
