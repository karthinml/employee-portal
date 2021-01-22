package com.kata.employee.employeeportalservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String department;

}
