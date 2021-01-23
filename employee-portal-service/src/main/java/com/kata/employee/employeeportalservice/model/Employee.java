package com.kata.employee.employeeportalservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @NotBlank(message = EMPLOYEE_ID_FIELD_MANDATORY_MESSAGE)
    @Id
    private String employeeId;
    @NotBlank(message = FIRST_NAME_FIELD_MANDATORY_MESSAGE)
    private String firstName;
    @NotBlank(message = LAST_NAME_FIELD_MANDATORY_MESSAGE)
    private String lastName;
    @NotBlank(message = GENDER_FIELD_MANDATORY_MESSAGE)
    private String gender;
    @NotNull(message = DATE_OF_BIRTH_FIELD_MANDATORY_MESSAGE)
    @DateTimeFormat(pattern = DATE_FORMAT)
    private Date dateOfBirth;
    @NotBlank(message = DEPARTMENT_FIELD_MANDATORY_MESSAGE)
    private String department;

}
