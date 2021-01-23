package com.kata.employee.employeeportalservice.controller;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

    @Test
    public void should_be_able_to_register_employee_in_employee_portal() throws Exception {
        Employee actual = new Employee();
        actual.setEmployeeId("1001");
        actual.setFirstName("Karthik");
        actual.setLastName("Ramasamy");
        actual.setGender("Male");
        actual.setDepartment("J1G");
        when(employeeService.registerEmployee(any(Employee.class))).thenReturn(actual);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/employees")
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(actual)))
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(actual)));
    }

}
