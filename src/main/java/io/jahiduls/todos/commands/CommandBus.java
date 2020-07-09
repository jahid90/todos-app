package io.jahiduls.todos.commands;

import io.jahiduls.todos.processors.CommandProcessor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CommandBus {

    private final CommandProcessor commandProcessor;

    public void emit(final Command command) {
        commandProcessor.process(command);
    }

}
