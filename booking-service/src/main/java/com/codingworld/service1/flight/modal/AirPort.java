package com.codingworld.service1.flight.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "airport")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirPort {

    @Id
    @Column(name = "airport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airportName")
    private String airportName;
    @Column(name = "airportLocation")
    private String airportLocation;
    @Column(name = "airportCode")
    private String airportCode;
}
