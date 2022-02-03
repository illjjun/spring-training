package com.human.train;

import java.util.ArrayList;

public interface iEmp {
	ArrayList<Employee> getEmpList();
	ArrayList<countries> getCountries();
	ArrayList<joincon> getjoinCon();
	void addMenu(String menu_name,int price);
	void addRoom(String name,int type,int howmany,int howmuch);
	void addType(int typecode,String name);
	ArrayList<Room> getRoom();
}
