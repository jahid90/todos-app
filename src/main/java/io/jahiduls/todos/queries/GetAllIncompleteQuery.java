package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;

@Builder
public class GetAllIncompleteQuery implements Query {

    private static final boolean INCOMPLETE = false;

    @Override
    public QueryResult handle(TodoRepository repository) {
        final QueryResult result = new QueryResult();

        result.data = repository.findAllByIsCompleted(INCOMPLETE);
        result.error = "";

        return result;
    }
}
