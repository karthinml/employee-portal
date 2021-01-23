package com.kata.employee.employeeportalservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Employee {

    @NotBlank(message = "Employee ID field is mandatory")
    private String employeeId;
    @NotBlank(message = "First name field is mandatory")
    private String firstName;
    @NotBlank(message = "Last name field is mandatory")
    private String lastName;
    @NotBlank(message = "Department field is mandatory")
    private String gender;
    @NotBlank(message = "Date of birth field is mandatory")
    private Date dateOfBirth;
    @NotBlank(message = "Department field is mandatory")
    private String department;

}
