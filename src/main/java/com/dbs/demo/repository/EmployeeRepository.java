package com.dbs.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbs.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	public abstract List<Employee> findByExistingFieldNameInModelClass(that field);
	// public abstract List<Employee> findByLastName(String firstName);

	public abstract List<Employee> findByFirstName(String firstName);

	public abstract List<Employee> findBySalaryGreaterThan(double salary);

	public abstract List<Employee> findBySalaryLessThan(double salary);

//	public abstract List<Employee> findBySalaryBetween(double salary1, double salary2);

	@Query(name = "SELECT e FROM Employee WHERE e.salary BETWEEN ?1 AND ?2") // JPQL
	public abstract List<Employee> findBySalaryBetween(double salary1, double salary2);
}
