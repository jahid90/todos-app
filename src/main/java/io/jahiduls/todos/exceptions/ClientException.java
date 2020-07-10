package io.jahiduls.todos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ClientException extends RuntimeException {

    ClientException() {
        super();
    }

    ClientException(final String message) {
        super(message);
    }

    public static ClientException badRequest() {
        return new BadRequest();
    }

    public static ClientException badRequest(final String message) {
        return new BadRequest(message);
    }

    public static ClientException notFound() {
        return new NotFound();
    }

}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequest extends ClientException {

    BadRequest() {
        super();
    }

    BadRequest(final String message) {
        super(message);
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFound extends ClientException {}
