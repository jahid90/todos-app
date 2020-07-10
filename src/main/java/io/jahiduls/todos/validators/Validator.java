package io.jahiduls.todos.validators;

public interface Validator<T> {

    void validate(final T t);
}
