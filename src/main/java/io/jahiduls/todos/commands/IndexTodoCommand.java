package io.jahiduls.todos.commands;

import io.jahiduls.todos.services.TodoService;
import java.util.List;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class IndexTodoCommand implements Command {

    @Override
    public void execute(final TodoService service) {

        final List<String> todoIds = service.getAllIds();
        todoIds.forEach(service::getOneById);

        log.info("{} executed successfully", this.getClass().getSimpleName());

    }

}
