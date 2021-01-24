package com.kata.employee.employeeportalservice.cucumber.stepdefs.registration;

import com.kata.employee.employeeportalservice.cucumber.SpringIntegrationTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class EmployeeRegistrationStepDefs extends SpringIntegrationTest {

    @Given("the user register an employee with below attributes")
    public void the_user_register_an_employee_with_below_attributes(Map<String, String> employee) {

    }

    @When("the user makes request to register and employee in employee portal")
    public void the_user_makes_request_to_register_and_employee_in_employee_portal() {
    }

    @Then("the employee will be registered to employee portal")
    public void the_employee_will_be_registered_to_employee_portal() {
    }

    @Then("the user gets below response with status code {int}")
    public void the_user_gets_below_response_with_status_code(Integer int1, io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("the list of employees registered in employee portal")
    public void the_list_of_employees_registered_in_employee_portal(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("the user makes request to register in employee portal")
    public void the_user_makes_request_to_register_in_employee_portal() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the user get error response as {string} with status code {int}")
    public void the_user_get_error_response_as_with_status_code(String string, Integer int1) {

    }


    @Then("the user will get error messages as {string} with status code {int}")
    public void theUserWillGetErrorMessagesAsWithStatusCode(String arg0, int arg1) {
    }
}
