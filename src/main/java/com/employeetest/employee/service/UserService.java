package com.employeetest.employee.service;

import java.util.List;

import com.employeetest.employee.dto.UserDto;
import com.employeetest.employee.entity.User;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
    
}
