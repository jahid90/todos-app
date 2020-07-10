package io.jahiduls.todos.dao;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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

    public void saveTodo(final Todo todo) {
        repository.save(todo);
    }

    public void deleteTodoById(final String id) {
        repository.deleteById(id);
    }

}
