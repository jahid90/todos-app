package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;
import lombok.Builder;

@Builder
public class GetAllQuery implements Query {

    @Override
    public QueryResult handle(final TodoRepository repository) {

        final QueryResult result = new QueryResult();

        result.data = repository.findAll();
        result.error = "";

        return result;
    }
}
