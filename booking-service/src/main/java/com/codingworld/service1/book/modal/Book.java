package com.codingworld.service1.book.modal;

import com.codingworld.service1.comman.dto.User;
import com.codingworld.service1.flight.modal.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "booking")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bookingDate")
    private String bookingDate;
    @Column(name = "flightMode")
    private String flightMode;
    @Column(name = "seatCapacity")
    private Integer seatCapacity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="passenger_id")
    private List<Passenger> passengerList;

    //@OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Long user_id;

    @OneToOne(targetEntity=Flight.class,cascade=CascadeType.ALL)
    private Flight flight;

    @Column(name = "noOfPassengers")
    private Integer noOfPassengers;

    @Column(name = "ticketCost")
    private Double ticketCost;






}
