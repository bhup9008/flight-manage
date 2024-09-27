package com.codingworld.service1.flight.controller;

import com.codingworld.service1.book.modal.Book;
import com.codingworld.service1.comman.response.GenericResponse;
import com.codingworld.service1.flight.modal.Flight;
import com.codingworld.service1.flight.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    Logger logger= LoggerFactory.getLogger(FlightController.class);
    @Autowired
    private FlightService flightService;

    @GetMapping("/home")
    public String FlightController(){
        logger.info("FlightController test");
        return "FlightController service is working";
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse>  add(@RequestBody Flight flight) {
        logger.info("FlightController is execute {}",flight);
        Flight flight1= flightService.addFlight(flight);
       // return ResponseEntity.ok(GenericResponse.success(flight1));
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","",flight1),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getFlightById(@PathVariable Long id) {
        logger.info("FlightController is execute getFlightById",id);
        Flight flight=flightService.findById(id);
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",flight),HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<GenericResponse> getAllFlight() {
        logger.info("FlightController is execute getAllFlight");
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",flightService.getAllFlight()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        logger.info("FlightController is execute deleteFlight");
        flightService.deleteFlightById(id);
    }
}
