package com.practise.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.model.Employee;
import com.practise.repository.EmployeeRepository;
@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmpolyeeList() {
		List <Employee> Empolyees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> Empolyees.add(employee));
		return Empolyees;	
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}
	
	public void updateEmployee(Employee employee,int id) {
	employeeRepository.save(employee);
	}
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}