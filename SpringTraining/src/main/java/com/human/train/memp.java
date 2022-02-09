package com.human.train;

public class memp {
	private String name;
	private int emp_id;
	private String mobile;
	public memp(String name, int emp_id, String mobile) {
		this.name = name;
		this.emp_id = emp_id;
		this.mobile = mobile;
	}
	public memp() {
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
