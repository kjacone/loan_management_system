package com.credable.app.middleware_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "service_credentials")
public class ScoringRegistrationResponse {
    @Id
    private String id;
    private String url;
    private String name;
    private String username;
    private String password;
    private String token;
    private ServiceType type;
}

