package io.jahiduls.todos.resources;

import io.jahiduls.todos.dao.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoResource {

    @Getter private String id;
    @Getter private String text;
    @Getter @Setter private boolean completed;

    public static TodoResource fromTodo(final Todo todo) {
        return new TodoResource(todo.id, todo.text, todo.isCompleted);
    }

    public Todo toTodo() {
        return new Todo(this.id, this.text, this.completed);
    }
}
