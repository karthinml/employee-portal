package com.kata.employee.employeeportalservice.repository;

import com.kata.employee.employeeportalservice.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository.deleteAll();
    }

    @Test
    public void should_be_able_to_add_employee_to_portal() throws ParseException {
        assertEquals(employeeRepository.save(getSampleEmployeeData()), getSampleEmployeeData());
    }

    @Test
    public void should_get_empty_list_when_querying_for_employee_list() {
        assertEquals(employeeRepository.findAllByOrderByFirstNameAsc(), new ArrayList<>());
    }

    @Test
    public void should_get_employees_registered_in_portal_ascending_by_first_name() throws ParseException {
        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(getSampleEmployeeData());
        Employee employee = getSampleEmployeeData();
        employee.setEmployeeId("1002");
        employee.setFirstName("Arun");
        expected.add(employee);
        employeeRepository.saveAll(expected);
        assertEquals(employeeRepository.findAllByOrderByFirstNameAsc(),
                expected.stream().sorted(Comparator.comparing(Employee::getFirstName))
                        .collect(Collectors.toList()));
    }
}
