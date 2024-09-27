package com.codingworld.service1.flight.repository;

import com.codingworld.service1.flight.modal.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
