(ns rpq.http
  (:require [vertx.embed :as vertx]
            [vertx.http :as http]
            [vertx.core :as core]))

(defn init-server []
  (vertx/set-vertx! (vertx/vertx)))

(defn req-handler [req]
  (-> (http/server-response req)
      (http/end "Hello from Vert.x!!!")))

(defn start-server []
  (-> (http/server)
      (http/on-request req-handler)
      (http/listen 4000 "localhost")) )

(defn stop-server [server]
  (http/close server))
