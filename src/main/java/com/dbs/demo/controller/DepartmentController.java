package com.dbs.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.demo.model.Department;
import com.dbs.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DepartmentService depService;

	// side effect - 
	
	// http://localhost:8082/getalldeps
	
	@GetMapping("/getalldeps")
	public List<Department> getAllDeps() {
		LOG.info("Controller getAllDeps");
		return depService.getAllDepartments();
	}

	// http://localhost:8082/getdepbyid/11
	@GetMapping("/getdepbyid/{did}")
	public Department getDepById(@PathVariable(name = "did") int did) {
		LOG.info("Controller getDepById");
		return depService.getDepartmentById(did);
	}

	// http://localhost:8082/adddep
	@PostMapping("/adddep")
	public Department addDep(@RequestBody Department department) {
		LOG.info("Controller addDep");
		return depService.addDepartment(department);
	}

	// http://localhost:8082/updatedep
	@PutMapping("/updatedep")
	public Department updateDep(@RequestBody Department department) {
		LOG.info("Controller updateDep");
		return depService.updateDepartment(department);
	}

	@DeleteMapping("/deletedepbyid/{did}")
	public int deleteDepById(@PathVariable int did) {
		LOG.info("Controller deleteDepById");
		return depService.deleteDepartmentById(did);
	}

}
