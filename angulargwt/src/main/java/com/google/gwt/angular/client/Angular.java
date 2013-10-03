package com.google.gwt.angular.client;

import elemental.util.ArrayOf;

import java.util.Iterator;

/**
 * @author Andrei Korzhevskii (a.korzhevskiy@gmail.com)
 */
public class Angular {

  public static native void bootstrap(String moduleName) /*-{
      $wnd.angular.bootstrap($doc, [moduleName]);
  }-*/;

  public static <S> Iterable<S> iterable(final ArrayOf<S> array) {
    return new Iterable<S>() {
      public Iterator<S> iterator() {
        return new Iterator<S>() {
          int next = 0;

          public boolean hasNext() {
            return next < array.length();
          }

          public S next() {
            return array.get(next++);
          }

          public void remove() {
          }
        };
      }
    };
  }

}
