package io.jahiduls.todos.controller;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.resources.TodoResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@RestController
public class TodosCommandController {

    @Autowired
    private TodoRepository repository;

    @PostMapping("/todos")
    public TodoResource add(@RequestBody final TodoResource resource) {
        final Todo savedTodo = repository.save(Todo.fromResource(resource));

        return TodoResource.fromTodo(savedTodo);
    }

    @PostMapping("/todo/edit/{id}")
    public TodoResource edit(@PathVariable final String id, @RequestBody final TodoResource resource) {

        log.info("Got an edit request for: {}", id);
        log.info("New data: {}", resource);

        // Ensure that the ids in the url and the request body match
        if (!id.equals(resource.getId())) {
            log.warn("Ids in url and request body do not match.");

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ids in the url and the request body do not match.");
        }

        // Find the appropriate entity
        final Optional<Todo> maybeTodo = repository.findById(id);

        // If entity was not found, throw an exception
        if (!maybeTodo.isPresent()) {
            log.warn("No such entity found.");

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such entity found.");
        }

        final Todo todo = maybeTodo.get();
        todo.text = resource.getText();
        todo.isCompleted = resource.isCompleted();
        // Update the entity in the data store
        repository.save(todo);

        log.info("Entity with id: {} successfully updated.", id);

        return TodoResource.fromTodo(todo);
    }

    @DeleteMapping("/todo/delete/{id}")
    public HttpStatus delete(@PathVariable final String id) {

        log.info("Got a delete request for: {}", id);

        repository.deleteById(id);

        log.info("Entity with id: {} successfully deleted.", id);

        return HttpStatus.OK;
    }

}
