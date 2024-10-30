package com.employeetest.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeetest.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // List<Employee> findByNameContaining(String name);
}
