package io.jahiduls.todos.queries;

import org.springframework.stereotype.Component;

@Component
public final class QueryFactory {

    public Query getAll() {
        return GetAllQuery.builder().build();
    }

    public Query getAllCompleted() {
        return GetAllCompletedQuery.builder().build();
    }

    public Query getAllIncomplete() {
        return GetAllIncompleteQuery.builder().build();
    }

    public Query getFiltered(final boolean isCompleted) {
        return GetFilteredQuery.builder().wantCompleted(isCompleted).build();
    }

    public Query getOne(final String id) {
        return GetOneQuery.builder().id(id).build();
    }

}
