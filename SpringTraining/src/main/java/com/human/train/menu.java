package com.human.train;

public class menu {
	private String name;
	private int price;
	private int code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public menu() {
		super();
	}

	public menu(String name, int price, int code) {
		super();
		this.name = name;
		this.price = price;
		this.code = code;
	}
	
	
	
}
