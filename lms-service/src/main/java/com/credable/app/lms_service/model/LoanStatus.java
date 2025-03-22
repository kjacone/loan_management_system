package com.credable.app.lms_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public enum LoanStatus {
 ONGOING, APPROVED, REJECTED
}