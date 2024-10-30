package com.employeetest.employee.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "cannot be empty")
    private String name;
    @NotEmpty(message = "cannot be empty")
    private String pendidikan;
    @NotEmpty(message = "cannot be empty")
    private String riwayatpelatihan;
    @NotEmpty(message = "cannot be empty")
    private String riwayatpekerjaan;
    
}
