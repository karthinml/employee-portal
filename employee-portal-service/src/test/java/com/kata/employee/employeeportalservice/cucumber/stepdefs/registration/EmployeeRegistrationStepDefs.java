package com.kata.employee.employeeportalservice.cucumber.stepdefs.registration;

import com.kata.employee.employeeportalservice.cucumber.SpringIntegrationTest;
import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.repository.EmployeeRepository;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.*;

import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.transformDataTableToEmployeeList;
import static org.junit.Assert.assertEquals;

public class EmployeeRegistrationStepDefs extends SpringIntegrationTest {

    private ResponseEntity<Employee> actualResponse;
    private Employee expectedData;
    private ResponseEntity<String> actualErrorResponse;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository.deleteAll();
    }

    @Given("the user register an employee with below attributes")
    public void the_user_register_an_employee_with_below_attributes(List<Map<String, String>> employee) {
        expectedData = transformDataTableToEmployeeList(employee).get(0);
    }

    @When("the user makes request to register and employee in employee portal")
    public void the_user_makes_request_to_register_an_employee_in_employee_portal() {
        try {
            actualResponse = restTemplate.exchange(EMPLOYEE_SERVICE_URL, HttpMethod.POST, new HttpEntity<>(expectedData), Employee.class);
        } catch (HttpStatusCodeException e) {
            handleError(e);
        }
    }

    @Then("the employee will be registered to employee portal")
    public void the_employee_will_be_registered_to_employee_portal() {
        assertEquals(expectedData.getEmployeeId(), Objects.requireNonNull(actualResponse.getBody()).getEmployeeId());
    }

    @Then("the user gets below response with status code {int}")
    public void the_user_gets_below_response_with_status_code(int statusCode, io.cucumber.datatable.DataTable dataTable) {
        assertEquals(statusCode, actualResponse.getStatusCodeValue());
        assertEquals(expectedData, actualResponse.getBody());
    }

    @Given("the list of employees registered in employee portal")
    public void the_list_of_employees_registered_in_employee_portal(List<Map<String, String>> employeeData) {
        employeeRepository.saveAll(transformDataTableToEmployeeList(employeeData));
    }

    @Then("the user get error response as {string} with status code {int}")
    public void the_user_get_error_response_as_with_status_code(String errorMessage, int responseCode) {
        assertEquals(errorMessage, actualErrorResponse.getBody());
        assertEquals(responseCode, actualErrorResponse.getStatusCodeValue());
    }


    @Then("the user will get error messages as {string} with status code {int}")
    public void theUserWillGetErrorMessagesAsWithStatusCode(String errorMessages, int responseCode) throws JSONException {
        JSONObject jsonObject = new JSONObject(actualErrorResponse.getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("error");
        List<String> actualErrorMessages = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            actualErrorMessages.add((String) jsonArray.get(i));
        }
        assertEquals(responseCode, actualErrorResponse.getStatusCodeValue());
        List<String> expectedErrors = Arrays.asList(errorMessages.split(","));
        assert (expectedErrors.containsAll(actualErrorMessages));
    }

    private void handleError(HttpStatusCodeException e) {
        actualErrorResponse = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                .body(e.getResponseBodyAsString());
    }

}
