package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;
import io.jahiduls.todos.services.TodoService;
import java.util.concurrent.ExecutorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class TodoCommandProcessor implements CommandProcessor {

    private final ExecutorService executorService;
    private final TodoService service;

    @Override
    public void process(final Command command) {

        log.info("Submitting [{}] for execution", command.getClass().getSimpleName());

        executorService.submit(() -> command.execute(service));

    }

}
