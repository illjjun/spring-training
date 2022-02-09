package com.human.train;

public class manager {
	private String name;
	private int emp_id;
	public manager(String name, int emp_id) {
		this.name = name;
		this.emp_id = emp_id;
	}
	public manager() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
}
