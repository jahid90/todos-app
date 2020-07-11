package io.jahiduls.todos.services;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    @Cacheable("todo")
    public Optional<Todo> getOneById(final String id) {

        final Optional<Todo> maybeTodo = repository.findById(id);

        log.info("Retrieved: {}", maybeTodo);

        return maybeTodo;
    }

    @Cacheable(value = "todos", key = "'all'")
    public List<String> getAllIds() {

        final List<Todo> retrievedTodos = repository.findAllIds();
        final List<String> todoIds = retrievedTodos.stream().map(it -> it.id).collect(Collectors.toList());

        log.info("Retrieved: {}", todoIds);

        return todoIds;
    }

    @Cacheable(value = "todos", key = "'completed'")
    public List<String> getAllCompletedIds() {

        final List<Todo> retrievedTodos = repository.findAllCompletedIds();
        final List<String> todoIds = retrievedTodos.stream().map(it -> it.id).collect(Collectors.toList());

        log.info("Retrieved: {}", todoIds);

        return todoIds;
    }

    @Cacheable(value = "todos", key = "'incomplete'")
    public List<String> getAllInCompleteIds() {

        final List<Todo> retrievedTodos = repository.findAllInCompleteIds();
        final List<String> todoIds = retrievedTodos.stream().map(it -> it.id).collect(Collectors.toList());

        log.info("Retrieved: {}", todoIds);

        return todoIds;
    }

    /* Any save potentially alters the individual entry, so it should be invalidated.
     * Create alters the set of all entries, so the id set should be recalculated.
     */
    @Caching(evict = {
            @CacheEvict(value = "todo", key = "#todo.id"),
            @CacheEvict(value = "todos", allEntries = true)
    })
    public void saveTodo(final Todo todo) {
        repository.save(todo);
    }

    /* After delete, the entry does not exist, so it should be invalidated.
     * Delete also alters the set of all entries, so the id set should be recalculated.
     */
    @Caching(evict = {
            @CacheEvict("todo"),
            @CacheEvict(value = "todos", allEntries = true)
    })
    public void deleteTodoById(final String id) {
        repository.deleteById(id);
    }

}
