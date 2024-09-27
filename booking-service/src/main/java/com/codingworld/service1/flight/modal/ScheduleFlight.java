package com.codingworld.service1.flight.modal;

import com.codingworld.service1.comman.dto.User;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "scheduleflight")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleFlight {

    @Id
    @Column(name = "airport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "availableSeats")
    private Integer availableSeats;

    @OneToOne(targetEntity= Schedule.class,cascade=CascadeType.ALL)
    private Schedule schedule;

    @OneToOne(targetEntity=Flight.class,cascade=CascadeType.ALL)
    private Flight flight;







}
