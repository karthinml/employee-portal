package com.kata.employee.employeeportalservice.controller;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(
                employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
}
