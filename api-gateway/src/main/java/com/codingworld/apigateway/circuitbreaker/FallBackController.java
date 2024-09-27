package com.codingworld.apigateway.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.config.GatewayResilience4JCircuitBreakerAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
    Logger logger= LoggerFactory.getLogger(FallBackController.class);
   // GatewayResilience4JCircuitBreakerAutoConfiguration this class is enable auto configure

    private int count =0;
    @GetMapping("/book-service")
    public String userServiceFallBack() {
        count =count+1;
        logger.info("count value in FallBackController service {} ",count);
        return "User Service is not available right now. Try again later! "+count;
    }
}