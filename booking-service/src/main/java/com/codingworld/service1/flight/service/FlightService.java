package com.codingworld.service1.flight.service;

import com.codingworld.service1.flight.modal.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlight();
    Flight findById(Long id);
    void deleteFlightById(Long id);
}
