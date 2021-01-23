package com.kata.employee.employeeportalservice.repository;

import com.kata.employee.employeeportalservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findAllByOrderByFirstNameAsc();
    boolean existsByEmployeeId(String employeeId);
}
