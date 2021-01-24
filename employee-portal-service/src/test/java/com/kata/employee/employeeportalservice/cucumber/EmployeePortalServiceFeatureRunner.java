package com.kata.employee.employeeportalservice.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"com.kata.employee.employeeportalservice.cucumber.setpdefs"},
        tags = "not @Ignore")
public class EmployeePortalServiceFeatureRunner {
}
