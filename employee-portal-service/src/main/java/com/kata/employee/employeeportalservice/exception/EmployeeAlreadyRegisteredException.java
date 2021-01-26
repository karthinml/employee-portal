package com.kata.employee.employeeportalservice.exception;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.EMPLOYEE_ALREADY_REGISTERED_MESSAGE;

public class EmployeeAlreadyRegisteredException extends RuntimeException {
    public EmployeeAlreadyRegisteredException() {
        super(EMPLOYEE_ALREADY_REGISTERED_MESSAGE);
    }
}
