package com.google.gwt.todomvc.client;

import com.google.gwt.angular.client.AngularModule;
import com.google.gwt.angular.client.NgDepends;
import com.google.gwt.angular.client.NgName;

@NgName("com/google/gwt/todomvc")
@NgDepends({TodoStorage.class, TodoFilter.class, TodoController.class,
  TodoBlurDirective.class, TodoFocusDirective.class})
public class TodoAppModule implements AngularModule {
}
