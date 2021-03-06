package com.google.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for all implementations of AngularJs conntrollers in GWT. To use,
 * subclass {@code AngularController} and define an <code>onInit</code> method taking at least one
 * {@link Scope} object. Each parameter of the <code>onInit</code> method is assumed to be an injectable type, either
 * a builtin type, or a custom injectable type defined by {@link NgInject}.
 * <p/>
 * <p>Any additional public methods defined will automatically be exported to the <code>$scope</code> object used by
 * the controller and callable from the view.
 * <p/>
 * <pre>
 *     public class MyController extends AngularController {
 *         public void onInit(Scope scope) {
 *             // publish key "foo" with value "bar" into $scope
 *             scope.put("foo", "bar");
 *         }
 *
 *         // automatically published as $scope.doIt
 *         public void doIt(String arg) {
 *             Window.alert(scope.getString("foo") + " " + arg);
 *         }
 *     }
 * </pre>
 * <p/>
 * See the documentation for {@link Scope} for how to define custom Scope subtypes with type-safe accessors.
 *
 * @author Ray Cromwell (cromwellian@gmail.com)
 */
public class AngularController<T extends Scope> {
  // convenience variable for accessing scope in published controller methods
  protected T scope;

  protected AngularController() {
  }

  protected void setScope(T scope) {
    this.scope = scope;
  }

  protected void register(JavaScriptObject module) {
  }
}
