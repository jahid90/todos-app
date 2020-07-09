package io.jahiduls.todos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ClientException extends RuntimeException {

    public static ClientException badRequest() {
        return new BadRequest();
    }

    public static ClientException notFound() {
        return new NotFound();
    }
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequest extends ClientException {}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFound extends ClientException {}
