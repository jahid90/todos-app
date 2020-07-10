package io.jahiduls.todos.queries;

import org.springframework.stereotype.Component;

@Component
public final class QueryFactory {

    public Query getAll() {
        return GetAllTodosQuery.builder().build();
    }

    public Query getAllCompleted() {
        return GetAllCompletedTodosQuery.builder().build();
    }

    public Query getAllIncomplete() {
        return GetAllIncompleteTodosQuery.builder().build();
    }

    public Query getFiltered(final boolean isCompleted) {
        return GetFilteredTodosQuery.builder().wantCompleted(isCompleted).build();
    }

    public Query getOne(final String id) {
        return GetOneTodoQuery.builder().id(id).build();
    }

}
