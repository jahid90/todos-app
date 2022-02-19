package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;

public interface CommandProcessor {
    void process(final Command command);
}
