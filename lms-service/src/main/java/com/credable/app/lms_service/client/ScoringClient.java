package com.credable.app.lms_service.client;

import com.credable.app.shared.model.ScoreResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.credable.app.shared.exception.ExternalServiceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScoringClient {

    private final RestTemplate restTemplate;

    @Value("${scoring.api.url}")  // scoring service endpoint
    private String scoringApiUrl;

    /**
     * Initiate Loan Scoring Process sending request to Scoring Engine
     * @param customerNumber
     * @return
     */
//    @Retry(name = "scoringService", fallbackMethod = "fallbackInitiateScoring")
    public String initiateScoring(String customerNumber) {
        try {
            String url = scoringApiUrl + "/scoring/initiateQueryScore/" + customerNumber;

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("customerNumber", customerNumber);

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

            Map response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    Map.class).getBody();

            if (response == null || !response.containsKey("token")) {
                throw new ExternalServiceException("No token returned from Scoring service");
            }

            return  String.valueOf(response.get("token"));
        } catch (Exception e) {
            log.error("Error initiating scoring");
            throw new ExternalServiceException("Error initiating scoring: " + e.getMessage());
        }
    }

    /**
     * Get Scoring data from the Scoring Engine
     * @param token
     * @return
     */
//    @Retry(name = "scoringService", fallbackMethod = "fallbackGetScoring")
    public ScoreResponse getScore(String token) {
        try {
            String url = scoringApiUrl + "/scoring/queryScore/" + token;

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            Map response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Map.class).getBody();

            if (response == null || !response.containsKey("score") || !response.containsKey("loanLimit")) {
                throw new ExternalServiceException("Invalid score response from Scoring service");
            }

            return ScoreResponse.builder()
                    .score(((Number) response.get("score")).intValue())
                    .loanLimit(new BigDecimal(response.get("loanLimit").toString()))
                    .build();
        } catch (Exception e) {
            log.error("Error getting score");
            throw new ExternalServiceException("Error getting score: " + e.getMessage());
        }
    }


    /**
     * Fallback Funtion incase all retries fail
     * @param token
     * @param e
     * @return
     */
    private ScoreResponse fallbackGetScoring(String token, Exception e) {
        log.error("Fallback method called for getting score");
        throw new ExternalServiceException(
                "Scoring service is unavailable after retries for getting score: " + e.getMessage());
    }
}