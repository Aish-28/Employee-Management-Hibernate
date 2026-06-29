package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ContractEmp extends Employee{

	@Column
	private int contractMonths;

	public ContractEmp(int emp_id, String name, double salary, Address addr, Department dept, int contractMonths) {
		super(emp_id, name, salary, addr, dept);
		this.contractMonths = contractMonths;
	}

	public ContractEmp(int emp_id, String name, double salary, Address addr, Department dept) {
		super(emp_id, name, salary, addr, dept);
	}

	public ContractEmp() {
		super();
	}

	public int getContractMonths() {
		return contractMonths;
	}

	public void setContractMonths(int contractMonths) {
		this.contractMonths = contractMonths;
	}

	@Override
	public String toString() {
		return "ContractEmp [contractMonths=" + contractMonths + "]";
	}
}
