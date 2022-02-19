package io.jahiduls.todos.commands;

import io.jahiduls.todos.services.TodoService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class IndexTodoIdsCommand implements Command {

    @Override
    public void execute(final TodoService service) {

        service.getAllIds();
        service.getAllCompletedIds();
        service.getAllInCompleteIds();

        log.info("{} executed successfully", this.getClass().getSimpleName());

    }

}
