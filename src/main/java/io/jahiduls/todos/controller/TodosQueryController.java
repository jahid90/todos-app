package io.jahiduls.todos.controller;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.resources.TodoResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class TodosQueryController {

    @Autowired
    private TodoRepository repository;

    @GetMapping("/todos")
    public List<TodoResource> todos() {
        final List<TodoResource> results = repository.findAll().stream()
                .map(TodoResource::fromTodo)
                .collect(Collectors.toList());

        log.info("All todos found: {}", results);

        return results;
    }

    @GetMapping("/todo/{id}")
    public TodoResource todo(@PathVariable final String id) throws RuntimeException {
        final Optional<Todo> todo = repository.findById(id);

        todo.ifPresentOrElse(it -> log.info("Todo with id: {} was found", it.id),
                () -> log.warn("Todo with id: {} was not found.", id));

        return todo.map(TodoResource::fromTodo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such todo found."));
    }

}
