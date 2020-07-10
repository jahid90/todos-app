package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.exceptions.ClientException;
import java.util.Optional;
import lombok.Builder;

@Builder
public class ToggleTodoCommand implements Command {

    private final String id;

    @Override
    public void execute(final TodoRepository repository) {
        final Optional<Todo> maybeTodo = repository.findById(id);

        if (maybeTodo.isEmpty()) {
            throw ClientException.notFound();
        }

        final Todo todoToToggle = maybeTodo.get();
        todoToToggle.isCompleted = !todoToToggle.isCompleted;

        repository.save(todoToToggle);
    }

}
