package com.ssafy.empapp.model.dto;

import java.util.List;

// Model : DTO, DO, AO
public class Dept {

	private int deptno;
	private String dname;
	private String loc;
	
	private List<Emp> emps; // 1:n
	
	public Dept() {
		System.out.println("Dept() ....");
	}
	
	public Dept(int deptNo, String dname, String loc) {
		super();
		this.deptno = deptNo;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
