package com.employeetest.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeetest.employee.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
