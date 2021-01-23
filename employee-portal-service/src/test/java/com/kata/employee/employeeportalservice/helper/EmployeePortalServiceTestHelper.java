package com.kata.employee.employeeportalservice.helper;

import com.kata.employee.employeeportalservice.model.Employee;

public class EmployeePortalServiceTestHelper {

    public static Employee getSampleEmployeeData() {
        return Employee.builder().employeeId("1001").firstName("Karthik")
                .lastName("Ramasamy").gender("Male").build();
    }
}
