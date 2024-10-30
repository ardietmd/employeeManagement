package com.employeetest.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeetest.employee.entity.Roles;



public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
