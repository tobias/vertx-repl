(ns rpq.http
  (:require [vertx.core :as vertx]
            [vertx.http :as http]))

(defn- req-handler [req]
  (-> (http/server-response req)
      (http/end "Hello from vert.x!")))

(defn init
  []
  (-> (http/server)
      (http/on-request req-handler)
      (http/listen 8080)))


