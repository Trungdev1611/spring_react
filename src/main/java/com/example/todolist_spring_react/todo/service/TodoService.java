package com.example.todolist_spring_react.todo.service;

import com.example.todolist_spring_react.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    void createTodo(Todo todoItem);
    List<Todo> getListTodo();
    Todo updateTodo(Long idTodo, Todo todoItem);
    void deleteTodo(Long idTodo);
}
