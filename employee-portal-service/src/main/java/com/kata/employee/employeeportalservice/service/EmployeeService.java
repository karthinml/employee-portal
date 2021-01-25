package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.exception.EmployeeAlreadyRegisteredException;
import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.log;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {
        log("Adding employee:: employee id: {}", employee.getEmployeeId());
        if (employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            throw new EmployeeAlreadyRegisteredException();
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAllByOrderByFirstNameAsc();
        log("Sending {} employee details", employees.size());
        return employees;
    }
}
