package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
