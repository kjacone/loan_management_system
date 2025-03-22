package com.credable.app.lms_service.repository;

import com.credable.app.lms_service.entity.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends MongoRepository<LoanEntity, String> {
    List<LoanEntity> findByCustomerNumber(String customerNumber);

    Optional<LoanEntity> findByCustomerNumberAndId(String customerNumber, String id);

    List<LoanEntity> findByCustomerNumberAndStatus(String customerNumber, String status);

    boolean existsByCustomerNumberAndStatus(String customerNumber, String status);
}