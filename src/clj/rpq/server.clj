(ns rpq.server
  (:require [rpq.http :as http]))

(defn server []
  (http/init-server)
  {})

(defn start [s]
  (let [http-server (http/start-server)]
    (assoc s :server http-server)))

(defn stop [s]
  (when s
    (let [http-server (:server s)]
      (http/stop-server http-server))
    nil))




