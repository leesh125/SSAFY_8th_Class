package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept);

	List<Dept> getDepts();

	Dept getDept(int deptno);

	boolean deleteDept(int deptno);

	boolean updateDept(Dept dept);

	Dept getDEptWithEmps(int deptno);
}