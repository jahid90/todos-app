package io.jahiduls.todos.processors.commands;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.resources.TodoResource;
import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Builder
public class AddCommand extends Command {

    private TodoRepository repository;
    private TodoResource resource;

    @Override
    public void execute() {

        log.info("{}", repository);
        log.info("{}", this);

        repository.save(Todo.fromResource(resource));
    }
}
