package com.codingworld.service1.flight.modal;

import com.codingworld.service1.comman.dto.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "schedule")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destinationAirport")
    private String destinationAirport;
    @Column(name = "arrivalTime")
    private String arrivalTime;
    @Column(name = "departureTime")
    private String departureTime;

    @OneToOne(targetEntity= AirPort.class,cascade=CascadeType.ALL)
    private AirPort airPort;





}
