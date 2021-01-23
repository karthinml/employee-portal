package com.kata.employee.employeeportalservice.exception;

public class EmployeeAlreadyRegisteredException extends RuntimeException {
    public EmployeeAlreadyRegisteredException() {
        super("Employee already registered");
    }
}
