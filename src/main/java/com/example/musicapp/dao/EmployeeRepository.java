package com.example.musicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicapp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
