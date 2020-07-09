package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.TodoRepository;

public interface Command {
    void execute(TodoRepository repository);
}
