package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;

@Builder
public class GetAllCompletedQuery implements Query {

    private static final boolean COMPLETED = true;

    @Override
    public QueryResult handle(TodoRepository repository) {
        final QueryResult result = new QueryResult();

        result.data = repository.findAllByIsCompleted(COMPLETED);
        result.error = "";

        return result;
    }
}
