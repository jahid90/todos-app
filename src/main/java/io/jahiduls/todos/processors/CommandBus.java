package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CommandBus {

    private final CommandProcessor processor;

    public void emit(final Command command) {
        processor.process(command);
    }

}
