package com.google.gwt.angular.client.impl;

import com.google.gwt.angular.client.NgElement;
import elemental.events.EventListener;
import elemental.js.dom.JsElement;

/**
 * JSO implementation of NgElement.
 */
public class JsNgElement extends JsElement implements NgElement {
  protected JsNgElement() {
  }

  @Override
  final public native void bind(String eventType, Runnable func) /*-{
    this.bind(eventType, $entry(function () {
      func.@java.lang.Runnable::run()();
    }));
  }-*/;

  @Override
  final public native void bind(String eventType, EventListener listener) /*-{
    this.bind(eventType, $entry(@elemental.js.dom.JsElementalMixinBase::getHandlerFor(Lelemental/events/EventListener;)(listener)));
  }-*/;
}
