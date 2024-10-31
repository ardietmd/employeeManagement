package com.employeetest.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> 
                        authorize.requestMatchers("/register/**").permitAll()
                        .requestMatchers("/css/**", "/js/**","/images/**","/vendors/**").permitAll()
                        .requestMatchers("/index").permitAll()
                        .requestMatchers("/users").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/pages/dashboard").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/pages/table-users").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/pages/data-employee").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/pages/new-employee").hasRole("ADMIN")
                        .requestMatchers("/pages/update-employee/**").hasRole("ADMIN")
                        .requestMatchers("/pages/save").hasRole("ADMIN")
                        .requestMatchers("/pages/delete/**").hasRole("ADMIN")
                        .requestMatchers("/pages/delete").hasRole("ADMIN")
                      
                  
	
                ).formLogin(
                        form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/pages/dashboard")
                        .permitAll()
                ).logout(
                        logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
                );
   
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    
}
