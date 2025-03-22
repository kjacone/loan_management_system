package com.credable.app.middleware_service.repository;



import com.credable.app.middleware_service.model.ScoringRegistrationResponse;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicReference;

@Repository
public class ScoringCredentialsRepository {

    private final AtomicReference<ScoringRegistrationResponse> credentials = new AtomicReference<>();

    public boolean isRegistered() {
        return credentials.get() != null;
    }

    public void saveCredentials(ScoringRegistrationResponse response) {
        credentials.set(response);
    }

    public String getToken() {
        ScoringRegistrationResponse response = credentials.get();
        return response != null ? response.getToken() : null;
    }
}