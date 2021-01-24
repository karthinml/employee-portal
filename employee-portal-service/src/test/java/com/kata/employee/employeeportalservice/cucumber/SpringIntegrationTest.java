package com.kata.employee.employeeportalservice.cucumber;

import com.kata.employee.employeeportalservice.EmployeePortalServiceApplication;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeePortalServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {

    protected RestTemplate restTemplate = new RestTemplate();

    protected String EMPLOYEE_SERVICE_URL = "http://localhost:8080/api/v1/employees";
}
