package io.jahiduls.todos.commands;

import io.jahiduls.todos.services.TodoService;

public interface Command {
    void execute(final TodoService service);
}
