package com.codingworld.service1.flight.repository;

import com.codingworld.service1.flight.modal.ScheduleFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledFlightRepository extends JpaRepository<ScheduleFlight,Long> {
}
