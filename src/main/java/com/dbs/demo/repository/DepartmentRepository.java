package com.dbs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.demo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}