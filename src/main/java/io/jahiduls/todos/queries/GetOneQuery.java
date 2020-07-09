package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;

@Builder
public class GetOneQuery implements Query {

    private final String id;

    @Override
    public QueryResult handle(final TodoRepository repository) {
        final QueryResult result = new QueryResult();

        result.data = repository.findById(id);
        result.error = "";

        return result;
    }

}
