package io.jahiduls.todos.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Profile("prod")
@Configuration
public class MongoConfiguration {

    @Value("${db.host:mongo}")
    private String dbHost;

    @Value("${db.port:27017}")
    private String dbPort;

    @Value("${db.name:todos}")
    private String dbName;

    @Value("${db.user:todos}")
    private String dbUser;

    @Value("${db.password:secretpassword}")
    private String dbPassword;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
                new StringBuilder("mongodb://")
                        .append(dbUser)
                        .append(":")
                        .append(dbPassword)
                        .append("@")
                        .append(dbHost)
                        .append(":")
                        .append(dbPort)
                        .append("/")
                        .append(dbName)
                        .toString()
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), dbName);
    }
}
