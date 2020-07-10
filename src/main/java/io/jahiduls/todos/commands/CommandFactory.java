package io.jahiduls.todos.commands;

import io.jahiduls.todos.resources.TodoResource;
import org.springframework.stereotype.Component;

@Component
public final class CommandFactory {

    public Command addCommand(final TodoResource resource) {
        return AddTodoCommand.builder().resource(resource).build();
    }

    public Command editCommand(final TodoResource resource) {
        return EditTodoCommand.builder().resource(resource).build();
    }

    public Command deleteCommand(final String id) {
        return DeleteTodoCommand.builder().id(id).build();
    }

    public Command toggleCommand(final String id) {
        return ToggleTodoCommand.builder().id(id).build();
    }

}
