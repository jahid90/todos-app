package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;

@Builder
public class GetFilteredQuery implements Query {

    private final boolean wantCompleted;

    @Override
    public QueryResult handle(final TodoRepository repository) {

        if (wantCompleted) {
            final GetAllCompletedQuery query = GetAllCompletedQuery.builder().build();

            return query.handle(repository);

        } else {
            GetAllIncompleteQuery query = GetAllIncompleteQuery.builder().build();

            return query.handle(repository);
        }
    }
}
