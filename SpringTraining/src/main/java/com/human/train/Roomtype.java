package com.human.train;

public class Roomtype {
	private int typecode;
	private String name;
	public Roomtype(int typecode, String name) {
		super();
		this.typecode = typecode;
		this.name = name;
	}
	public Roomtype() {
		super();
	}
	public int getTypecode() {
		return typecode;
	}
	public void setTypecode(int typecode) {
		this.typecode = typecode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
