package io.jahiduls.todos.processors;

import io.jahiduls.todos.queries.Query;
import io.jahiduls.todos.queries.QueryResult;

public interface QueryProcessor {
    QueryResult process(final Query query);
}
