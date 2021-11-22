package com.dbs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000/")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

//	@CrossOrigin(origins = "http://localhost:3000/")
//	http://localhost:8082/emp/getallemps
	@GetMapping("/getallemps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

//	@CrossOrigin(origins = "http://localhost:3003/")
	// http://localhost:8082/emp/get-emp/101
	@GetMapping("/get-emp/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee is available.");
		return new ResponseEntity<Employee>(empService.getEmployeeById(eid), headers, HttpStatus.OK);
	}

	// http://localhost:8082/emp/get-emp-by-name/Sonu
	@GetMapping("/get-emp-by-name/{firstname}")
	public ResponseEntity<List<Employee>> getEmpByFirstName(@PathVariable(name = "firstname") String firstName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee is available.");
		return new ResponseEntity<List<Employee>>(empService.getEmployeeByFirstName(firstName), headers, HttpStatus.OK);
	}

	// http://localhost:8082/emp/add-emp
	@PostMapping("/add-emp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee added successully.");
		return new ResponseEntity<Employee>(empService.addEmployee(employee), headers, HttpStatus.CREATED);
	}

//	http://localhost:8082/emp/update-emp/101 
	@PutMapping("/update-emp/{eid}")
	public ResponseEntity<Employee> updateEmp(@PathVariable(name = "eid") int eid, @RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee updated successully.");
		return new ResponseEntity<Employee>(empService.updateEmployee(eid, employee), headers, HttpStatus.OK);
	}

//	http://localhost:8082/emp/delete-emp/101 
	@DeleteMapping("/delete-emp/{eid}")
	public ResponseEntity<Integer> deleteEmp(@PathVariable(name = "eid") int eid) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee deleted successully.");
		return new ResponseEntity<Integer>(empService.deleteEmployee(eid), headers, HttpStatus.OK);
	}
}
