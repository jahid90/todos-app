package io.jahiduls.todos.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findAllByIsCompleted(final boolean completed);
}
