package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;

@Builder
public class GetFilteredQuery implements Query {

    private final boolean wantCompleted;

    @Override
    public QueryResult handle(final TodoService service) {

        if (wantCompleted) {
            final GetAllCompletedQuery query = GetAllCompletedQuery.builder().build();

            return query.handle(service);

        } else {
            GetAllIncompleteQuery query = GetAllIncompleteQuery.builder().build();

            return query.handle(service);
        }
    }
}
