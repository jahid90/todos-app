package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;

@Builder
public class GetAllCompletedQuery implements Query {

    private static final boolean COMPLETED = true;

    @Override
    public QueryResult handle(final TodoService service) {
        final QueryResult result = new QueryResult();

        result.data = service.getAllByCompleted(COMPLETED);
        result.error = "";

        return result;
    }
}
