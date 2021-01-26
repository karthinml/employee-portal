package com.kata.employee.employeeportalservice.cucumber.stepdefs.getlist;

import com.kata.employee.employeeportalservice.cucumber.SpringIntegrationTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.kata.employee.employeeportalservice.cucumber.stepdefs.getlist"},
        tags = "not @Ignore and @employeelist")
public class EmployeeListFeatureRunnerIT extends SpringIntegrationTest {
}
