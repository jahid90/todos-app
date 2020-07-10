package io.jahiduls.todos.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Profile("default")
@Configuration
public class DevMongoConfiguration {

    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "27017";
    private static final String DB_NAME = "todos";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin_password";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
                new StringBuilder("mongodb://")
                        .append(DB_USER)
                        .append(":")
                        .append(DB_PASSWORD)
                        .append("@")
                        .append(DB_HOST)
                        .append(":")
                        .append(DB_PORT)
                        .toString()
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), DB_NAME);
    }
}
