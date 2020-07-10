package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoService;
import io.jahiduls.todos.exceptions.ClientException;
import java.util.Optional;
import lombok.Builder;

@Builder
public class ToggleTodoCommand implements Command {

    private final String id;

    @Override
    public void execute(final TodoService service) {

        final Optional<Todo> maybeTodo = service.getOneById(id);

        if (maybeTodo.isEmpty()) {
            throw ClientException.notFound();
        }

        final Optional<Todo> updatedTodo = maybeTodo.map(todo -> new Todo(todo.id, todo.text, !todo.isCompleted));

        service.saveTodo(updatedTodo.get());
    }

}
