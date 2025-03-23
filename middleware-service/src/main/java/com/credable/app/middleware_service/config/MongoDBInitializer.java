package com.credable.app.middleware_service.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBInitializer {

    @Bean
    CommandLineRunner initMongoCollections(MongoTemplate mongoTemplate) {
        return args -> {
            if (!mongoTemplate.collectionExists("service_credentials")) {
                mongoTemplate.createCollection("service_credentials");
                System.out.println("Created 'service_credentials' collection.");
            }
        };
    }
}

