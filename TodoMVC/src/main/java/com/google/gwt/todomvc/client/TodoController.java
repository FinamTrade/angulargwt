package com.google.gwt.todomvc.client;

import com.google.gwt.angular.client.*;
import com.google.gwt.core.client.GWT;
import elemental.js.util.JsArrayOf;
import elemental.util.ArrayOf;

@NgInject(name = "TodoCtrl")
public class TodoController extends AngularController<TodoScope> {

  interface TodoJsoFactory extends JsoFactory {
    Todo makeTodo();
  }

  private final TodoJsoFactory jsoFactory = GWT.create(TodoJsoFactory.class);

  private ArrayOf<Todo> todos;
  private Location location;
  private TodoStorage store;
  private TodoFilter filterFilter;

  public void onInit(TodoScope scope, Location location, TodoStorage store, TodoFilter filter) {
    this.location = location;
    this.store = store;
    this.filterFilter = filter;
    scope.newTodo("")
        .editedTodo(null)
        .location(location);
    this.todos = store.get();
    scope.todos(todos);
    if ("".equals(location.path())) {
      location.path("/");
    }
  }

  @NgWatch(value = "todos", objEq = true)
  public void $watchTodos() {
    Todo todoPredicate = jsoFactory.makeTodo();
    todoPredicate.setCompleted(false);
    scope.remainingCount(filterFilter.filter(todos, todoPredicate).length())
        .doneCount(todos.length() - scope.remainingCount())
        .allChecked(scope.remainingCount() != 0);
    store.put(todos);
  }

  @NgWatch("location.path()")
  public void $watchPath(String path) {
    scope.statusFilter("/active".equals(path) ?
            jsoFactory.makeTodo().setCompleted(false) :
        "/completed".equals(path) ?
                jsoFactory.makeTodo().setCompleted(true) : null);
  }

  public void addTodo() {
    if (scope.newTodo().length() == 0) {
      return;
    }
    Todo newTodo = jsoFactory.makeTodo();
    newTodo.setTitle(scope.newTodo())
        .setCompleted(false);
    todos.push(newTodo);
    scope.newTodo("");
  }

  public void doneEditing(Todo todo) {
    scope.editedTodo(null);
    if ("".equals(todo.getTitle())) {
      removeTodo(todo);
    }
  }

  public void editTodo(Todo todo) {
    scope.editedTodo(todo);
  }

  public void removeTodo(Todo todo) {
    todos.splice(todos.indexOf(todo), 1);
  }

  public void markAll(boolean done) {
    for (Todo todo : Angular.iterable(todos)) {
      todo.setCompleted(done);
    }
  }

  public void clearDoneTodos() {
    ArrayOf<Todo> result = JsArrayOf.create();
    for (Todo todo : Angular.iterable(todos)) {
      if (!todo.getCompleted()) {
        result.push(todo);
      }
    }
    scope.todos(result);
  }
}
