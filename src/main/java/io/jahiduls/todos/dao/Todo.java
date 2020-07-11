package io.jahiduls.todos.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id public String id;
    public String text;
    public boolean isCompleted;
}
