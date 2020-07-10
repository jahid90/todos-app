package io.jahiduls.todos.services;

import io.jahiduls.todos.dao.Todo;
import io.jahiduls.todos.dao.TodoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    @Cacheable(value = "todo")
    public Optional<Todo> getOneById(final String id) {
        return repository.findById(id);
    }

    @Cacheable(value = "todos")
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @Cacheable(value = "todos")
    public List<Todo> getAllByCompleted(final boolean completed) {
        return repository.findAllByIsCompleted(completed);
    }

    @Caching(evict = {
            @CacheEvict(value = "todo", key = "#todo.id"),
            @CacheEvict(value = "todos", allEntries = true)
    })
    public void saveTodo(final Todo todo) {
        repository.save(todo);
    }

    @Caching(evict = {
            @CacheEvict("todo"),
            @CacheEvict(value = "todos", allEntries = true)
    })
    public void deleteTodoById(final String id) {
        repository.deleteById(id);
    }

}
