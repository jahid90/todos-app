package io.jahiduls.todos.controller;

import io.jahiduls.todos.exceptions.ClientException;
import io.jahiduls.todos.exceptions.ServiceException;
import io.jahiduls.todos.processors.CommandProcessor;
import io.jahiduls.todos.resources.TodoResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TodosCommandController {

    @Autowired
    private CommandProcessor processor;

    @PostMapping("/todos")
    public ResponseEntity<String> add(@RequestBody final TodoResource resource) {
        try {
            log.info("Got an add request for: {}", resource);

            processor.process(processor.addCommandBuilder().resource(resource).build());

            log.info("Entity successfully added.");

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (final ClientException e) {

            log.warn("Client error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (final ServiceException e) {

            log.error("Server error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/todo/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable final String id, @RequestBody final TodoResource resource) {
        try {

            log.info("Got an edit request for: {}. Payload : {}", id, resource);

            // Ensure that the ids in the url and the request body match
            if (!id.equals(resource.getId())) {
                log.warn("Ids in url and request body do not match.");

                return new ResponseEntity<>("Ids in url and request body do not match", HttpStatus.BAD_REQUEST);
            }

            processor.process(processor.editCommandBuilder().resource(resource).build());

            log.info("Entity with id: {} successfully updated.", id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final ClientException e) {

            log.warn("Client error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (final ServiceException e) {

            log.error("Server error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable final String id) {
        try {
            log.info("Got a delete request for: {}", id);

            processor.process(processor.deleteCommandBuilder().id(id).build());

            log.info("Entity with id: {} successfully deleted.", id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final ClientException e) {

            log.warn("Client error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (final ServiceException e) {

            log.error("Server error.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
