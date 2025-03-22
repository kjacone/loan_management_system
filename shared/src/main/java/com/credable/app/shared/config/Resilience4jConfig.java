package com.credable.app.shared.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {

//    @Bean
//    public CircuitBreakerConfig customCircuitBreakerConfig() {
//        return CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .waitDurationInOpenState(Duration.ofSeconds(10))
//                .slidingWindowSize(100)
//                .build();
//    }
//
//    @Bean
//    public RetryConfig customRetryConfig() {
//        return RetryConfig.custom()
//                .maxAttempts(3)
//                .waitDuration(Duration.ofMillis(500))
//                .build();
//    }
}
