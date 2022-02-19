package io.jahiduls.todos.processors;

import io.jahiduls.todos.commands.Command;
import io.jahiduls.todos.commands.CommandFactory;
import io.jahiduls.todos.services.TodoService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class TodoCommandProcessor implements CommandProcessor {

    private final CommandFactory factory;

    private final ExecutorService executorService;
    private final TodoService service;

    @PostConstruct
    public void initialize() {

        log.info("Registering shutdown hook for processor executor.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            log.info("Shutting down the executor");

            executorService.shutdown();

            try {
                if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (final InterruptedException ex) {
                executorService.shutdownNow();
            }

        }));

        // Warm-up caches to improve first response time
        log.info("Warming up caches.");
        process(factory.indexAllIdsCommand());
        process(factory.indexEachCommand());
    }

    @Override
    public void process(final Command command) {

        log.info("Submitting [{}] for execution", command.getClass().getSimpleName());

        executorService.submit(() -> command.execute(service));

    }

}
