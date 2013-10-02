package com.google.gwt.angular.client.impl;

import com.google.gwt.angular.client.Scope;
import com.google.gwt.angular.client.WatchFunction;

/**
 * Base class of generated scopes.
 */
public class JsScopeBase<T extends Scope<T>> extends JsModelBase<T> implements Scope<T> {
  protected JsScopeBase() {
  }

  @Override
  public final native <S> void $watch(String expr, WatchFunction<S> func) /*-{
    this.$watch(expr, $entry(function (newVal) {
      func.@com.google.gwt.angular.client.WatchFunction::exec(Ljava/lang/Object;)(newVal);
    }));
  }-*/;

  @Override
  public final native void $apply() /*-{
    this.$apply(null);
  }-*/;

  @Override
  public final native void $apply(String expr) /*-{
    this.$apply(expr);
  }-*/;

  @Override
  public final native void $apply(Runnable runnable) /*-{
    this.$apply($entry(function () {
      runnable.@java.lang.Runnable::run()();
    }));
  }-*/;

  @Override
  public final void $onDestroy(Runnable runnable) {
    $on("$destroy", runnable);
  }

  @Override
  public final native void $on(String eventName, Runnable runnable) /*-{
    this.$on(eventName, $entry(function () {
      runnable.@java.lang.Runnable::run()();
    }));
  }-*/;
}
