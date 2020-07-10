package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.TodoService;

public interface Command {
    void execute(final TodoService service);
}
