package com.codingworld.service1.flight.controller;

import com.codingworld.service1.comman.response.GenericResponse;
import com.codingworld.service1.flight.modal.AirPort;
import com.codingworld.service1.flight.modal.Flight;
import com.codingworld.service1.flight.service.AirportService;
import com.codingworld.service1.flight.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airport")
public class AirPortController {

    Logger logger= LoggerFactory.getLogger(AirPortController.class);
    @Autowired
    private AirportService airportService;

    @GetMapping("/home")
    public String FlightController(){
        logger.info("AirPortController test");
        return "AirPortController service is working";
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse>  add(@RequestBody AirPort airPort) {
        logger.info("AirPortController is execute {}",airPort);
        AirPort flight1= airportService.addAirport(airPort);
       // return ResponseEntity.ok(GenericResponse.success(flight1));
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","",flight1),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getAirportById(@PathVariable Long id) {
        logger.info("AirPortController is execute getAirportById",id);
        AirPort flight=airportService.findById(id);
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",flight),HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<GenericResponse> getAllFlight() {
        logger.info("AirPortController is execute getAllFlight");
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",airportService.getAllAirport()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        logger.info("AirPortController is execute deleteFlight");
        airportService.deleteAirportById(id);
    }
}
