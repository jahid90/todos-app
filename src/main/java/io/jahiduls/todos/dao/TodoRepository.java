package io.jahiduls.todos.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TodoRepository extends MongoRepository<Todo, String> {

    @Query(value = "{}", fields = "{ _id: 1 }")
    List<Todo> findAllIds();

    @Query(value = "{'isCompleted': true}", fields = "{ _id: 1 }")
    List<Todo> findAllCompletedIds();

    @Query(value = "{'isCompleted': false}", fields = "{ _id: 1 }")
    List<Todo> findAllInCompleteIds();

}
