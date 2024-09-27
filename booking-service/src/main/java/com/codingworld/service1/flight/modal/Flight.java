package com.codingworld.service1.flight.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table(name = "flight")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "carrierName")
    private String carrierName;
    @Column(name = "flightMode")
    private String flightMode;
    @Column(name = "seatCapacity")
    private Integer seatCapacity;


}
