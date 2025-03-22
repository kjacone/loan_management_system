package com.credable.app.shared.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    @NotBlank(message = "Customer number is required")
    private String customerNumber;

    @NotNull(message = "Loan amount is required")
    @Min(value = 1, message = "Loan amount must be greater than 0")
    private BigDecimal loanAmount;

    @NotNull(message = "Loan term is required")
    @Min(value = 1, message = "Loan term must be greater than 0")
    private Integer loanTermMonths;
    private String purpose;
}