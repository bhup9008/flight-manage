package com.codingworld.service1.flight.service.impl;

import com.codingworld.service1.flight.modal.ScheduleFlight;
import com.codingworld.service1.flight.repository.ScheduledFlightRepository;
import com.codingworld.service1.flight.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {


    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    @Override
    public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) {
        return scheduledFlightRepository.save(scheduleFlight);
    }

    @Override
    public List<ScheduleFlight> getAllScheduleFlight() {
        return List.of();
    }

    @Override
    public ScheduleFlight findById(Long id) {
        return null;
    }

    @Override
    public void deleteScheduleFlightById(Long id) {

    }
}
