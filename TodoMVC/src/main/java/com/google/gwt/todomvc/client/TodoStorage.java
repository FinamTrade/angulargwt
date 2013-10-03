package com.google.gwt.todomvc.client;

import com.google.gwt.angular.client.NgInject;
import com.google.gwt.angular.client.Util;
import elemental.client.Browser;
import elemental.html.Storage;
import elemental.js.util.JsArrayOf;
import elemental.js.util.Json;
import elemental.json.JsonValue;
import elemental.util.ArrayOf;

/**
 * Injected service for storage.
 */
@NgInject(name = "todoStorage")
public class TodoStorage {
  private static final String STORAGE_ID = "todos-angularjs";

  public ArrayOf<Todo> get() {
    Storage localStorage = Browser.getWindow().getLocalStorage();
    ArrayOf<Todo> todos = Util.reinterpret_cast(Json.parse(localStorage.getItem(STORAGE_ID)));
    return todos == null ? JsArrayOf.<Todo>create() : todos;
  }

  public void put(ArrayOf<Todo> todos) {
    Storage localStorage = Browser.getWindow().getLocalStorage();
    JsonValue value = Util.reinterpret_cast(todos);
    localStorage.setItem(STORAGE_ID, value.toJson());
  }
}
