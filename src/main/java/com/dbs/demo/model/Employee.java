package com.dbs.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

//lombac 
//@Getter
//@Setter 
//@COnstructor 
//@toString 

@Entity
@Table(name = "emp_table")
public class Employee implements Serializable {

	private static final long serialVersionUID = -9165581216674129315L;

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	@Column
	private String firstName;

	@Column
	private double salary;

	@Column
	// String also can be used if time is not required, only date is enough
//	private String joiningDate; // format dd-Mon-yyyy OR dd-mm-yyyy 
	private LocalDateTime joiningDate;

	@ManyToOne
	@JoinColumn(name = "did")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(int eid, String firstName, double salary) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int eid, String firstName, double salary, Department department) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
		this.department = department;
	}

	public Employee(String firstName, double salary, LocalDateTime joiningDate) {
		super();
		this.firstName = firstName;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	public Employee(String firstName, double salary, LocalDateTime joiningDate, Department department) {
		super();
		this.firstName = firstName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
	}

	public Employee(int eid, String firstName, double salary, LocalDateTime joiningDate, Department department) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", salary=" + salary + ", joiningDate="
				+ joiningDate + ", department=" + department + "]";
	}

}

//@Entity
//@Table(name = "emp_table")
//public class Employee implements Serializable {
//
//	private static final long serialVersionUID = -9165581216674129315L;
//
//	@Id // primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int eid;
//
//	@Column
//	private String firstName;
//
//	@Column
//	private double salary;
//
//	@ManyToOne
//	@JoinColumn(name = "did")
//	private Department department;
//
//	public Employee() {
//		super();
//	}
//
//	public Employee(int eid, String firstName, double salary) {
//		super();
//		this.eid = eid;
//		this.firstName = firstName;
//		this.salary = salary;
//	}
//
//	public Employee(int eid, String firstName, double salary, Department department) {
//		super();
//		this.eid = eid;
//		this.firstName = firstName;
//		this.salary = salary;
//		this.department = department;
//	}
//
//	public int getEid() {
//		return eid;
//	}
//
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [eid=" + eid + ", firstName=" + firstName + ", salary=" + salary + ", department=" + department
//				+ "]";
//	}
//
//}
