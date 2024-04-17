package com.practise.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import com.practise.model.Employee;
import com.practise.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping("/check")
	private String Check(Model model) {
		System.out.println("check");
		model.addAttribute("message", "Welcome to full stack");
		return "employee";
	}
	@GetMapping("/empolyeeList") 
	public String empolyeeList(Model model)
	{
		
		System.out.println("employeeList");
		model.addAttribute("employees", employeeService.getEmpolyeeList());
		return "employee";
		
	}
	
	@GetMapping("/employee/create")
	private String saveEmployee(Model model){
		Employee employee = new Employee();
		System.out.println("saveEmployee");
		model.addAttribute("employee",employee);
		return "createEmployee";
		
	}
	
	@PostMapping("/saveEmployeeData")
	public String saveEmployee(@ModelAttribute("employee")Employee employee){
		employeeService.addEmployee(employee);
		return "redirect:/empolyeeList";
	}
	
	@GetMapping("/employee/edit/{id}") 
	public String updateEmployee(@PathVariable("id") int id,Model model){
		model.addAttribute("employee",employeeService.getEmployee(id));
		return "updateEmployee";
		
	}
	
	@PostMapping("/update/employee/{id}")
	public String updateEmployeeData(@PathVariable("id") int id,@ModelAttribute("employee") Employee employee,Model model ) {
		System.out.println(id);
		Employee existingEmployee = employeeService.getEmployee(id);
		existingEmployee.setId(employee.getId());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setExperience(employee.getExperience());
		existingEmployee.setSalary(employee.getSalary());
		
		employeeService.updateEmployee(existingEmployee, id);
		
		return "redirect:/empolyeeList";
		
	}

	@GetMapping("/deleteEmployee/{id}") 
	public String deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		System.out.println("delete");
		return "redirect:/empolyeeList";
		
	}
	
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id")int id)  {
		System.out.println(id);
		return employeeService.getEmployee(id);
	}
	
}