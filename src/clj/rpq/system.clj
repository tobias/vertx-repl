(ns rpq.system
  (:require
   [rpq.server :as server]))

(defn system []
  {:server (server/server)})

(defn start [sys]
  (let [server (:server sys)]
    (assoc sys :server (server/start server))))

(defn stop [sys]
  (let [server (:server sys)]
    (assoc sys :server (server/stop server))))

