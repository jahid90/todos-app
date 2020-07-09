package io.jahiduls.todos.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id public String id;
    public String text;
    public boolean isCompleted;
}
