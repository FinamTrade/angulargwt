package com.google.gwt.angular.client;

public class Util {
  /**
   * Only safe to do with JavaScriptObjects.
   */
  public static native <T> T reinterpret_cast(Object o) /*-{
      return o;
  }-*/;

  //Use json().toJson() instead
/*
  public static String toJson(Object o) {
    JsonValue value = reinterpret_cast(o);
    return value.toJson();
  }
*/

/*
  public static <T> T make(Object factory) {
    return ((Factory<T>) factory).create();
  }
*/
}
