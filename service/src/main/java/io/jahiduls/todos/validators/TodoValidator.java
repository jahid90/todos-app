package io.jahiduls.todos.validators;

import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.resources.TodoResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
public class TodoValidator implements Validator<TodoResource> {

    @Override
    public void validate(final TodoResource resource) {
        try {

            Assert.hasLength(resource.getId(), "ID can't be empty");
            Assert.hasLength(resource.getText(), "Text can't be empty");

        } catch (final IllegalArgumentException ex) {

            log.warn("ClientError", ex);
            throw ClientException.badRequest(ex.getMessage());

        }
    }

}
