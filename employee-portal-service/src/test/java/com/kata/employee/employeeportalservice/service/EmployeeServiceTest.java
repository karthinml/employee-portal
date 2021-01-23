package com.kata.employee.employeeportalservice.service;

import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import org.junit.Test;
import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class EmployeeServiceTest {

    private final EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
    private final EmployeeService employeeService = new EmployeeService(employeeRepositoryMock);

    @Test
    public void should_be_able_to_add_employee_to_employee_portal() {
        assertEquals(getSampleEmployeeData(), employeeService.registerEmployee(getSampleEmployeeData()));
    }
}
