package com.employeetest.employee.config;


import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

public class MvcConfiguration implements WebMvcConfigurer {
 

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }


    
}
