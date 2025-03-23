package com.credable.app.lms_service.client;

import com.credable.app.lms_service.model.ScoreResponse;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.credable.app.shared.exception.ExternalServiceException;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoringClient {

    private final WebClient webClient;;

    @Value("${scoring.api.url}")  // scoring service endpoint
    private String scoringApiUrl;

    /**
     * Initiates the Loan Scoring Process by sending a request to the Scoring Engine.
     *
     * @param customerNumber the customer number for which the scoring is to be initiated
     */
    public void initiateScoring(String customerNumber) {
        try {
            // Construct the URL for the scoring service endpoint
            String url = scoringApiUrl + "/scoring/initiateQueryScore/" + customerNumber;

            // Make a GET request to the scoring service

            webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(Map.class);

            // Log successful initiation of scoring
            log.info("Scoring initiated for customer number: {}", customerNumber);
        } catch (Exception e) {
            // Log and throw an exception in case of errors
            log.error("Error initiating scoring");
            throw new ExternalServiceException("Error initiating scoring: " + e.getMessage());
        }
    }

    /**
     * Get Scoring data from the Scoring Engine
     * @param token
     * @return
     */
    @Retry(name = "scoringService", fallbackMethod = "fallbackGetScoring")
    public ScoreResponse getScore(String token) {
        try {
            String url = scoringApiUrl + "/scoring/queryScore/" + token;

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            var response = webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(HashMap.class)
                    .block(); // Ensure blocking to get the response synchronously

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