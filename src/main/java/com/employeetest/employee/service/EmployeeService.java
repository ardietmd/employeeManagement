package com.employeetest.employee.service;

import java.util.List;

import com.employeetest.employee.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> search(String name);

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Integer id);
    
}
