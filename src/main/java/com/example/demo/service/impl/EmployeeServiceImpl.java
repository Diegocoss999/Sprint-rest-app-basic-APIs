package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByIndex(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp  =employeeRepository.findById(id);
		if (emp.isPresent())
			return emp.get();
		throw new ResourceNotFoundException("Employee","id", id);
	}

	@Override
	public Employee updateEmplyeeByIndex(Employee emp, long id) {
		// TODO Auto-generated method stub
		//does employee exist
		Optional<Employee> found = employeeRepository.findById(id);
		if (!found.isPresent())
			throw new ResourceNotFoundException("Employee","id", id);
		//create and save employee to repo
		Employee old = found.get();
		old.setFirstName(emp.getFirstName());
		old.setEmail(emp.getEmail());
		old.setLastName(emp.getLastName());
		employeeRepository.save(old);
		return old;
	}

	@Override
	public void deleteEmployeeByIndex(long id) {
		//does emplyee exist
		Optional<Employee> found = employeeRepository.findById(id);
		if (!found.isPresent())
			throw new ResourceNotFoundException("Employee","id", id);
		//delete found employee
		employeeRepository.deleteById(id);
	}
}
