package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.model.Employee;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.DATE_FORMAT;

public class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    public void should_be_able_to_add_employee_to_employee_portal() throws ParseException {
        Employee expectedData = Employee.builder().employeeId("1001").firstName("Karthik")
                .lastName("Ramasamy").gender("Male").dateOfBirth(new SimpleDateFormat(DATE_FORMAT).parse("08-16-1989"))
                .department("J1G").build();
        Employee actualData = employeeService.registerEmployee(expectedData);
        assertEquals(expectedData, actualData);
    }
}
