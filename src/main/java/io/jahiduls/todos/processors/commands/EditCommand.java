package io.jahiduls.todos.processors.commands;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.exceptions.TodoNotFoundException;
import io.jahiduls.todos.resources.TodoResource;
import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@ToString
@Builder
public class EditCommand extends Command {

    private TodoRepository repository;
    private TodoResource resource;

    @Override
    public void execute() throws TodoNotFoundException {

        log.info("{}", this);

        final Optional<Todo> maybeTodo = repository.findById(resource.getId());

        if (!maybeTodo.isPresent()) {
            throw new TodoNotFoundException("No such entity found.");
        }

        final Todo todo = maybeTodo.get();
        todo.text = resource.getText();
        todo.isCompleted = resource.isCompleted();

        repository.save(todo);
    }
}
