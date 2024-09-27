package com.codingworld.service1.flight.service.impl;

import com.codingworld.service1.comman.exception.ResoureNotFoundException;
import com.codingworld.service1.flight.modal.AirPort;
import com.codingworld.service1.flight.repository.AirportRepository;
import com.codingworld.service1.flight.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirPortServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public AirPort addAirport(AirPort flight) {
        return airportRepository.save(flight);
    }

    @Override
    public List<AirPort> getAllAirport() {
        List<AirPort> flightList=airportRepository.findAll();
        return flightList;
    }

    @Override
    public AirPort findById(Long id) {
        AirPort flight=null;
        Optional<AirPort> flight1=airportRepository.findById(id);
        if(flight1.isPresent()){
            flight=flight1.get();
        }else {
            throw new ResoureNotFoundException("Flight id not available in database");
        }
        return flight;
    }

    @Override
    public void deleteAirportById(Long id) {

    }

}
