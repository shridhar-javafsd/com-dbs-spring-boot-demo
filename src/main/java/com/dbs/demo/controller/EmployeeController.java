package com.dbs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.demo.model.Employee;

@RestController
public class EmployeeController {

//	http://localhost:8082/emp
	@GetMapping("/emp")
	public Employee getEmp() {
		System.out.println("getEmp");
		return new Employee(101, "Sonu", 65000);

	}

}
