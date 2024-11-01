package com.employeetest.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeetest.employee.dto.UserDto;
import com.employeetest.employee.entity.Employee;
import com.employeetest.employee.entity.User;
import com.employeetest.employee.service.EmployeeService;
import com.employeetest.employee.service.UserService;

@Controller
@RequestMapping("/pages")
public class DashboardController {

    private UserService userService;

    private EmployeeService employeeService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
	public DashboardController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

    

    @GetMapping("/dashboard")
    public String  dashboard() {
        
        return "pages/dashboard";
    }

    // @GetMapping("/")
    // public String  mmDashboard(Model model) {

    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     String username = authentication.getName();

    //     User user = userService.findUserByEmail(username);
    //     model.addAttribute("user", user);

    //     return "layout";
    // }

    @GetMapping("/table-users")
    public String userTbale(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "pages/table-users";
    }

    @GetMapping("/data-employee")
    public String dataEmployee(Model model) {
       
		List<Employee> employees = employeeService.findAll();

		model.addAttribute("employees", employees);
       
        return "pages/data-employee";
    }

    @GetMapping("/update-employee/{id}")
    public String employeByid(@PathVariable Integer id, Model model) {

        model.addAttribute("employee", employeeService.getEmployeeById(id));

        return "pages/update-employee";
    }

    @PutMapping("/update-employee/{id}")
    public String editemployeByid(@PathVariable Integer id, Model model) {

       Employee employee = employeeService.getEmployeeById(id);
       model.addAttribute("employee", employee);

        return "pages/update-employee";
    }


    @GetMapping("/new-employee")
    public String employeeNew(Model model) {
        Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
    
        return "pages/new-employee";
    }
    

    @PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		return "redirect:/pages/data-employee";
	}

     @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/pages/data-employee";
    }
}
