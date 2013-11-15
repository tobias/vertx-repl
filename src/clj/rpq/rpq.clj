(ns rpq.rpq
  (:require [rpq.http :as http])
  (:import java.util.concurrent.CountDownLatch))

(defn -main
  [& args]
  (http/init-server)
  (let [latch (CountDownLatch. 1)]
    (http/start-server)
    (println "Server started")
    (.await latch)))





