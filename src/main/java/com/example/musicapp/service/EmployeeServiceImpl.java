package com.example.musicapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.musicapp.dao.EmployeeRepository;
import com.example.musicapp.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee find(int  id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee employee = null;
		if(opt.isPresent()) {
			employee = opt.get();
		}
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public Employee update(Employee employee, int id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee tempEmployee = null;
		if(opt.isPresent()) {
			tempEmployee=opt.get();
		}
		employeeRepository.save(employee);
		return tempEmployee;
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id); 
	}

}
