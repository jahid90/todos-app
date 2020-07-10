package io.jahiduls.todos.commands;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class DeleteTodoCommand implements Command {

    private final String id;

    @Override
    public void execute(final TodoService service) {
        service.deleteTodoById(id);
    }

}
