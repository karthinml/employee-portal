package com.kata.employee.employeeportalservice.controller;

import com.kata.employee.employeeportalservice.model.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeControllerTest {

    @Test
    public void should_be_able_to_register_employee_in_employee_portal() {
        Employee actual = null;
        EmployeeController employeeController = new EmployeeController();
        Employee expected = employeeController.registerEmployee(actual);
        assertEquals(actual, expected);
    }
}
