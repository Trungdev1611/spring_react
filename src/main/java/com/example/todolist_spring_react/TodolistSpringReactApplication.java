package com.example.todolist_spring_react;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistSpringReactApplication {
	private static final Logger log = LoggerFactory.getLogger(TodolistSpringReactApplication.class);
	public static void main(String[] args) {
		log.debug("Debug message from main");
		log.info("Info message from main");
		log.warn("Warning message from main");
		log.error("Error message from main");
		SpringApplication.run(TodolistSpringReactApplication.class, args);
	}

}
