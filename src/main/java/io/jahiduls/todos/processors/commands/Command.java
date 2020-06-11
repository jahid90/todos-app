package io.jahiduls.todos.processors.commands;

import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.exceptions.ServiceException;

public abstract class Command {
    public abstract void execute() throws ClientException, ServiceException;
}
