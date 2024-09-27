package com.codingworld.service1.book.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "passenger")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @Column(name = "passenger_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "passengerName")
    private String passengerName;
    @Column(name = "passengerAge")
    private String passengerAge;
    @Column(name = "passengerUIN")
    private Integer passengerUIN;
    @Column(name = "luggage")
    private Double luggage;
}
