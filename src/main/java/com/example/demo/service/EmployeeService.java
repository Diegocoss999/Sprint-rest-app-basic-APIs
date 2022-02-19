package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;


public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByIndex(long id);
	public Employee updateEmplyeeByIndex(Employee emp, long id);
	void deleteEmployeeByIndex(long id);
}
