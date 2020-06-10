package io.jahiduls.todos.resources;

import io.jahiduls.todos.dao.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
public class TodoResource {

    @Getter private final String id;
    @Getter private final String text;
    @Getter private final boolean isCompleted;

    public static TodoResource fromTodo(final Todo todo) {
        return TodoResource.builder()
                .id(todo.id)
                .text(todo.text)
                .isCompleted(todo.isCompleted)
                .build();
    }
}
