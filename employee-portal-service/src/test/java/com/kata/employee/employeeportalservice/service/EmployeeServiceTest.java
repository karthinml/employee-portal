package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.DATE_FORMAT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);

    private final EmployeeService employeeService = new EmployeeService(employeeRepositoryMock);

    @Test
    public void should_be_able_to_add_employee_to_employee_portal() throws ParseException {
        Employee expectedData = getSampleEmployeeData();
        when(employeeRepositoryMock.save(any(Employee.class))).thenReturn(expectedData);
        Employee actualData = employeeService.registerEmployee(expectedData);
        assertEquals(expectedData, actualData);
    }
}
