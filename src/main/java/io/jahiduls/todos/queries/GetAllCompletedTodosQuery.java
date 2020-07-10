package io.jahiduls.todos.queries;

import io.jahiduls.todos.services.TodoService;
import lombok.Builder;

@Builder
public class GetAllCompletedTodosQuery implements Query {

    private static final boolean COMPLETED = true;

    @Override
    public QueryResult handle(final TodoService service) {
        final QueryResult result = new QueryResult();

        result.data = service.getAllByCompleted(COMPLETED);
        result.error = "";

        return result;
    }

}
