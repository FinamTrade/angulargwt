package com.google.gwt.angular.client.todomvc;

import com.google.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * Entry point for Angular TodoMvc App.
 */
public class TodoApp implements EntryPoint {
  /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {
    GWT.create(TodoAppModule.class);
    Angular.bootstrap("todomvc");
  }
}
