(ns rpq.server
  (:require [vertx.http :as http]
            [vertx.embed :as vertx]
            [clojure.core.async :as async])
  (:import java.util.concurrent.CountDownLatch))

(defn server []
  (vertx/set-vertx! (vertx/vertx))
  {})

(defn req-handler [req]
  (-> (http/server-response req)
      (http/end "Hello from Vert.x!")))

(defn start [s]
  (let [http-server
        (-> (http/server)
            (http/on-request req-handler)
            (http/listen 4000 "localhost"))]
    (assoc s :server http-server)))

(defn stop [s]
  (when s
    (let [http-server (:server s)]
      (.close http-server))
    s))


