package io.jahiduls.todos.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findAllByIsCompleted(final boolean completed);
}
