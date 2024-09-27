package com.codingworld.service1.flight.service;

import com.codingworld.service1.flight.modal.ScheduleFlight;

import java.util.List;

public interface ScheduledFlightService {
    ScheduleFlight addScheduleFlight(ScheduleFlight flight);
    List<ScheduleFlight> getAllScheduleFlight();
    ScheduleFlight findById(Long id);
    void deleteScheduleFlightById(Long id);

}
