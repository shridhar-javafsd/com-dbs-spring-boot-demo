package com.dbs.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.demo.model.Employee;
import com.dbs.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		return empRepository.findById(eid).get();
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee");
		return empRepository.save(employee); // insert
	}
}
