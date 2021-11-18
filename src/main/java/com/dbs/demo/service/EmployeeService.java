package com.dbs.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.demo.exception.EmployeeNotFoundException;
import com.dbs.demo.model.Employee;
import com.dbs.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		Optional<Employee> employeeOptional = empRepository.findById(eid);
		if (employeeOptional.isPresent())
			return employeeOptional.get();
		throw new EmployeeNotFoundException("This employee does not exist.");
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee");
		return empRepository.save(employee); // insert
	}

}
