package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class DeleteCommand implements Command {

    private final String id;

    @Override
    public void execute(final TodoRepository repository) {
        repository.deleteById(id);
    }
}
