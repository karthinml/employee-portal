package com.kata.employee.employeeportalservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeePortalServiceExceptionHandler {

    @ExceptionHandler({EmployeeAlreadyRegisteredException.class})
    public ResponseEntity<String> handleEmployeeAlreadyRegisteredException(EmployeeAlreadyRegisteredException e) {
        return ResponseEntity.status(409).body(e.getMessage());
    }

}
