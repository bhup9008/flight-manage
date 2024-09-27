package com.codingworld.service1.flight.controller;

import com.codingworld.service1.flight.modal.ScheduleFlight;
import com.codingworld.service1.flight.service.ScheduledFlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scheduledFlight")
public class ScheduledFlightController {

    Logger logger= LoggerFactory.getLogger(ScheduledFlightController.class);
    @Autowired
    private ScheduledFlightService scheduledFlightService;

    @GetMapping("/home")
    public String ScheduledFlightController(){
        logger.info("ScheduledFlightController test");
        return "ScheduledFlightController service is working";
    }

    @PostMapping("/add")
    public ScheduleFlight add(@RequestBody ScheduleFlight scheduleFlight) {
        logger.info("ScheduledFlightController is execute {}",scheduleFlight);
        return scheduledFlightService.addScheduleFlight(scheduleFlight);
    }

    @GetMapping("/{id}")
    public ScheduleFlight getFlightById(@PathVariable Long id) {
        logger.info("ScheduledFlightController is execute getFlightById",id);
        return scheduledFlightService.findById(id);
    }


    @GetMapping("/all")
    public List<ScheduleFlight> getAllFlight() {
        logger.info("ScheduledFlightController is execute getAllFlight");
        return scheduledFlightService.getAllScheduleFlight();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        logger.info("ScheduledFlightController is execute deleteFlight");
        scheduledFlightService.deleteScheduleFlightById(id);
    }
}
