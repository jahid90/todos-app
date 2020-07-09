package io.jahiduls.todos.queries;

import io.jahiduls.todos.dao.TodoRepository;

public interface Query {
    QueryResult handle(TodoRepository repository);
}
