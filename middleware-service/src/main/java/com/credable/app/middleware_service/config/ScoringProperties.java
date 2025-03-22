package com.credable.app.middleware_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "scoring")
@Data
public class ScoringProperties {

    private String middlewareEndpoint;
    private String serviceName;
    private String basicAuthUsername;
    private String basicAuthPassword;


}