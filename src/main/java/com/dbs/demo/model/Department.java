package com.dbs.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dep_table")
public class Department implements Serializable {

	private static final long serialVersionUID = -777826216252556657L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;

	@Column
	private String departmentName;

	public Department() {
		super();
	}

	public Department(int did, String departmentName) {
		super();
		this.did = did;
		this.departmentName = departmentName;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", departmentName=" + departmentName + "]";
	}

}
