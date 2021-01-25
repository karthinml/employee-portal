package com.kata.employee.employeeportalservice.controller;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.EMPLOYEE_ALREADY_REGISTERED_MESSAGE;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register employee to employee portal", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee registered successfully"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 409, message = EMPLOYEE_ALREADY_REGISTERED_MESSAGE)
    })
    public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(
                employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get list of employees from employee portal",
            response = Employee.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of employees from employee portal")
    })
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
}
