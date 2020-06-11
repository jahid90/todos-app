package io.jahiduls.todos.processors;

import io.jahiduls.todos.processors.commands.Command;
import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.exceptions.ServiceException;

public interface Processor {
    void process(final Command command) throws ClientException, ServiceException;
}
