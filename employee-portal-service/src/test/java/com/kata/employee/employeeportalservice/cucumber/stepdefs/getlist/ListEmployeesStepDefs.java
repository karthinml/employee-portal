package com.kata.employee.employeeportalservice.cucumber.stepdefs.getlist;

import com.kata.employee.employeeportalservice.cucumber.SpringIntegrationTest;
import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.stream.Collectors;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.transformDataTableToEmployeeList;
import static org.junit.Assert.assertEquals;

public class ListEmployeesStepDefs extends SpringIntegrationTest {

    private ResponseEntity<List<Employee>> actualResponse;
    private List<Employee> expectedData;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository.deleteAll();
    }

    @When("the user make request to get employees registered in portal")
    public void the_user_make_request_to_get_employees_registered_in_portal() {
        actualResponse = restTemplate.exchange(EMPLOYEE_SERVICE_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
    }

    @Then("the service will response with status code {int}")
    public void the_service_will_response_with_status_code(int statusCode) {
        assertEquals(statusCode, actualResponse.getStatusCodeValue());
    }

    @Then("the user will get empty list")
    public void the_user_will_get_empty_list() {
        assertEquals(0, Objects.requireNonNull(actualResponse.getBody()).size());
    }

    @Given("users registered in employee portal")
    public void users_registered_in_employee_portal(List<Map<String, String>> expectedEmployeeList) {
        List<Employee> employees = transformDataTableToEmployeeList(expectedEmployeeList);
        employeeRepository.saveAll(employees);
        expectedData = employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    }

    @Then("the user will get the below list of employees with the same order")
    public void the_user_will_get_the_below_list_of_employees_with_the_same_order(io.cucumber.datatable.DataTable dataTable) {
        List<Employee> actualData = actualResponse.getBody();
        assertEquals(expectedData, actualData);
    }

}
