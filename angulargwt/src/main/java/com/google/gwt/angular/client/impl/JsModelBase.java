package com.google.gwt.angular.client.impl;

import com.google.gwt.angular.client.Model;
import com.google.gwt.angular.client.Util;
import com.google.gwt.core.client.JavaScriptObject;
import elemental.json.JsonObject;

/**
 * Base of all Model implementations.
 */
public abstract class JsModelBase<T extends Model<T>> extends JavaScriptObject implements Model<T> {
  protected JsModelBase() {
  }

  @Override
  final public JsonObject json() {
    return Util.reinterpret_cast(this);
  }
}
