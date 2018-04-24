(ns graphql-builder-repro.core
  (:require [reagent.core :as r]
            [graphql-builder.core :as core]
            [graphql-builder.parser :refer-macros [defgraphql]]))

(def ReactNative (js/require "react-native"))
(def expo (js/require "expo"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))

(defgraphql queries "resources/queries.graphql")
(def query-map (core/query-map queries))

(defn app-root []
  [scroll-view {:content-container-style {:padding 20}}
   [text "Queries"]
   [text (pr-str queries)]
   [text "Query map"]
   [text (pr-str query-map)]])

(defn init []
  (.registerRootComponent expo (r/reactify-component app-root)))
