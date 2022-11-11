package com.ssafy.empapp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept);

	List<Dept> getDepts(Map<String,Object> conditions) ;

	Dept getDept(int deptno);

	boolean modifyDept(Dept dept) ;

	boolean deleteDept(int deptNo);
	
	Dept getDeptWithEmps(int deptno) ;

}