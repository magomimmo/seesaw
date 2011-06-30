(ns seesaw.forms
  (:import
    java.awt.Component
    com.jgoodies.forms.builder.DefaultFormBuilder))

(defprotocol ComponentSpec
  (append [this builder] "Add the given component to the form builder"))

(extend-protocol ComponentSpec
  Component
  (append [this builder]
    (.append builder this))
  String
  (append [this builder]
    (.append builder this)))

(defn span
  "Add the given component spanning several columns."
  [component column-span]
  (reify
    ComponentSpec
    (append [this builder]
      (.append builder component column-span))))
