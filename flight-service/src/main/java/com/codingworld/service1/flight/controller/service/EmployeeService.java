package com.codingworld.service1.flight.controller.service;


import com.codingworld.service1.flight.controller.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Double getAverageSalaryByDepartment(String department);
}
