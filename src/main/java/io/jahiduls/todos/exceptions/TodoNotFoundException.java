package io.jahiduls.todos.exceptions;

public class TodoNotFoundException extends ClientException {
    public TodoNotFoundException(String message) {
        super(message);
    }

    public TodoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
