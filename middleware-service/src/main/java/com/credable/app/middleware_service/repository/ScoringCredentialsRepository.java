package com.credable.app.middleware_service.repository;



import com.credable.app.middleware_service.model.ScoringRegistrationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicReference;

@Repository
public interface ScoringCredentialsRepository extends MongoRepository<ScoringRegistrationResponse, String> {
    boolean existsByName(String name);

}