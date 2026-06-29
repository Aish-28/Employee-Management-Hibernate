package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PermanentEmp extends Employee {
	
	@Column
	private double bonus;

	public PermanentEmp(int emp_id, String name, double salary, Address addr, Department dept, double bonus) {
		super(emp_id, name, salary, addr, dept);
		this.bonus = bonus;
	}

	public PermanentEmp() {
		super();
	}

	public PermanentEmp(int emp_id, String name, double salary, Address addr, Department dept) {
		super(emp_id, name, salary, addr, dept);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "PermanentEmp [bonus=" + bonus + "]";
	}

}
