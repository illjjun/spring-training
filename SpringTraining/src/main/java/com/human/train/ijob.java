package com.human.train;

import java.util.ArrayList;

public interface ijob {
	ArrayList<jobs> jobList();
	ArrayList<Empinfo> getList(String jobid); 
	ArrayList<deptinfo> getdept();
	ArrayList<dept> getdeList(int departid);
	ArrayList<manager> getManager();
	ArrayList<memp> getmemp(int managerid);
}
