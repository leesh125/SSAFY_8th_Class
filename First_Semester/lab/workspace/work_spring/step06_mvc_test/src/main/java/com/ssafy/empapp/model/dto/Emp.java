package com.ssafy.empapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;	
	private double sal;
	private double comm;	
	private int	deptno;
	
	private Dept dept;
	
}
