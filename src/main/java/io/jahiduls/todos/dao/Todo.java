package io.jahiduls.todos.dao;


import io.jahiduls.todos.resources.TodoResource;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@NoArgsConstructor
public class Todo {

    @Id
    public String id;

    public String text;
    public boolean isCompleted;

    public Todo(final String text) {
        this.text = text;
        this.isCompleted = false;
    }

    public Todo(String text, boolean isCompleted) {
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public static Todo fromResource(final TodoResource resource) {
        return new Todo(resource.getText());
    }
}
