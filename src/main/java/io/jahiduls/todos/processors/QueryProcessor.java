package io.jahiduls.todos.processors;

import io.jahiduls.todos.dao.TodoRepository;
import io.jahiduls.todos.queries.Query;
import io.jahiduls.todos.queries.QueryResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueryProcessor {

    private final TodoRepository repository;

    public QueryResult process(final Query query) {
        return query.handle(repository);
    }

}