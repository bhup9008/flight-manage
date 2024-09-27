package com.codingworld.service1.flight.controller.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {


    @Id


    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String department;

    private double salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
