package com.ssafy.empapp.model.dto;

public class Dept {

	private int deptno;
	private String dname;
	private String loc;
	
	public Dept(int deptNo, String dname, String loc) {
		super();
		this.deptno = deptNo;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptNo() {
		return deptno;
	}

	public void setDeptNo(int deptNo) {
		this.deptno = deptNo;
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
	
	
}
