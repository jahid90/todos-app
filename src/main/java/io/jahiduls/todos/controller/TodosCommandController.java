package io.jahiduls.todos.controller;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.resources.TodoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosCommandController {

    @Autowired
    private TodoRepository repository;

    @PostMapping("/todos")
    public TodoResource add(@RequestBody TodoResource resource) {
        final Todo savedTodo = repository.save(Todo.fromResource(resource));

        return TodoResource.fromTodo(savedTodo);
    }

}
