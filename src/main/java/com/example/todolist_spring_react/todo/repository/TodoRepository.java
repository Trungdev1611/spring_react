package com.example.todolist_spring_react.todo.repository;

import com.example.todolist_spring_react.todo.entity.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
