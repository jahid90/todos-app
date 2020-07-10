package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;
import lombok.Builder;
import org.springframework.cache.annotation.Cacheable;

@Builder
public class GetAllQuery implements Query {

    @Override
    @Cacheable("todos")
    public QueryResult handle(final TodoService service) {

        final QueryResult result = new QueryResult();

        result.data = service.getAll();
        result.error = "";

        return result;
    }
}
