package io.jahiduls.todos.controller;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.processors.QueryProcessor;
import io.jahiduls.todos.queries.QueryFactory;
import io.jahiduls.todos.queries.QueryResult;
import io.jahiduls.todos.resources.TodoResource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
public class TodosQueryController {

    private final QueryProcessor processor;
    private final QueryFactory factory;

    @GetMapping("/todos")
    public List<TodoResource> todos(@RequestParam("completed") final Optional<Boolean> isCompleted) {

        log.info("[GET ALL] request received");

        // If the url has the 'completed' param, return filtered results
        if (isCompleted.isPresent()) {
            return filteredQuery(isCompleted.get());
        }

        // Else return all the results
        return fullQuery();
    }

    private List<TodoResource> fullQuery() {

        log.info("Running full query.");

        final QueryResult<List<Todo>, String> result = processor.process(factory.getAll());
        final List<Todo> todos = result.data;
        final List<TodoResource> response = todos.stream().map(TodoResource::fromTodo).collect(Collectors.toList());

        log.info("Response: {}", response);

        return response;
    }

    private List<TodoResource> filteredQuery(final boolean isCompleted) {

        log.info("Param: [isCompleted: {}] is present. Running filtered query.", isCompleted);

        final QueryResult<List<Todo>, String> result = processor.process(factory.getFiltered(isCompleted));
        final List<Todo> todos = result.data;
        final List<TodoResource> response = todos.stream().map(TodoResource::fromTodo).collect(Collectors.toList());

        log.info("Response: {}", response);

        return response;
    }

    @GetMapping("/todo/{id}")
    public TodoResource todo(@PathVariable final String id) {

        log.info("[GET ONE] [{}] request received.", id);

        final QueryResult<Optional<Todo>, String> result = processor.process(factory.getOne(id));
        final Optional<Todo> maybeTodo = result.data;

        if (maybeTodo.isEmpty()) {
            throw ClientException.notFound();
        }

        final TodoResource response = TodoResource.fromTodo(maybeTodo.get());

        log.info("Response: {}", response);

        return response;
    }

}
