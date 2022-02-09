package com.human.train;

public class dept {
	private int did;
	private String dname;
	private String mobile;
	private int salary;
	public dept(int did, String dname, String mobile, int salary) {
		this.did = did;
		this.dname = dname;
		this.mobile = mobile;
		this.salary = salary;
	}
	public dept() {
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
