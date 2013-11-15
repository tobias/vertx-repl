(ns rpq.rpq
  (:require [vertx.http :as http]
            [vertx.embed :as vertx])
  (:import java.util.concurrent.CountDownLatch))

(defn req-handler [req]
  (-> (http/server-response req)
      (http/end "Hello from Vert.x!")))

(defn -main
  [& args]
  (vertx/set-vertx! (vertx/vertx))
  (let [latch (CountDownLatch. 1)]
    (-> (http/server)
        (http/on-request req-handler)
        (http/listen 4000 "localhost"))
    (println "Yo!")
    (.await latch)))



