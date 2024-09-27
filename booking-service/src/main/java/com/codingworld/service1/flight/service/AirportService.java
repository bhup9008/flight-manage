package com.codingworld.service1.flight.service;

import com.codingworld.service1.flight.modal.AirPort;

import java.util.List;

public interface AirportService {
    AirPort addAirport(AirPort airPort);
    List<AirPort> getAllAirport();
    AirPort findById(Long id);
    void deleteAirportById(Long id);
}
