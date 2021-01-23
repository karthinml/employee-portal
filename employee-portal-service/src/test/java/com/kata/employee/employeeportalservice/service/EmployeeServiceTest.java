package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

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

    @Test
    public void should_get_empty_list_when_requesting_employee_list_from_portal() throws ParseException {
        assertEquals(new ArrayList<>(), employeeService.getEmployees());
    }

    @Test
    public void should_be_able_to_get_list_of_employees_registered_in_employee_portal() throws ParseException {
        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(getSampleEmployeeData());
        when(employeeRepositoryMock.findAllByOrderByFirstNameAsc()).thenReturn(expected);
    }

}
