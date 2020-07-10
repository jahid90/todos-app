package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;
import io.jahiduls.todos.dao.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TodoCommandProcessor implements CommandProcessor {

    private final TodoRepository repository;

    @Override
    public void process(final Command command) {
        command.execute(repository);
    }

}
