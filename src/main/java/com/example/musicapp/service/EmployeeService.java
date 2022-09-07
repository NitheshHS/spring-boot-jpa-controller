package com.example.musicapp.service;
import java.util.List;
import com.example.musicapp.entities.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	public Employee find(int id);

	public Employee save(Employee employee);

	public Employee update(Employee employee, int id);

	public void delete(int id);

}
