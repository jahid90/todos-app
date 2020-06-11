package io.jahiduls.todos.processors.commands;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Builder
public class DeleteCommand extends Command {

    private TodoRepository repository;
    private String id;

    @Override
    public void execute() {

        log.info("{}", this);

        repository.deleteById(id);
    }
}
