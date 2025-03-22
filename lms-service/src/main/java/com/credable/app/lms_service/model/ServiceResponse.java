package com.credable.app.lms_service.model;

import com.credable.app.lms_service.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
    private String status;
    private String message;
    private T data;

}