package com.credable.app.lms_service.entity;

import com.credable.app.lms_service.model.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "loan_requests")
public class LoanEntity {
    @Id
    private String id;
    private String customerNumber;
    private BigDecimal loanAmount;
    private LoanStatus status; // ONGOING, APPROVED, REJECTED
    private Integer score;
    private BigDecimal loanLimit;
    private LocalDateTime requestDate;
    private LocalDateTime statusUpdateDate;
}
