package com.credable.app.shared.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiSuccess {
    private HttpStatus status;
    private String message;
    private Object data;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}