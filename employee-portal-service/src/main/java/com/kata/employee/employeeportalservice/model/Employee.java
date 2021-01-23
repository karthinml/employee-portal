package com.kata.employee.employeeportalservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class Employee {

    @NotBlank(message = "Employee ID field is mandatory")
    private String employeeId;
    @NotBlank(message = "First name field is mandatory")
    private String firstName;
    @NotBlank(message = "Last name field is mandatory")
    private String lastName;
    @NotBlank(message = "Department field is mandatory")
    private String gender;
    @NotNull(message = "Date of birth field is mandatory")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date dateOfBirth;
    @NotBlank(message = "Department field is mandatory")
    private String department;

}
