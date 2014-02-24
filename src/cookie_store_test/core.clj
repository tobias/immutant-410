(ns cookie-store-test.core
  (:require [ring.middleware.session.cookie :as rc]
            [noir.session :as ns]))

(defn handler
  [req]
  {:status 200
   :content-type "text/plain"
   :body (-> req (dissoc :body) pr-str)
   :session {:foo :bar}})

(def app 
  (-> #'handler
    (ns/wrap-noir-session {:store (rc/cookie-store)})))
