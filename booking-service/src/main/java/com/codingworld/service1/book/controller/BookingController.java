package com.codingworld.service1.book.controller;

import com.codingworld.service1.book.modal.Book;
import com.codingworld.service1.book.service.BookingService;
import com.codingworld.service1.comman.dto.User;
import com.codingworld.service1.comman.response.GenericResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {


    Logger logger= LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;


    @Autowired
    private RestTemplate restTemplate;

   // public static final String BOOKING_SERVICE="bookService";



    @GetMapping("/home")
    @CircuitBreaker(name ="book-service",fallbackMethod = "getCircuitBreakerStatus")
    public String bookingController(@RequestHeader("loggedInUser") String name){
        logger.info("BookingServiceImpl class {} ",name);
        return restTemplate.getForObject("http://FLIGHT-SERVICE/flight/home", String.class);
    }


    @PostMapping("/add")
    public ResponseEntity<GenericResponse> add(@RequestBody Book book) {
        logger.info("FlightController is execute {} and {}",book);
        Book book1=bookingService.addBooking(book);
        HttpStatus status=HttpStatus.CREATED;
        return new ResponseEntity<>(new GenericResponse(status,"Record created success","NOt",book1),status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getFlightById(@PathVariable Long id) {
        logger.info("FlightController is execute getFlightById",id);
        Book book1=bookingService.findById(id);
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",book1),HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<GenericResponse> getAllFlight() {
        logger.info("FlightController is execute getAllFlight");
        //return bookingService.getAllBooking();
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK,"Record created success","NOt",bookingService.getAllBooking()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        logger.info("FlightController is execute deleteFlight");
        bookingService.deleteBookingById(id);
    }

    public String getCircuitBreakerStatus(Exception e){
        return "This Service is down please contact with administrator";
    }
}
