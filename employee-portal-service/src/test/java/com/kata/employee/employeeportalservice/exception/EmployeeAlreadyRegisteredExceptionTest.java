package com.kata.employee.employeeportalservice.exception;

import com.kata.employee.employeeportalservice.controller.EmployeeController;
import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeAlreadyRegisteredExceptionTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test(expected = EmployeeAlreadyRegisteredException.class)
    public void should_throw_employee_already_exists_exception() throws ParseException {
        when(employeeService.registerEmployee(any(Employee.class))).thenThrow(new EmployeeAlreadyRegisteredException());
        employeeController.registerEmployee(getSampleEmployeeData());
    }
}
