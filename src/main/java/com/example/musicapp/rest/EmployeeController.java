package com.example.musicapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicapp.entities.Employee;
import com.example.musicapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;
	
	//constructor injection
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.find(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee not exist with id: "+employeeId);
		}
		return theEmployee;

	}
	
	//add mapping for POST /emloyees
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		Employee theemployee = employeeService.save(employee);
		return employee;
	}
	
	//add mapping for PUT /employees
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
		return employeeService.update(employee, employeeId);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.find(employeeId);
		if(employee == null) {
			throw new RuntimeException();
		}
		employeeService.delete(employeeId);
	}
	
	
	
	
}
