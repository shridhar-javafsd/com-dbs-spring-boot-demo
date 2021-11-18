package com.dbs.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.demo.model.Employee;
import com.dbs.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	EmployeeService empService;

//	http://localhost:8082/emp
	@GetMapping("/emp")
	public Employee getEmp(int eid) {
		LOG.info("getEmp");
		return empService.getEmployeeById(eid);
	}
}
