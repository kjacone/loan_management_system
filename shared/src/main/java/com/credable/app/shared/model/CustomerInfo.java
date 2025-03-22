package com.credable.app.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo {
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private boolean kycVerified;
}