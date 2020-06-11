package io.jahiduls.todos.processors;

import io.jahiduls.todos.processors.commands.Command;
import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.exceptions.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class QueryProcessor implements Processor {

    @Override
    public void process(final Command command) throws ClientException, ServiceException {
        command.execute();
    }
}
