package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoService;
import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.resources.TodoResource;
import java.util.Optional;
import lombok.Builder;

@Builder
public class EditTodoCommand implements Command {

    private final TodoResource resource;

    @Override
    public void execute(final TodoService service) {

        final Optional<Todo> maybeTodo = service.getOneById(resource.getId());

        // Do we really need to check? Can we just create it if it does not exist? Avoids the read.
        if (maybeTodo.isEmpty()) {
            throw ClientException.notFound();
        }

        service.saveTodo(resource.toTodo());
    }

}
