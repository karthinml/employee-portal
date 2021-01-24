package com.kata.employee.employeeportalservice.helper;

import com.kata.employee.employeeportalservice.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.DATE_FORMAT;

public class EmployeePortalServiceTestHelper {

    public static Employee getSampleEmployeeData() throws ParseException {
        return Employee.builder().employeeId("1001").firstName("Karthik")
                .lastName("Ramasamy").gender("Male").dateOfBirth(new SimpleDateFormat(DATE_FORMAT).parse("08-16-1989"))
                .department("J1G").build();
    }
    public static Date getDateFromString(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException exception) {
            exception.fillInStackTrace();
        }
        return date;
    }

    public static List<Employee> transformDataTableToEmployeeList(List<Map<String, String>> dataTable) {
        return dataTable.stream().map(mapEntry -> new Employee(
                mapEntry.get("employeeId"),
                mapEntry.get("firstName"),
                mapEntry.get("lastName"),
                mapEntry.get("gender"),
                getDateFromString(mapEntry.get("dateOfBirth")),
                mapEntry.get("department")
        )).collect(Collectors.toList());
    }
}
