package com.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dept_id;
	
	@Column
	private String dept_name;
	
	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL)
	private List<Employee> employees;

	public Department(int dept_id, String dept_name, List<Employee> employees) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.employees = employees;
	}

	public Department() {
		super();
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", employees=" + employees + "]";
	}

}
