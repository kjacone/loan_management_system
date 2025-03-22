package com.credable.app.lms_service.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;
    private boolean kycVerified;
    private int tries;
    private LocalDateTime registrationDate;
    private LocalDateTime lastUpdated;
}