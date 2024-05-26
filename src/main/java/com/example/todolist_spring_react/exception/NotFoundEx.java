package com.example.todolist_spring_react.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundEx extends RuntimeException {
    private String msg = "Not Found";

    public NotFoundEx(String msg) {
        this.msg = msg;
    }

    public NotFoundEx() {
    }
}
