(ns rpq.vertx
  (:require [vertx.http :as http]))

(defn req-handler [req]
  (-> (http/server-response req)
      (http/end "Hello from Vert.x!")))

(-> (http/server)
    (http/on-request req-handler)
    (http/listen 4000 "localhost"))