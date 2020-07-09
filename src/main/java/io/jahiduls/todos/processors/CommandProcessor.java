package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;
import io.jahiduls.todos.dao.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommandProcessor {

    private final TodoRepository repository;

    public void process(final Command command) {
        command.execute(repository);
    }

}
