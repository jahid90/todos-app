package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.services.TodoService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Builder;

@Builder
public class GetAllCompletedTodosQuery implements Query {

    @Override
    public QueryResult handle(final TodoService service) {

        final List<String> todoIds = service.getAllCompletedIds();
        final List<Todo> todos = todoIds.stream()
                .map(service::getOneById)
                .map(Optional::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        final QueryResult<List<Todo>, String> result = new QueryResult<>();
        result.data = todos;
        result.error = "";

        return result;
    }

}
