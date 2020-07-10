package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;

@Builder
public class GetOneQuery implements Query {

    private final String id;

    @Override
    public QueryResult handle(final TodoService service) {
        final QueryResult result = new QueryResult();

        result.data = service.getOneById(id);
        result.error = "";

        return result;
    }

}
