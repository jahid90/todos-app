package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoService;

public interface Query {
    QueryResult handle(final TodoService service);
}
