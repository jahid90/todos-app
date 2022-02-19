package io.jahiduls.todos.queries;

import io.jahiduls.todos.services.TodoService;

public interface Query {
    QueryResult handle(final TodoService service);
}
