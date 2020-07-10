package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.resources.TodoResource;
import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Builder
public class AddTodoCommand implements Command {

    private final TodoResource resource;

    @Override
    public void execute(final TodoRepository repository) {
        repository.save(resource.toTodo());
    }
}
