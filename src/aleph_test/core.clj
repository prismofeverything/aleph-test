(ns aleph-test.core
  (:use lamina.core
        aleph.http))

(def broadcast-channel (channel))

(defn length-test
  [message]
  (println message)
  message)

(defn chat-handler [ch handshake]
  (siphon (map* length-test ch) broadcast-channel)
  (siphon broadcast-channel ch))

(defn -main []
  (start-http-server chat-handler {:port 8080 :websocket true}))
