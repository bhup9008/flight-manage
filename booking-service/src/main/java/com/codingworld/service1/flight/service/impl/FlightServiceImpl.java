package com.codingworld.service1.flight.service.impl;

import com.codingworld.service1.comman.exception.ResoureNotFoundException;
import com.codingworld.service1.flight.modal.Flight;
import com.codingworld.service1.flight.repository.FlightRepository;
import com.codingworld.service1.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlight() {
        List<Flight> flightList=flightRepository.findAll();
        return flightList;
    }

    @Override
    public Flight findById(Long id) {
        Flight flight=null;
        Optional<Flight> flight1=flightRepository.findById(id);
        if(flight1.isPresent()){
            flight=flight1.get();
        }else {
            throw new ResoureNotFoundException("Flight id not available in database");
        }
        return flight;
    }

    @Override
    public void deleteFlightById(Long id) {

    }
}
