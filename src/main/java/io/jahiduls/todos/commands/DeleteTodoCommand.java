package io.jahiduls.todos.commands;

import io.jahiduls.todos.services.TodoService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class DeleteTodoCommand implements Command {

    private final String id;

    @Override
    public void execute(final TodoService service) {

        service.deleteTodoById(id);

        log.info("{} executed successfully", this.getClass().getSimpleName());

    }

}
