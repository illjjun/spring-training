package com.human.train;

public class joincon {
	private String de_id;
	private String de_name;
	private String upde_na;
	private String manager_name;
	
	
	
	
	public String getDe_id() {
		return de_id;
	}


	public void setDe_id(String de_id) {
		this.de_id = de_id;
	}


	public String getDe_name() {
		return de_name;
	}


	public void setDe_name(String de_name) {
		this.de_name = de_name;
	}


	public String getUpde_na() {
		return upde_na;
	}


	public void setUpde_na(String upde_na) {
		this.upde_na = upde_na;
	}


	public String getManager_name() {
		return manager_name;
	}


	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}


	public joincon() {
	}


	public joincon(String de_id, String de_name, String upde_na, String manager_name) {
		this.de_id = de_id;
		this.de_name = de_name;
		this.upde_na = upde_na;
		this.manager_name = manager_name;
	}
	
	
}
