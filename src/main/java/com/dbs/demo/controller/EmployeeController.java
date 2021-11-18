package com.dbs.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

//	http://localhost:8082/emp/getallemps
	@GetMapping("/getallemps")
	public List<Employee> getAllEmps() {
		LOG.info("getAllEmps");
		return empService.getAllEmployees();
	}

	// http://localhost:8082/emp/get-emp/101
	@GetMapping("/get-emp/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmp");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee is available.");
		return new ResponseEntity<Employee>(empService.getEmployeeById(eid), headers, HttpStatus.OK);
	}

//	http://localhost:8082/emp/add-emp 
	@PostMapping("/add-emp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		LOG.info("addEmp");
		LOG.info(employee.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee added successully.");
		return new ResponseEntity<Employee>(empService.addEmployee(employee), headers, HttpStatus.CREATED);
	}

//	http://localhost:8082/emp/update-emp/101 
	@PutMapping("/update-emp/{eid}")
	public ResponseEntity<Employee> updateEmp(@PathVariable(name = "eid") int eid, @RequestBody Employee employee) {
		LOG.info("updateEmp");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee updated successully.");
		return new ResponseEntity<Employee>(empService.updateEmployee(eid, employee), headers, HttpStatus.OK);
	}

//	http://localhost:8082/emp/delete-emp/101 
	@DeleteMapping("/delete-emp/{eid}")
	public ResponseEntity<Integer> deleteEmp(@PathVariable(name = "eid") int eid) {
		LOG.info("updateEmp");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee deleted successully.");
		return new ResponseEntity<Integer>(empService.deleteEmployee(eid), headers, HttpStatus.OK);
	}

}
