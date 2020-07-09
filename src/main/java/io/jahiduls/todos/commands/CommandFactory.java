package io.jahiduls.todos.commands;

import io.jahiduls.todos.resources.TodoResource;
import org.springframework.stereotype.Component;

@Component
public final class CommandFactory {

    public Command addCommand(final TodoResource resource) {
        return AddCommand.builder().resource(resource).build();
    }

    public Command editCommand(final TodoResource resource) {
        return EditCommand.builder().resource(resource).build();
    }

    public Command deleteCommand(final String id) {
        return DeleteCommand.builder().id(id).build();
    }

}
