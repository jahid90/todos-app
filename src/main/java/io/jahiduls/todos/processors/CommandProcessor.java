package io.jahiduls.todos.processors;

import io.jahiduls.todos.processors.commands.AddCommand;
import io.jahiduls.todos.processors.commands.Command;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.exceptions.ServiceException;
import io.jahiduls.todos.processors.commands.DeleteCommand;
import io.jahiduls.todos.processors.commands.EditCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandProcessor implements Processor {

    @Autowired
    private TodoRepository repository;

    @Override
    public void process(final Command command) throws ClientException, ServiceException {
        command.execute();
    }

    public final AddCommand.AddCommandBuilder addCommandBuilder() {
        return AddCommand.builder().repository(repository);
    }

    public final EditCommand.EditCommandBuilder editCommandBuilder() {
        return EditCommand.builder().repository(repository);
    }

    public final DeleteCommand.DeleteCommandBuilder deleteCommandBuilder() {
        return DeleteCommand.builder().repository(repository);
    }
}
