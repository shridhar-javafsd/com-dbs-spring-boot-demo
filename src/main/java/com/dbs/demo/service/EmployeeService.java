package com.dbs.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dbs.demo.model.Employee;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		return new Employee(eid, "Sonu", 56000);
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee");
		return employee;
	}
}
