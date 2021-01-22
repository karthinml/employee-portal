package com.kata.employee.employeeportalservice.controller;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> registerEmployee(@RequestBody() Employee employee) {
        return new ResponseEntity<>(
                employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }

}
