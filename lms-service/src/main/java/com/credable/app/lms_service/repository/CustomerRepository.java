package com.credable.app.lms_service.repository;

import com.credable.app.lms_service.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByCustomerNumber(String customerNumber);

    boolean existsByCustomerNumber(String customerNumber);
}