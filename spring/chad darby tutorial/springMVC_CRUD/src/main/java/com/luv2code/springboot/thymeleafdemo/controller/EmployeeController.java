package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployeService;

	@Autowired
	EmployeeController(EmployeeService theEmployeService) {
		this.theEmployeService = theEmployeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> emps = theEmployeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", emps);

		return "list-employees";
	}

	@GetMapping("/form-add")
	public String addEmployees(Model theModel) {
		Employee emp = new Employee();
		theModel.addAttribute("employee", emp);
		return "form-add";
	}

	@GetMapping("/show-form-update")
	public String updateEmployee(@RequestParam("employeeId") int theID,Model theModel) {

		Employee employee = theEmployeService.findById(theID);

		theModel.addAttribute("employee", employee);

		return "form-add";

	}

	@PostMapping("/save")
	public String saveEmployees(@ModelAttribute("employee") Employee emp) {

		theEmployeService.save(emp);

		// see readme for why its used
		return "redirect:/employees/list";

	}

	// Why not Post? Because we are only accessing this URL through an <a> tag and not through a form, if form then Post mapping is used.
	@GetMapping("/delete")
	public String deleteEmployees(@RequestParam("employeeId") int theId) {

		theEmployeService.deleteById(theId);

		return "redirect:/employees/list";
	}
}









