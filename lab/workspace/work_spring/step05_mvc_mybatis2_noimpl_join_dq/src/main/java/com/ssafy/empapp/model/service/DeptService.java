package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept);

	List<Dept> getDepts() ;

	Dept getDept(int deptno);

	boolean modifyDept(Dept dept) ;

	boolean deleteDept(int deptNo);
	
	Dept getDeptWithEmps(int deptno) ;

	List<Dept> getDepts(String dname, String loc);

}