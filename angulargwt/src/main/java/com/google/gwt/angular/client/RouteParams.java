package com.google.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The angular.js $routeParams object.
 */
@NgInject(name = "$routeParams")
final public class RouteParams extends JavaScriptObject {
    protected RouteParams() {
    }

//    public JsonObject json() {
//      return Util.reinterpret_cast(this);
//    }

    public native String get(String key) /*-{
      return this[key];
    }-*/;
}
