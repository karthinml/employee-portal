package com.kata.employee.employeeportalservice.helper;

import com.kata.employee.employeeportalservice.model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.DATE_FORMAT;

public class EmployeePortalServiceTestHelper {

    public static Employee getSampleEmployeeData() throws ParseException {
        return Employee.builder().employeeId("1001").firstName("Karthik")
                .lastName("Ramasamy").gender("Male").dateOfBirth(new SimpleDateFormat(DATE_FORMAT).parse("08-16-1989"))
                .department("J1G").build();
    }
}
