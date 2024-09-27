package com.codingworld.service1.flight.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController {

    Logger logger= LoggerFactory.getLogger(FlightController.class);

    @Value("${server.port}")
    private int port;


    @GetMapping("/home")
    public String FlightController(){
        logger.info("FlightController test");
        logger.info("FlightController with  is successfull & service port {}", port);
        return "FlightController service is working on port no "+port;
    }

    @GetMapping("/testc")
    @CircuitBreaker(name ="book-service",fallbackMethod = "getAllAvailableProducts")
    public String checkCircuit(){
        return "cjbdjsc";
    }


}
