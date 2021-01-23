package com.kata.employee.employeeportalservice.repository;

import com.kata.employee.employeeportalservice.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void should_be_able_to_add_employee_to_portal() throws ParseException {
        assertEquals(employeeRepository.save(getSampleEmployeeData()), getSampleEmployeeData());
    }
}
