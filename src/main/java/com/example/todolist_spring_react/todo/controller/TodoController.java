package com.example.todolist_spring_react.todo.controller;

import com.example.todolist_spring_react.Response;
import com.example.todolist_spring_react.todo.entity.Todo;
import com.example.todolist_spring_react.todo.service.TodoService;
import com.example.todolist_spring_react.todo.service.TodoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create_todo")
    ResponseEntity<Response> createTodo(@Valid @RequestBody Todo todoItem) {
        todoService.createTodo(todoItem);
        Response responseSuccess = Response.successResponse(null);
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }
    @GetMapping("/todos")
    ResponseEntity<Response> getListTodo() {
        List<Todo> todoList = todoService.getListTodo();
        Response responseSuccess = Response.successResponse(todoList);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @PutMapping("/todos/{idTodo}")
    ResponseEntity<Response> updateTodo(@PathVariable Long idTodo, @RequestBody Todo todoItem) {
        Todo todoReceived = todoService.updateTodo(idTodo, todoItem);
        Response responseSuccess = Response.successResponse(todoReceived);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping("/todos/{idTodo}")
    ResponseEntity<Response> deleteTodo(@PathVariable Long idTodo) {
        todoService.deleteTodo(idTodo );
        Response responseSuccess = Response.successResponse(null);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
