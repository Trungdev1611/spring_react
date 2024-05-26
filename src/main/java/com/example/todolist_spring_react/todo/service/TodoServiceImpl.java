package com.example.todolist_spring_react.todo.service;

import com.example.todolist_spring_react.exception.NotFoundEx;
import com.example.todolist_spring_react.todo.entity.Todo;
import com.example.todolist_spring_react.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public void createTodo(Todo todoItem) {
        System.out.println(111222);
        todoRepository.save(todoItem);
    }

    @Override
    public List<Todo> getListTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo updateTodo(Long idTodo, Todo todoItem) {
        Optional<Todo> todo = todoRepository.findById(idTodo);
        Todo todoReceived = todo.orElseThrow(() -> new NotFoundEx("Not found id to update"));

        todoReceived.setName(todoItem.getName());
        todoReceived.setDateFinish(todoItem.getDateFinish());
        todoReceived.setFinish(todoItem.getFinish());
        todoReceived.setActive(todoItem.getActive());

        todoRepository.save(todoReceived);
        return todoReceived;
    }


    @Override
    public void deleteTodo(Long idTodo) {
        Optional<Todo> todo = todoRepository.findById(idTodo);
        Todo todoReceived = todo.orElseThrow(() -> new NotFoundEx("Not found id to delete"));
        todoRepository.deleteById(idTodo);
    }
}
