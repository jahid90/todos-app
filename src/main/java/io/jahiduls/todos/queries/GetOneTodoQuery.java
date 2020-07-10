package io.jahiduls.todos.queries;

import io.jahiduls.todos.services.TodoService;
import lombok.Builder;

@Builder
public class GetOneTodoQuery implements Query {

    private final String id;

    @Override
    public QueryResult handle(final TodoService service) {
        final QueryResult result = new QueryResult();

        result.data = service.getOneById(id);
        result.error = "";

        return result;
    }

}
