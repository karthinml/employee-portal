package com.kata.employee.employeeportalservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.employee.employeeportalservice.model.Employee;
import com.kata.employee.employeeportalservice.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.DATE_FORMAT;
import static com.kata.employee.employeeportalservice.helper.EmployeePortalServiceTestHelper.getSampleEmployeeData;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EmployeeService employeeService;

    private final String BASE_URL = "/api/v1/employees";

    @Test
    public void should_be_able_to_register_employee_in_employee_portal() throws Exception {
        when(employeeService.registerEmployee(any(Employee.class))).thenReturn(getSampleEmployeeData());
        mockMvc.perform(addEmployeeRequestBuilder(getSampleEmployeeData()))
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(getSampleEmployeeData())));
    }

    @Test
    public void should_return_exception_when_registering_employee_without_all_mandatory_attributes() throws Exception {
        Employee request = Employee.builder().employeeId("1001").firstName("Karthik")
                .lastName("Ramasamy").gender("Male").build();
        mockMvc.perform(addEmployeeRequestBuilder(request))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_get_empty_list_when_requesting_list_of_employees_in_employee_portal() throws Exception {
        mockMvc.perform(getEmployeesRequestBuilder())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(new ArrayList<Employee>())));
    }

    @Test
    public void should_get_list_of_employees_registered_in_employee_portal() throws Exception {
        ArrayList<Employee> expectedData = new ArrayList<>();
        expectedData.add(getSampleEmployeeData());
        when(employeeService.getEmployees()).thenReturn(expectedData);
        mockMvc.perform(getEmployeesRequestBuilder())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedData)));
    }

    private RequestBuilder addEmployeeRequestBuilder(Employee request) throws JsonProcessingException {
        return MockMvcRequestBuilders.post(BASE_URL)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request));
    }

    private RequestBuilder getEmployeesRequestBuilder() {
        return MockMvcRequestBuilders.get(BASE_URL).contentType(MediaType.APPLICATION_JSON);
    }
}
