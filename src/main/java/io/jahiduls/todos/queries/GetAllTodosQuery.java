package io.jahiduls.todos.queries;

import io.jahiduls.todos.services.TodoService;
import lombok.Builder;

@Builder
public class GetAllTodosQuery implements Query {

    @Override
    public QueryResult handle(final TodoService service) {

        final QueryResult result = new QueryResult();

        result.data = service.getAll();
        result.error = "";

        return result;
    }

}
