package com.credable.app.middleware_service.config;
import com.credable.app.middleware_service.model.ScoringRegistrationResponse;
import com.credable.app.middleware_service.repository.ScoringCredentialsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class ScoringRegistrationConfig {

    @Value("${scoring.middleware-endpoint}")  // wsdl endpoint for transactions
    private String scoringUrl;

    private final ScoringProperties scoringProperties;
    private final ScoringCredentialsRepository scoringCredentialsRepository;

    public ScoringRegistrationConfig(ScoringProperties scoringProperties,
                                     ScoringCredentialsRepository scoringCredentialsRepository) {
        this.scoringProperties = scoringProperties;
        this.scoringCredentialsRepository = scoringCredentialsRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void registerWithScoringEngine() {
        // Check if already registered
        if (scoringCredentialsRepository.isRegistered()) {
            log.info("Middleware service already registered with scoring engine");
            return;
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> registrationRequest = new HashMap<>();
        registrationRequest.put("url", scoringProperties.getMiddlewareEndpoint());
        registrationRequest.put("name", scoringProperties.getServiceName());
        registrationRequest.put("username", scoringProperties.getBasicAuthUsername());
        registrationRequest.put("password", scoringProperties.getBasicAuthPassword());

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(registrationRequest, headers);

        try {
            ScoringRegistrationResponse response = restTemplate.postForObject(
                    scoringUrl,
                    requestEntity,
                    ScoringRegistrationResponse.class
            );

            if (response != null) {
                // Save credentials for future use
                scoringCredentialsRepository.saveCredentials(response);
                log.info("Successfully registered middleware service with scoring engine. Client ID: {}", response.getId());
            }
        } catch (Exception e) {
            log.error("Failed to register with scoring engine: {}", e.getMessage(), e);
            // Consider whether to fail startup or continue with degraded functionality
        }
    }
}