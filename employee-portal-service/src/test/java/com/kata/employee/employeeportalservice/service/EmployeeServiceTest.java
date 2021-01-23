package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import org.junit.Test;

import java.text.ParseException;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private final EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
    private final EmployeeService employeeService = new EmployeeService(employeeRepositoryMock);

    @Test
    public void should_be_able_to_add_employee_to_employee_portal() throws ParseException {
        when(employeeRepositoryMock.save(any(Employee.class))).thenReturn(getSampleEmployeeData());
        assertEquals(getSampleEmployeeData(), employeeService.registerEmployee(getSampleEmployeeData()));
    }
}
