package com.dbs.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int eid;
	private String firstName;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int eid, String firstName, double salary) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
	}

	public void work() {
		System.out.println("Employee works...");
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", salary=" + salary + "]";
	}

}
