package com.credable.app.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanStatus {
    private String loanId;
    private String customerNumber;
    private String status;
    private BigDecimal loanAmount;
    private BigDecimal loanLimit;
    private Integer loanScore;
    private LocalDateTime applicationDate;
    private LocalDateTime lastUpdated;
}