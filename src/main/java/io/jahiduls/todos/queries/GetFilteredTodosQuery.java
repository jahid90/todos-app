package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;

@Builder
public class GetFilteredTodosQuery implements Query {

    private final boolean wantCompleted;

    @Override
    public QueryResult handle(final TodoService service) {

        if (wantCompleted) {
            final GetAllCompletedTodosQuery query = GetAllCompletedTodosQuery.builder().build();

            return query.handle(service);

        } else {
            GetAllIncompleteTodosQuery query = GetAllIncompleteTodosQuery.builder().build();

            return query.handle(service);
        }
    }
}
