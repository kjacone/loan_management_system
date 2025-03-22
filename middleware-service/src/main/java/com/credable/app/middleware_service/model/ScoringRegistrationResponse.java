package com.credable.app.middleware_service.model;

import lombok.Data;

@Data
public class ScoringRegistrationResponse {
    private Long id;
    private String url;
    private String name;
    private String username;
    private String password;
    private String token;
}
