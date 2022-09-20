package com.example.musicapp.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.find(employeeId);
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee not found with Id: "+employeeId);
		}
		return new ResponseEntity<Employee>(theEmployee, HttpStatus.OK);

	}

	//add mapping for POST /emloyees
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		employee.setId(0);
		Employee theemployee = employeeService.save(employee);
		return new ResponseEntity<Employee>(theemployee, HttpStatus.CREATED);
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
			throw new EmployeeNotFoundException("Employee not found with Id: "+employeeId);
		}
		employeeService.delete(employeeId);
	}

	


}
