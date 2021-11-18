package com.dbs.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.demo.model.Employee;
import com.dbs.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService empService;

//	http://localhost:8082/emp/getemp/101
	@GetMapping("/getemp/{eid}")
	public Employee getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmp");
		return empService.getEmployeeById(eid);
	}

//	@GetMapping("/getemp/{did}/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int eid, @PathVariable(name = "did") int did) {

}
