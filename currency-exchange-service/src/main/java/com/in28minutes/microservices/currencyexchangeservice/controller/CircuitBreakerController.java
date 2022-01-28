package com.in28minutes.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse") //breaks the circuit and directly returns back
//    @RateLimiter(name = "default") //in 10 sec => 10000 calls to sample api
    @Bulkhead(name = "sample-api") //
    public String sampleApi() {
        log.info("Sample API Call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost/some-dummy-url", String.class);

        return forEntity.getBody();
    }

    public String hardCodedResponse(Exception ex) {
        return "fallback-response";
    }
}
