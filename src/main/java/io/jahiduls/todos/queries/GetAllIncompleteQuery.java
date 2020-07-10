package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;

@Builder
public class GetAllIncompleteQuery implements Query {

    private static final boolean INCOMPLETE = false;

    @Override
    public QueryResult handle(final TodoService service) {
        final QueryResult result = new QueryResult();

        result.data = service.getAllByCompleted(INCOMPLETE);
        result.error = "";

        return result;
    }
}
